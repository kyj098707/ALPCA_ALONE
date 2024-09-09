<template>
<div id="search-container">
    <div id="search-box">
        <input type="search" id="default-search" placeholder="작품 검색하기" v-model="searchQuery" @input="fetchSuggestions" />
        <ul v-if="suggestions.length" id="suggestions-list">
            <li v-for="(suggestion, index) in suggestions" :key="index" @click="selectSuggestion(suggestion)">
                {{ suggestion.title }}
            </li>
        </ul>
    </div>
    <div id="hot-keyword-container">
        <span>실시간 검색어</span>
        <div id="keyword">
            <a id="ranking_num">1</a>
            <a>미스터 선샤인</a>
        </div>
    </div>
</div>
<div id="card-container">
    <div id="card-container-title">
        <h2>
            주목해야 할 작품
            <small>{{ formattedTime }} 한국시간 기준</small>
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
import axios from 'axios';
import SwiperComp from '../components/SwiperComp.vue';

export default {
    data() {
        return {
            currentTime: new Date(),
            searchQuery: '', // 검색창의 입력값
            suggestions: [] // 자동 완성 결과 목록
        };
    },
    computed: {
        formattedTime() {
            const koreaOffset = 9 * 60;
            const utc = this.currentTime.getTime() + this.currentTime.getTimezoneOffset() * 60000;
            const koreaTime = new Date(utc + koreaOffset * 60000);

            const day = koreaTime.getDate().toString().padStart(2, '0');
            const month = (koreaTime.getMonth() + 1).toString().padStart(2, '0');
            const hours = koreaTime.getHours().toString().padStart(2, '0');
            const minutes = koreaTime.getMinutes().toString().padStart(2, '0');

            return `${month}-${day} ${hours}:${minutes}`;
        }
    },
    methods: {
        async fetchSuggestions() {
            const token = localStorage.getItem('jwtToken');
            if (this.searchQuery.length > 2) {
                try {
                    const response = await axios.get(`http://localhost:8080/product/contain?query=${this.searchQuery}`,
                    {headers: {
                    'Authorization': token
                }});
                    this.suggestions = response.data; // 서버에서 받은 데이터를 suggestions 배열에 저장
                } catch (error) {
                    console.error('자동 완성 요청 실패:', error);
                }
            } else {
                this.suggestions = []; // 검색어가 짧을 경우 자동 완성 목록을 비움
            }
        },
        selectSuggestion(suggestion) {
            this.searchQuery = suggestion.title; // 선택한 검색어로 검색창 값 변경
            this.suggestions = []; // 검색창에 선택된 값이 입력되면 자동완성 목록 닫기
        }
    },
    components: {
        SwiperComp
    },
    mounted() {
        setInterval(() => {
            this.currentTime = new Date();
        }, 1000);
    }
};
</script>

<style scoped>
@import "../css/page-main.css";
</style>
