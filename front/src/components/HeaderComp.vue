<template>
<nav id="menu-container">
    <div id="menu-content">
        <div id="logo-content">
            <a href="/">
                <img id="logo-content-img" src="img/logo.png" href="/home">
            </a>
        </div>
        <div id="main-content">
            <a href="/drama/ranking">드라마 랭킹</a>
            <a href="/movie/ranking">영화 랭킹</a>
            <a href="/webtoon/ranking">웹툰 랭킹</a>
            <a href="/recommendation">추천</a>
        </div>
        <div id="login-content">
            
            <a v-if="user"> <router-link to="/mytier"> 내 티어표</router-link> 안녕하세요, {{ user }}님 | <small @click="logout">로그아웃</small></a>
            <a v-else>
                <router-link to="/login">로그인</router-link>
            </a>
        </div>
    </div>
</nav>
</template>

<script setup>
import {
    computed
} from 'vue';
import { useRouter } from 'vue-router';
import {
    useAuthStore
} from '@/stores/auth';
const router = useRouter();
const authStore = useAuthStore();
const user = computed(() => authStore.user);
const logout = () => {
    authStore.logout(); 
    router.push('/login');
}
</script>

<style scoped>
@import "../css/comp-header.css";
</style>
