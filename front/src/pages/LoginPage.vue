<template>
<div id="login-container">
    <div id="login-card">
        <img id="login-content-img" src="img/favicon.png">
        <h1> K-COLOSSEUM 로그인 </h1>
        <h2> 이메일 로그인 </h2>
        <div id="login-form">
            <div> <input type="email" id="email-input" placeholder="Email Address"> </div>
            <div> <input type="password" id="password-input" placeholder="Password"> </div>
        </div>

        <button id="login-btn">
            <div class="loading-spinner mr-2 h-6 w-6 bg-white hidden"></div>로그인
        </button>

        <div id="additional-function">
            <a href="/member/recovery_password" class="text-rg font-medium text-white hover:text-psbl-light">비밀번호 찾기</a>
            <p class="flex-shrink-0 flex-grow-0 text-center text-rg font-medium text-white">|</p> <a href="/join" class="text-rg font-medium text-white hover:text-psbl-light">이메일 회원가입</a>
        </div>
    </div>
</div>
</template>


<script>

</script>

<style scoped>
    @import '../css/page-login.css'
</style>
