import '@/assets/css/main.css'

import { createApp } from 'vue'
import App from './App.vue'
import VueAwesomePaginate from "vue-awesome-paginate";
import router from "@/router/router.js";

const app = createApp(App);
app.use(router);
app.use(VueAwesomePaginate);
app.mount('#app');

