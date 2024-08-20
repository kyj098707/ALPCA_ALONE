<template>
<div id="login-container">
    <div id="login-card">
        <img id="login-content-img" src="img/favicon.png">
        <h1> K-COLOSSEUM 로그인 </h1>
        <h2> 이메일 로그인 </h2>
        <div id="login-form">
            <div> <input id="email-input" placeholder="Email Address"> </div>
            <div> <input id="password-input" placeholder="Password"> </div>
        </div>

        <button type="submit">
            <div class="loading-spinner mr-2 h-6 w-6 bg-white hidden"></div>로그인
        </button>

        <div id="additional-function">
            <a href="/member/recovery_password" class="text-rg font-medium text-white hover:text-psbl-light">비밀번호 찾기</a>
            <p class="flex-shrink-0 flex-grow-0 text-center text-rg font-medium text-white">|</p> <a href="/join" class="text-rg font-medium text-white hover:text-psbl-light">이메일 회원가입</a>
        </div>
    </div>
</div>
</template>

<style scoped>
#login-container {
    align-items: center;
    justify-content: center;
    display: flex;
    flex-direction: column;
    min-height: 100%;
}

#login-card {
    backdrop-filter: blur(40px);
    max-width: 500px;
    height: 100%;
    padding-top: 32px;
    padding-bottom: 32px;
    padding-left: 24px;
    padding-right: 24px;
    margin-top: 60px;
    margin-bottom: 10%;
    background-color: rgb(255 255 255 / .2);
    border-radius: 16px;
    justify-content: flex-start;
    align-items: center;
    flex-direction: column;
    display: flex;
}

#login-card button {
    font-family: GmarketSansMedium;
    font-weight: 700;
    font-size: 18px;
    line-height: 24px;
    padding: 8px 16px 8px 16px;
    border-color: transparent;
    border-width: 1px;
    border-radius: 8px;
    align-items: center;
    width: 100%;

    background-color: rgb(33 58 150 / 1);
    color: white;

}

#login-content-img {
    height: 100px;
    width: auto;
}

#login-card h1 {
    font-family: GmarketSansMedium;
    font-weight: 700;
    color: white;
    font-size: 18px;
    text-align: center;
    align-self: stretch;
    flex-grow: 0;
    flex-shrink: 0;
}

#login-card h2 {
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

#login-form {
    border-radius: 8px;
    width: 100%;
    margin-bottom: 30px;
}

#login-form div {
    width: 100%;
}

#email-input {
    color: rgb(53 57 69 / 1);

    background-color: white;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    border-color: rgb(211 220 233 / 1);
    border-width: 1px;
    appearance: none;
    margin-right: 0;
    margin-bottom: 0;
    height: auto;
    width: 100%;
    padding: 8px 12px 8px 12px;
    box-sizing: border-box;
}

#password-input {
    margin-top: 0;
    height: auto;
    color: rgb(53 57 69 / 1);
    background-color: white;
    border-bottom-right-radius: 8px;
    border-bottom-left-radius: 8px;
    border-color: rgb(211 220 233 / 1);
    border-width: 1px;
    appearance: none;
    width: 100%;
    padding: 8px 12px 8px 12px;
    align-items: center;
    box-sizing: border-box;
}

#additional-function {
    align-self: stretch;
    gap: 8px;
    justify-content: space-around;
    display: flex;
    flex-grow: 0;
    flex-shrink: 0;
}

#additional-function a{
    align-items: center;
    font-family: GmarketSansMedium;
    font-size: 14px;
    line-height: 20px;
    font-weight: 500;
    color:white;
    text-decoration: inherit;
    display: flex;
}

#additional-function p{
    text-align: center;
    color:white;
    font-size: 14px;
    line-height: 20px;
}
</style>
