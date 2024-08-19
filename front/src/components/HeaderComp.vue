<template>
    <nav id="menu-container">
        <div id="menu-content">
            <div id="logo-content">
                <img id="logo-content-img" src="img/logo.png">
            </div>
            <div id="main-content">
                <a>드라마 랭킹</a>
                <a>영화 랭킹</a>
                <a>웹툰 랭킹</a>
                <a>추천</a>
            </div>
            <div id="login-content">
                <a>로그인</a>
            </div>
        </div>

    </nav>
</template>





<style scoped>

#menu-container {
    font-family: GmarketSansMedium;
    position: fixed;
    background-color: rgb(33 58 168/1);
    left: 0;
    right: 0;
    top: 0;
    z-index: 1000;
}

#menu-content {
    justify-content: flex-start;
    max-width: 1280px;
    padding-left:24px;
    margin-left: auto;
    margin-right: auto;
    align-items: center;
    flex-direction: row;
    height: 40px;
    display: flex;

}

#logo-content {
    font-size:16px;
    color: rgb(218 223 231 / 1);
    row-gap: 8px;
    column-gap: 8px;
    align-items: center;
    font-style: bold;
    display: flex;
}

#logo-content-img {
    height: 35px;
    width: auto;
}

#main-content {
    gap: 16px;
    display: flex;
    padding-left: 60px;
    margin-right: auto;
}

#menu-content a {
    color: rgb(218 223 231 / 1);
    font-weight: 400;
    font-size:16px;
    line-height: 24px;
    padding-top: 8px;
    padding-bottom: 8px;
    padding-left: 8px;
    padding-right: 8px;
}

#login-content {
    display: flex;
    gap: 4px;
    align-items: center;
    margin-left: auto;
}

#login-content a {
    color: rgb(218 223 231 / 1);
    font-weight: 400;
    font-size:16px;
    line-height: 24px;
    padding-top: 8px;
    padding-bottom: 8px;
    padding-left: 8px;
    padding-right: 24px;
}

</style>