<template>
<swiper :slidesPerView="3" :spaceBetween="30" :pagination="{
      clickable: true,
    }" :modules="modules" class="mySwiper">
    <swiper-slide>
        <productcard>
            Slide 1
        </productcard>
    </swiper-slide>
    <swiper-slide>
        <productcard>
            Slide 2
        </productcard>
    </swiper-slide>
    <swiper-slide>
        <productcard>
            Slide 3
        </productcard>
    </swiper-slide>

    <swiper-slide>
        <productcard>
            Slide 4
        </productcard>
    </swiper-slide>
    <swiper-slide>
        <productcard>
            Slide 5
        </productcard>
    </swiper-slide>
    <swiper-slide>
        <productcard>
            Slide 6
        </productcard>
    </swiper-slide>
</swiper>
</template>

<script>
import productcard from './ProductCardComp.vue';
import {
    Swiper,
    SwiperSlide
} from 'swiper/vue';
import 'swiper/css'
import 'swiper/css/navigation';
import 'swiper/css/pagination';
import 'swiper/css/scrollbar';
import { Pagination } from 'swiper/modules';

export default {
    components: {
        Swiper,
        SwiperSlide,
        productcard,
    },
    data() {
        return {
          modules: [Pagination],
        };
    },
};
</script>

<style scoped>

.swiper {
  width: 100%;
  height: 100%;
}



.swiper-slide img {
  display: block;
  width: 100%;
  height: 100%;
  object-fit: cover;
}

img {
    max-width: 100%;
    height: auto;
}

</style>
