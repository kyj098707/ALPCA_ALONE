<template>
<div id="tier-container">
    <MyTierComp :products="productArray" />
</div>
</template>

<script>
import MyTierComp from '../components/MyTierComp.vue';


export default {

    components: {
        MyTierComp,
    },
    data() {
        return {
            productArray: []
        };
    },
};
</script>

<style scoped>
#tier-container {
    padding: 20px 20px 20px 20px;
}
</style>
