import { defineStore } from 'pinia';
import axios from 'axios';

export const useAuthStore = defineStore('auth', {
  state: () => ({
    user: null,  // 유저 정보 저장
    token: null,  // JWT 토큰 저장
  }),
  actions: {
    async login(username, password) {
      try {
        const formData = new FormData();
        formData.append('username', username);
        formData.append('password', password);

        const response = await axios.post('http://localhost:8080/login', formData, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        });
        
        const token = response.headers['authorization'];
        if (token) {
          this.token = token;
          localStorage.setItem('jwtToken', token);

          // JWT 토큰에서 유저 정보 추출 (예: username)
          const payload = JSON.parse(atob(token.split('.')[1]));
          this.user = payload.username;  // JWT 페이로드에서 유저 이름 가져오기

          this.$router.push('/');
        } else {
          console.log('로그인 실패: JWT 토큰이 응답에 없습니다.');
        }
      } catch (error) {
        console.log("로그인 실패", error);
      }
    },
    loadUserFromStorage() {
      const token = localStorage.getItem('jwtToken');
      if (token) {
        this.token = token;
        const payload = JSON.parse(atob(token.split('.')[1]));
        this.user = payload.username;
      }
    },
    logout() {
      this.user = null;
      this.token = null;
      localStorage.removeItem('jwtToken');
    }
  }
});
