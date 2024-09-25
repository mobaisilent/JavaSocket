import './assets/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// 导入router包实现路由功能

const app = createApp(App)
// 创建实例
app.use(router)
// 使用router
app.mount('#app')
// 挂载到app上（app.vue)