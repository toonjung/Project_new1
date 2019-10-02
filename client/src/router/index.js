  
import Vue from 'vue'
import Router from 'vue-router';
import Doctor from '../components/doctor';
import Viewschudule from '../components/viewschudule';

Vue.use(Router);

export default new Router({
    mode: 'history',
    base: process.env.BASE_URL,
    routes: [{
            path: '/',
            component: Doctor
        },
        {
            path: '/viewschudule',
            component: Viewschudule
        },
        
    ]
});