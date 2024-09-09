<template>
<div id="join-container">
    <img id="join-content-img" src="img/favicon.png">
    <div id="join-card">
        <form @submit.prevent="submitForm">
            <h1> 이메일 회원가입 </h1>
            <h2> KTier에 이메일 계정으로 회원가입 </h2>
            <div id="join-form">

                <div> 닉네임 </div>
                <div> <input v-model="form.username" id="username" placeholder="사용할 닉네임"> </div>
                <div> 이메일 </div>
                <div> <input v-model="form.email" id="email" placeholder="로그인에 사용될 이메일"> </div>
                <div> 비밀번호 </div>
                <div> <input v-model="form.password" type="password" id="password" placeholder="특수문자 포함 10자리"> </div>
                <div> 비밀번호 확인 </div>
                <div> <input v-model="form.passwordConfirm" type="password" id="passwordConfirm" placeholder="비밀번호 확인"> </div>
                <div> 성별 </div>
                <div> <input v-model="form.gender" id="gender" placeholder="남/여"> </div>

            </div>
            <div id="join-agreement">

                <div class="join-agreement-line">
                    <div class="agreement-line-content">
                        <input id="is-term-checked" name="is-term-checked" type="checkbox" class="checkbox">
                        <label for="is-term-checked"></label>
                        <div>
                            <a href="https://lol.ps/terms?tab=use" target="_blank">이용약관</a><span>에 동의합니다. (필수)</span>
                        </div>
                    </div>
                </div>
                <div class="join-agreement-line">
                    <div class="agreement-line-content">
                        <input id="is-required-privacy-checked" name="is-required-privacy-checked" type="checkbox" class="checkbox">
                        <label for="is-required-privacy-checked"></label>
                        <div class="text-rg">
                            <a href="https://lol.ps/terms/agreement?tab=required_privacy" target="_blank">개인정보 수집 및 이용</a>
                            <span>에 동의합니다. (필수)</span>
                        </div>
                    </div>
                </div>
                <button type="submit">
                    <div></div> 회원가입
                </button>
                
            </div>
        </form>
    </div>
</div>
</template>

<script setup>
import { ref } from 'vue';
import axios from 'axios';
import { useRouter } from 'vue-router';

const router = useRouter();
const form = ref({
    username: '',
    email: '',
    password: '',
    passwordConfirm: '',
    gender: ''
});

const submitForm = async () => {
    if (form.value.password !== form.value.passwordConfirm) {
        alert('비밀번호가 일치하지 않습니다.');
        return;
    }

    try {
        const response = await axios.post('http://localhost:8080/join', form.value);
        router.push('/login');
        console.log(response);
    } catch (error) {
        console.log(error);
        alert("회원가입 실패");
    }
};
</script>


<style scoped>
@import '../css/page-join.css'
</style>
