<script setup>
// 创建一个必须的props
defineProps({
  msg: {
    type: String,
    required: true
  }
})
</script>

<template>
  <div class="greetings">
    <h1 class="green">这里常驻展示{{ msg }} !</h1>
  </div>
</template>

<style scoped>
.greetings {
  margin-top: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}
</style>
