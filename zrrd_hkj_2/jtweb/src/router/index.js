import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../components/Login.vue'
import Home from '../components/Home.vue'
import Welcome from '../components/Welcome.vue'
import User from '../components/user/User.vue'
import ItemCat from '../components/items/ItemCat.vue'
import ItemCatParam from '../components/items/ItemCatParam.vue'
import Item from '../components/items/Item.vue'
import addItem from '../components/items/addItem.vue'
Vue.use(VueRouter)
const routes = [
  { path: '/', redirect: '/login' },
  { path: '/login', component: Login },
  {
    path: '/home',
    component: Home,
    redirect: '/welcome',
    children: [
      { path: '/welcome', component: Welcome },
      { path: '/user', component: User },
      { path: '/itemCat',component: ItemCat},
      { path: '/itemCatParam',component: ItemCatParam},
      { path: '/item',component: Item},
      { path: '/item/addItem',component: addItem}
    ]
  }
]
// 1.创建路由对象
const router = new VueRouter({
  routes
})
// 2.定义导航守卫
/*
  beforeEach: 循环遍历用户的所有请求(拦截)
            在其中需要定义一个回调函数(3个参数)
  参数介绍:   to:要访问的请求路径
              from: 从那个页面跳转而来
              next:表示请求放行
   业务需求: 1.如果用户请求/login
   2.如果不是login则判断是否登录token
*/
router.beforeEach((to, from, next) => {
  if (to.path === '/login') return next()
  // 2.获取token信息
  const token = window.sessionStorage.getItem('token')
  // 3.判断token是否有数据  if(token) 如果token不为null
  // 如果token为null 则跳转到登录页面
  if (!token) return next('/login')

  // 放行
  next()
})
export default router
