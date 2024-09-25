import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
      // 定义路由信息，打开对应组件
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/AboutView.vue')
    }
  ]
  // 创建两个路由，一个是首页，一个是关于页面
  // 前者是静态导入，后者是动态导入：其两个组件都是指向对应的view
})

export default router
