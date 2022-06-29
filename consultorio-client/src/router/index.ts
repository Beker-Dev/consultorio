import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/especialidade/listar',
    name: 'especialidade-listar',
    component: () => import(/* webpackChunkName: "list" */ '../views/especialidade/especialidade-list.vue')
  },
  {
    path: '/especialidade/cadastrar',
    name: 'especialidade-cadastrar',
    component: () => import(/* webpackChunkName: "form" */ '../views/especialidade/especialidade-form.vue')
  },
  {
    path: '/convenio/listar',
    name: 'convenio-listar',
    component: () => import('../views/convenio/convenio-list.vue')
  },
  {
    path: '/convenio/cadastrar',
    name: 'convenio-cadastrar',
    component: () => import('../views/convenio/convenio-form.vue')
  },
  {
    path: '/medico/listar',
    name: 'medico-listar',
    component: () => import("../views/medico/medico-list.vue")
  },
  {
    path: '/medico/cadastrar',
    name: 'medico-cadastrar',
    component: () => import("../views/medico/medico-form.vue")
  },
  {
    path: '/paciente/listar',
    name: 'paciente-listar',
    component: () => import("../views/paciente/paciente-list.vue")
  },
  {
    path: '/paciente/cadastrar',
    name: 'paciente-cadastrar',
    component: () => import("../views/paciente/paciente-form.vue")
  },
  {
    path: '/secretaria/listar',
    name: 'secretaria-listar',
    component: () => import("../views/secretaria/secretaria-list.vue")
  },
  {
    path: '/secretaria/cadastrar',
    name: 'secretaria-cadastrar',
    component: () => import("../views/secretaria/secretaria-form.vue")
  },
  {
    path: '/agenda/listar',
    name: 'agenda-listar',
    component: () => import("../views/agenda/agenda-list.vue")
  },
  {
    path: '/historico/listar',
    name: 'historico-listar',
    component: () => import("../views/historico/historico-list.vue")
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
