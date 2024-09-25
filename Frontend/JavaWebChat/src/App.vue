<script setup>
import { RouterLink, RouterView } from 'vue-router'
import Hello from './components/Hello.vue'
import WhoIsIn from './components/home/WhoIsIn.vue'
</script>

<template>

  <header>
    <div class="wrapper">
      <Hello msg="mobaisilent" />
    </div>
  </header>
  <!-- 头部显示问候信息 -->

  <div class="homepage">
    <div class="left">
      <WhoIsIn />
      <!-- 左边是应该放入一个组件的 -->
    </div>
    <div class="right">
      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav>
      <RouterView /> <!-- 这里是路由组件的显示位置:注意这里的位置啊 -->
    </div>
    <!-- 右边则是一个div容器包裹着路由组件 -->
  </div>
</template>

<style scoped>
nav {
  position: absolute;
  top: 96%;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  gap: 1rem;
  margin-bottom: 1rem;
}

.homepage {
  display: flex;
  height: calc(100vh - 100px);
}

.left {
  flex: 1;
  background-color: aqua;
  padding: 1rem;
  /* 设置点边距 */
}

.right {
  flex: 1;
  background-color: bisque;
  padding: 1rem;
}

@media (max-width: 1024px) {
  .homepage {
    flex-direction: column;
    /* 小于1024的时候 */
  }
}

/* 简要的设置下媒体缩放：实现在窗口缩放的时候达到想要的效果 */
</style>
<!-- ok 前端部分基本完成，剩下的就是Java后端和前端的利用了 -->