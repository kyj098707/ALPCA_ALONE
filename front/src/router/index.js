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
        },
        {
            path: "/mytier",
            name: "mytier",
            component: () => import("../pages/MyTierPage.vue"),
        },
        {
            path: "/recommendation",
            name: "recommendation",
            component: () => import("../pages/Recommendation.vue"),
        }
    ],
});
export default router;
