<template>
<div id="login-container">  
    <div id="login-card">
        <img id="login-content-img" src="img/favicon.png">
        <h1> KTier 로그인 </h1>
        <h2> 아이디로 로그인 </h2>
        <div id="login-form">
            <div> <input type="username" v-model="username" id="username-input" placeholder="Username"> </div>
            <div> <input type="password" v-model="password" id="password-input" placeholder="Password"> </div>
        </div>

        <button id="login-btn" @click="handleLogin">
            <div ></div>로그인
        </button>

        <div id="additional-function">
            <a href="/member/recovery_password">비밀번호 찾기</a>
            <p>|</p> <a href="/join" class="text-rg font-medium text-white hover:text-psbl-light">이메일 회원가입</a>
        </div>
    </div>
</div>
</template>


<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useAuthStore } from '@/stores/auth';
import { useRouter } from 'vue-router';
const authStore = useAuthStore();
const router = useRouter();

const username = ref('');
const password = ref('');

const handleLogin = async () => {
  try {
    const formData = new FormData();
    formData.append('username', username.value);
    formData.append('password', password.value);

    const response = await axios.post('http://localhost:8080/login', formData, {
      headers: { 'Content-Type': 'multipart/form-data' }
    });

    const token = response.headers['authorization'];
    if (token) {
      authStore.setToken(token);  // Pinia 스토어에 토큰 저장
      router.push('/');  // 로그인 후 홈으로 이동
    } else {
      console.error('로그인 실패: 토큰이 응답에 없습니다.');
    }
  } catch (error) {
    console.error('로그인 실패', error);
  }
};
</script>

<style scoped>
    @import '../css/page-login.css'
</style>
