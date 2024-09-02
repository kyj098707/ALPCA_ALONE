<template>
<div id="search-container">
    <div id="search-box"> <input type="search" id="default-search" placeholder="작품 검색하기">  </div>
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
                {{ formattedTime }} 한국시간 기준
            </small>
        </h2>
    </div>
    <swiper-container>
        <SwiperComp />
    </swiper-container>

</div>
<div id="make-tier-container">
    <a href="/tier">
        <button>
            <div></div> 티어표 만들기
        </button>
    </a>
</div>
</template>

<script>
import SwiperComp from '../components/SwiperComp.vue';

export default {
    data() {
        return {
            currentTime: new Date()
        };
    },
    computed: {
        formattedTime() {
            const koreaOffset = 9 * 60;
            const utc = this.currentTime.getTime() + (this.currentTime.getTimezoneOffset() * 60000);
            const koreaTime = new Date(utc + (koreaOffset * 60000));

            const day = koreaTime.getDate().toString().padStart(2, '0');
            const month = (koreaTime.getMonth() + 1).toString().padStart(2, '0');
            const hours = koreaTime.getHours().toString().padStart(2, '0');
            const minutes = koreaTime.getMinutes().toString().padStart(2, '0');

            return `${month}-${day} ${hours}:${minutes}`;
        }
    },
    components: {
        SwiperComp,
    },
      mounted() {
    setInterval(() => {
      this.currentTime = new Date();
    }, 1000);
  }
};
</script>

<style scoped>  
@import "../css/page-main.css"
</style>
