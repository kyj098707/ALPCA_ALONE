<template>
<div id="tier-container">
    <TierComp :products="productArray" />
</div>
</template>

<script>
import TierComp from '../components/TierComp.vue';

export default {

    components: {
        TierComp,
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
