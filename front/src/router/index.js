import { createRouter, createWebHistory } from "vue-router";
const router = createRouter({
    history: createWebHistory(""), 
    routes: [
        {      
            path: "/",
            name: "main",
            component: () => import("../pages/MainPage.vue"),
        },
        {
            path: "/login",
            name: "login",
            component: () => import("../pages/LoginPage.vue"),
        },
        {
            path: "/join",
            name: "join",
            component: () => import("../pages/JoinPage.vue"),
        },
        {
            path: "/tier",
            name: "tier",
            component: () => import("../pages/TierPage.vue"),
        }
    ],
});
export default router;
