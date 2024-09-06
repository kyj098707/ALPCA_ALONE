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
            <li v-if="user"> Hello, {{ user }}</li>
            <li v-else>
                <router-link to="/login">Login</router-link>
            </li>
        </div>
    </div>
</nav>
</template>

<script>

</script>

<style scoped>
@import "../css/comp-header.css";
</style>
