import { createRouter, createWebHistory } from 'vue-router';
import {GROUP_S, STUD_S} from "@/service/serviseType.js"
import {GROUP_STUDENT_LIST, GROUP_TABLE} from "@/assets/js/dataType.js"
import Main from "@/layout/Main.vue";

const routes = [
    {
        path: '/',
        component: Main,
        props: {title: 'Группы университета ScaleApps', serviceType: GROUP_S, dataType: GROUP_TABLE, id:null},

    },
    {
        path: '/:name',
        component: Main,
        props: route => ({
            title: `Группa № ${route.params.name}`,
            pathPoint: 'group/'+route.query.id,
            serviceType: STUD_S,
            dataType: GROUP_STUDENT_LIST,
            action:true
        }),
    },

];

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes,
});



export default router;