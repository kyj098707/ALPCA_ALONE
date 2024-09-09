<template>
<swiper :slidesPerView="4" :spaceBetween="30" :pagination="{
      clickable: true,
    }" :modules="modules" :autoplay="{ delay: 2000, disableOnInteraction: false }" class="mySwiper">
    <swiper-slide v-for="(product, index) in products" :key="index">
        <productcard :title="product.title" :image="product.imageUrl" :rating="product.rating" :rank="product.rank" :type="product.type" :genre="product.genre" :detailLink="product.detailLink" :registerLink="product.registerLink"></productcard>
    </swiper-slide>
</swiper>
</template>

<script>
import axios from "axios";
import productcard from './ProductCardComp.vue';
import {
    Swiper,
    SwiperSlide
} from 'swiper/vue';
import 'swiper/css'
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/scrollbar';
import {
    Pagination,
    Autoplay
} from 'swiper/modules';

export default {
    mounted() {
        const token = localStorage.getItem('jwtToken');
        axios.get("http://localhost:8080/product/trending", {
                headers: {
                    'Authorization': token
                }
            })
            .then(response => {
                this.products = response.data;
            })
            .catch(error => {
                console.log(error)
            })
    },
    components: {
        Swiper,
        SwiperSlide,
        productcard,
    },
    data() {
        return {
            modules: [Pagination,Autoplay],
            products: []
        };
    },

};
</script>

<style scoped>
@import "../css/comp-swiper.css"
</style>
