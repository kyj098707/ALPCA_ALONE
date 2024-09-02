<template>
<div id="tier-container">
    <TierComp :products="productArray" />
</div>
</template>

<script>
import TierComp from '../components/TierComp.vue';
import axios from "axios";

export default {
    mounted() {
        axios.get("http://localhost:8080/product/defaulttier")
            .then(response => {
                this.productArray = response.data;
            })
            .catch(error => {
                console.log(error)
            })
    },
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
