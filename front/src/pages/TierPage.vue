<template>
    <div id="tier-container">

    <TierComp> </TierComp>
    </div>
</template>
<script>
import TierComp from '../components/TierComp.vue';

export default {
    components: {
        TierComp,
    },
};
</script>

<style scoped>
#tier-container {
    padding : 20px 20px 20px 20px;
}
</style>