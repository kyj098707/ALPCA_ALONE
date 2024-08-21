<template>
<product-card>
    <card>
        <h1 id="product-title"> 나의 아저씨 </h1>
        <h3> 작품 정보 </h3>
        <div class="product-infobox">
            <h3> 등급 : A+ </h3>
            <h3> 순위 : 13 </h3>
            <h3> 타입 : 웹툰 </h3>
            <h3> 장르 : 액션 </h3>
            <div id="additional-function">
                <a href="/member/recovery_password" class="text-rg font-medium text-white hover:text-psbl-light">상세정보</a>
                <p class="flex-shrink-0 flex-grow-0 text-center text-rg font-medium text-white">|</p> <a href="/join" class="text-rg font-medium text-white hover:text-psbl-light">볼 작품 등록</a>
            </div>

        </div>
    </card>
</product-card>
</template>

<script>
import card from './CardComp.vue';

export default {
    components: {
        card,
    },
    data() {
        return {

        };
    },
};
</script>

<style scoped>
#product-title {
    font-family: GmarketSansMedium;
    font-weight: 700;
    color: white;
    font-size: 24px;
    text-align: center;
    align-self: stretch;
    flex-grow: 0;
    flex-shrink: 0;
}

card h3{
    font-family: GmarketSansMedium;
    font-weight: 700;
    color: white;
    font-size: 16px;
    text-align: center;
    align-self: stretch;
    flex-grow: 0;
    flex-shrink: 0;
}
.product-infobox {
    padding: 0px 20px 0px 20px;

}
.product-infobox h2 {
    font-family: GmarketSansMedium;
    font-weight: 500;
    color: rgb(218 223 231 / 1);
    font-size: 14px;
    line-height: 20px;
    text-align: center;
    align-self: stretch;
    flex-grow: 0;
    flex-shrink: 0;
}

.product-infobox h3 {
    font-family: GmarketSansMedium;
    font-weight: 500;
    color: rgb(218 223 231 / 1);
    font-size: 16px;
    line-height: 15px;
    text-align: center;
    align-self: stretch;
    flex-grow: 0;
    flex-shrink: 0;
}



#additional-function {
    align-self: stretch;
    gap: 8px;
    justify-content: space-around;
    display: flex;
    flex-grow: 0;
    flex-shrink: 0;
}

#additional-function a {
    align-items: center;
    font-family: GmarketSansMedium;
    font-size: 14px;
    line-height: 20px;
    font-weight: 500;
    color: white;
    text-decoration: inherit;
    display: flex;
}

#additional-function p {
    text-align: center;
    color: white;
    font-size: 14px;
    line-height: 20px;
}
</style>
