<template>
    <div id="footer-container">
        <div id="footer-content">
            <div id="footer-notice">
                <a>이용약관</a>
                <a>개인정보처리방침</a>
                <a>도움말</a>
            </div>
            <div id="footer-right">
                <a>&copy; ALPCA-CA 2024. All rights reserved.</a>
            </div>
        </div>
    </div>    
</template>

<style scoped>
    #footer-container {
        background-color: rgb(24 28 42 / 1);
        max-width: 100%;
        min-width: 100vw;
        width: 100%;
        line-height: 20px;
        margin-bottom: 0;
    }

    #footer-content {
        padding-top:24px;
        padding-bottom: 96px;
        gap:40px;
        padding-left: 16;
        padding-right: 16;
        flex-direction: column;
        margin-left: auto;
        margin-right: auto;
    }

    #footer-notice {
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 30px;
        padding-left: 100px;
        padding-right: 100px;
        gap:10px;
        flex-direction: row;
        display: flex;
    }
</style>