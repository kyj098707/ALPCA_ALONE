<template>
    <div id="join-container">
        <img id="join-content-img" src="img/favicon.png">
        <div id="join-card">
            <h1> 이메일 회원가입 </h1>
            <h2> K-COLOSSEUM에 이메일 계정으로 회원가입  </h2>
            <div id="join-form">
                <div> 이메일 </div>
                <div> <input> </div>
                <div> 비밀번호 </div>     
                <div> <input> </div>                                                                             
                <div> 비밀번호 확인 </div>
                <div> <input> </div>
                <div> 성별 </div>
                <div> <input> </div>
            </div>
            <div id="join-agreement">
                
                <div class="join-agreement-line">
                    <div class="agreement-line-content">
                        <input id="is-term-checked" name="is-term-checked" type="checkbox" class="checkbox checkbox-md bg-white">
                            <label for="is-term-checked" class="ml-2 block bg-white text-rg text-white"></label>
                            <div class="text-rg">
                                <a href="https://lol.ps/terms?tab=use" class="text-center font-bold text-psbl-deep" rel="noopener noreferrer" target="_blank">이용약관</a><span class="text-center font-medium text-dark-psbk">에 동의합니다. (필수)</span>
                            </div>
                    </div>
                </div>
                <div class="join-agreement-line">
                    <div class="agreement-line-content">
                        <input id="is-required-privacy-checked" name="is-required-privacy-checked" type="checkbox" class="checkbox checkbox-md bg-white">
                        <label for="is-required-privacy-checked" class="ml-2 block bg-white text-rg text-white"></label>
                        <div class="text-rg">
                            <a href="https://lol.ps/terms/agreement?tab=required_privacy" class="text-center font-bold text-psbl-deep" rel="noopener noreferrer" target="_blank">개인정보 수집 및 이용</a>
                            <span class="text-center font-medium text-dark-psbk">에 동의합니다. (필수)</span>
                        </div>
                    </div>
                </div>
                <button type="submit"><div class="loading-spinner mr-2 h-6 w-6 bg-white hidden"></div> 회원가입</button>
            </div>
        </div>
    </div>
</template>

<style scoped>
#join-container {
    align-items: center;
    justify-content: center;
    display: flex;  
    flex-direction: column;
    min-height: 100%;
}
#join-card{
        backdrop-filter: blur(40px);
        max-width: 500px;
        height: 100%;
        padding-top: 32px;
        padding-bottom: 32px;
        padding-left: 24px;
        padding-right: 24px;
        /* margin-top:60px; */
        margin-bottom: 10%;
        background-color:rgb(255 255 255 / .2);
        border-radius: 16px;
        justify-content: flex-start;
        align-items: center;
        flex-direction: column;
        display: flex;
    }

#join-card button {
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
#join-content-img {
    height: 100px;
    width: auto;
    }
    
#join-card h1 {
    font-family: GmarketSansMedium;
    font-weight: 700;
    color: white;
    font-size: 18px;
    text-align: center;
    align-self: stretch;
    flex-grow: 0;
    flex-shrink: 0;
}

#join-card h2 {
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

#join-form {
    width: 100%;
}

#join-form div {
    font-family: NanumSquareNeo-Variable;
    gap: 4px;
    flex-direction: column;
    display: flex;
    text-align: left;
    font-weight: 700;
    font-size:14px;
    margin-bottom: 4px;
    color: rgb(218 223 231 / 1);
}

#join-form input {
    color: rgb(53 57 69 / 1);
    padding-top: 8px;
    padding-bottom: 8px;
    padding-left: 12px;
    padding-right: 12px;
    border-color: rgb(211 220 233 / 1);
    border-width: 1px;
    border-radius: 8px;
    appearance: none;
}
#join-agreement {
    margin-top: 3%;
    gap: 16px;
    flex-direction: column;
    display: flex;
    justify-content: start;
    width: 100%;

}

#join-agreement span {
    color: rgb(218 223 231 / 1);
    font-weight: 60;
    line-height: 20px;
    font-size: 14px;
    font-family: LINESeedKR-Bd;
    align-items: center;
}

#join-agreement p {
    color: rgb(218 223 231 / 1);
    line-height: 14px;
    font-size: 12px;
    font-family: LINESeedKR-Bd;
    align-items: center;
}

#join-agreement a {
    align-items: center;
    color: rgb(33 58 150 / 1);
    font-weight: 700;
    text-decoration: inherit;
    font-family: LINESeedKR-Bd;
}

.checkbox{
    background-color: white;
    height: 1.5rem;
    width: 1.5rem;
    flex-shrink: 0;
    cursor: pointer;
    border-width: 1px;

}

.join-agreement-line {
    justify-content: space-between;
    align-items: center;
    display: flex;
}

.agreement-line-content {
    gap:4px;
    align-items: center;
    display: flex;
}

.agreemnt-line-content-flex {
    display: flex;
    flex-direction: column;
}
</style>