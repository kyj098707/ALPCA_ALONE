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

        <button id="login-btn" @click="login">
            <div ></div>로그인
        </button>

        <div id="additional-function">
            <a href="/member/recovery_password">비밀번호 찾기</a>
            <p class="flex-shrink-0 flex-grow-0 text-center text-rg font-medium text-white">|</p> <a href="/join" class="text-rg font-medium text-white hover:text-psbl-light">이메일 회원가입</a>
        </div>
    </div>
</div>
</template>


<script>
import axios from "axios";

export default {
    data() {
        return {
            username: '',
            password: '',
        };
    },
    methods: {
        async login() {
            try {
                const formData = new FormData();
                formData.append('username', this.username);
                formData.append('password', this.password);

                const response = await axios.post('http://localhost:8080/login', formData, {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                });
                const token = response.headers['authorization'];
                if (token) {
                    // 로컬 스토리지에 JWT 토큰 저장
                    localStorage.setItem('jwtToken', token);
                    this.$router.push('/');
                } else {
                    console.log('로그인 실패: JWT 토큰이 응답에 없습니다.');
                }


                this.$router.push('/');
                console.log(response);
            } catch (error) {
                console.log("로그인 실패", error);
            }
        }
    }
};

</script>

<style scoped>
    @import '../css/page-login.css'
</style>
