import { createRouter, createWebHashHistory, RouteRecordRaw } from 'vue-router'
import CalendarView from '../components/CalendarView.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: CalendarView
  },
  {
    path: '/event-details/:id',
    name: 'event-details',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../components/EventDetailsPage.vue')
  },
  {
    path: '/add-event',
    name: 'add-event',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../components/AddEventPage.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
