<template>
<div id="search-container">
    <div id="search-box"> <input type="search" id="default-search" placeholder="작품 검색하기"> </div>
    <div id="hot-keyword-container">
        <span>실시간 검색어</span>
        <div id="keyword">
            <a id="ranking_num"> 1</a>
            <a>미스터 선샤인</a>
        </div>
    </div>
</div>
<div id="card-container">
    <div id="card-container-title">
        <h2>
            주목해야 할 작품
            <small>
                08-21 09:21 한국시간 기준
            </small>
        </h2>
    </div>
    <swiper-container>
        <SwiperComp />
    </swiper-container>

</div>
<div id="make-tier-container">
</div>
</template>

<script>
import SwiperComp from '../components/SwiperComp.vue';

export default {
    components: {
        SwiperComp,
    },
};
</script>

<style scoped>
#search-container {
    padding: 60px 80px 40px 80px;
    justify-content: center;
    align-items: center;
    display: flex;
    margin-left: auto;
    margin-right: auto;

}

#search-box {
    height: 56px;
    width: 479px;
    box-sizing: border-box;
    border-width: 0;
    border-style: solid;
    border-color: #e5e7eb;
}

#keyword {
    padding: 4px 4px 4px 4px;
}

#hot-keyword-container {
    height: 56px;
    width: 240px;
    padding-left: 16px;
    padding-right: 8px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

#hot-keyword-container span {
    color: rgb(193 197 202 / 1);
    font-weight: 700;
    font-size: 14px;
    gap: 4px;
    align-items: center;
    display: inline-flex
}

#hot-keyword-container div {
    display: inline-flex;
    height: 32px;
    width: 240px;
    border-radius: 4px;
    background-color: rgb(33 58 150/1);
    align-items: center;
    text-align: center;
    color: white;
    font-size: 14px;
    line-height: 20px;
    box-sizing: border-box;
    font-family: GmarketSansMedium;
}

#default-search {
    font-family: GmarketSansMedium;
    color: rgb(53 57 69 /1);
    background-color: white;
    font-weight: 500;
    font-size: 16px;
    line-height: 24px;
    width: 100%;
    height: 100%;
    border-radius: 8px;

    padding: 8px 40px 8px 12px;
    box-sizing: border-box;
}

#ranking_num {
    margin-right: 4px;
    display: inline-block;
    height: 20px;
    width: 20px;
    text-align: center;
    border-radius: 4px;
    background-color: white;
    align-items: center;
    color: rgb(33 58 150/1);
    font-family: GmarketSansMedium;
}

#hot-keyword-container {
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    font-size: 14px;
    line-height: 20px;
    text-align: center;
}

#card-container {
    overflow-x: hidden;
}

#card-container-title {
    padding-left: 16px;
    padding-right: 16px;
    justify-content: space-between;
    flex-direction: row;
    display: flex;
    max-width: 1280px;
}

#card-container-title h2 {
    font-family: GmarketSansMedium;
    font-size: 20px;
    line-height: 25px;
    color: white;
    font-weight: 700;
    gap: 8px;
}

#card-container-title h2 small {
    font-family: GmarketSansMedium;
    opacity: .7;
    font-weight: 400;
    font-size: 80%;
}
/* swiper-container {
    margin-top: 16px;
    height: 100%;
    width: 100vw;
    min-width: 1248px;
    max-width: 1248px;
    overflow: visible !important;
    color: white;
    touch-action: pan-y;
    list-style: none;
    z-index: 1;
    display: block;
}

swiper-slide {
    margin-top: 146px;
    height: 240px;
    width: 180px;
    overflow: hidden;
    border-radius: 8px;
    transform: translateZ(0);
    backface-visibility: hidden;

} */
</style>
