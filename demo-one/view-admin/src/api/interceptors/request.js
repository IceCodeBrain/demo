import axios from 'axios'
import {Message, MessageBox} from 'element-ui'
import store from '@/store'
import {getToken} from '@/utils/auth'


const service = axios.create({
    baseURL: process.env.VUE_APP_BASE_API, // url = base url + request url
    // withCredentials: true, // send cookies when cross-domain requests
    timeout: 5000 // request timeout
});

// request interceptor
service.interceptors.request.use(
    config => {
        if (store.getters.token) {
            config.headers['Authorization'] = getToken()
        }
        return config
    },
    error => {
        console.log(error);
        return Promise.reject(error)
    }
);


service.interceptors.response.use(
    response => {
        const res = response.data;
        if (res.code !== 200) {
            if (res.code === 401) {
                MessageBox.confirm('您已登出，可以取消停留在此页面上，或者再次登录', '确认登出', {
                    confirmButtonText: '重新登录',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    store.dispatch('user/resetToken').then(() => {
                        location.reload()
                    })
                })
            } else {
                Message({
                    message: res.msg || '错误',
                    type: 'error',
                    duration: 5 * 1000
                });
            }
            //return Promise.reject(new Error(res.msg || '错误'));
            return res
        } else {
            return res
        }
    },
    error => {
        console.log('err' + error);
        Message({
            message: error.message,
            type: 'error',
            duration: 5 * 1000
        });
        return Promise.reject(error)
    }
);

export default service
