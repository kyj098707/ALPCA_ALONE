<template>
  <div class="floating-button" @click="openModal">
    +
  </div>
</template>

<script>
export default {
  methods: {
    openModal() {
      this.$emit('open-modal');
    }
  }
}
</script>

<style scoped>
.floating-button {
  position: fixed;
  bottom: 20px;
  right: 20px;
  width: 60px;
  height: 60px;
  background-color: #2234ff;
  color: white;
  border-radius: 50%;
  display: flex;
  align-items: center;
  justify-content: center;
  font-size: 24px;
  cursor: pointer;
  box-shadow: 0px 4px 6px rgba(0, 0, 0, 0.1);
}
</style>