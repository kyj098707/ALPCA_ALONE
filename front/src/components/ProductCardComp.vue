<template>

    <card>
        <product-card>
        <h1 id="product-title"> {{ title }} </h1>
        <img id="card-image" :src= "image">
        <h3> 작품 정보 </h3>
        <div class="product-infobox">
            <h3>등급: {{ rating }}</h3>
            <h3>순위: {{ rank }}</h3>
            <h3>타입: 드라마</h3>
            <h3>장르: {{ genre }}</h3>
            <div id="additional-function">
                <a href="/member/recovery_password" class="text-rg font-medium text-white hover:text-psbl-light">상세정보</a>
                <p class="flex-shrink-0 flex-grow-0 text-center text-rg font-medium text-white">|</p> <a href="/join" class="text-rg font-medium text-white hover:text-psbl-light">볼 작품 등록</a>
            </div>

        </div>
</product-card>
</card>

</template>

<script>
import card from './CardComp.vue';

export default {
    components: {
        card,
    },
    props: {
    title: {
      type: String,
      required: true
    },
    image: {
      type: String,
      required: true
    },
    rating: {
      type: String,
      required: true
    },
    rank: {
      type: Number,
      required: true
    },
    type: {
      type: String,
      required: true
    },
    genre: {
      type: String,
      required: true
    },
    detailLink: {
      type: String,
      required: true
    },
    registerLink: {
      type: String,
      required: true
    }
  },
    data() {
        return {    

        };
    },
};
</script>

<style scoped>
@import "../css/comp-productcard.css"
</style>
