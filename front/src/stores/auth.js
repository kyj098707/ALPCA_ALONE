import { defineStore } from 'pinia';

export const useAuthStore = defineStore('auth', {
  state: () => ({
    user: null,  // 로그인한 유저 이름
    token: null,  // JWT 토큰
  }),
  actions: {
    setToken(token) {
      this.token = token;
      localStorage.setItem('jwtToken', token);

      // JWT 토큰에서 유저 정보 추출 (예: username)
      const payload = JSON.parse(atob(token.split('.')[1]));
      this.user = payload.username;  // JWT 페이로드에서 유저 이름 추출
    },
    loadUserFromToken() {
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
