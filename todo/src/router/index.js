import Vue from 'vue'
import Vuex from 'vuex'
import Router from 'vue-router'
import Home from '../components/Home'
import todoList from '../components/todoList'

Vue.use(Router)
Vue.use(Vuex)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/home'
    },
    {
      path: '/home',
      name: 'Home',
      component: Home,
      children: [
        {
          path: 'todolist',
          name: 'todoList',
          component: todoList
        }
      ]
    }
  ]
})
