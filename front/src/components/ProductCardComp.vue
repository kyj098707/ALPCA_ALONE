<template>
<card>
    <product-card>
        <div class="card-info-container">
            <div class="card-image-container">
                <img id="card-image" :src="image">
                <div class="dimmed"></div>
            </div>
            <div class="card-header-container">
                <h3 class="card-header-table">Rating</h3>
                <h3 class="card-header-score">{{ rating }}</h3>
                <h3 class="card-header-table">Rank</h3>
                <h3 class="card-header-score">{{ rank }}</h3>
                <h3 class="card-header-table">Type</h3>
                <h3 class="card-header-score">Drama</h3>
                <h3 class="card-header-table">Genre</h3>
                <h3 class="card-header-score">{{ genre }}</h3>
                    
                <!-- <div id="additional-function">
                    <a href="/member/recovery_password" class="text-rg font-medium text-white hover:text-psbl-light">상세정보</a>
                    <p class="flex-shrink-0 flex-grow-0 text-center text-rg font-medium text-white">|</p> <a href="/join" class="text-rg font-medium text-white hover:text-psbl-light">볼 작품 등록</a>
                </div> -->

            </div>
        </div>
        <div class="card-title-container">
        <h3> {{title}} </h3>
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
