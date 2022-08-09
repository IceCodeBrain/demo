import request from './interceptors/request'

export function doLogin(params) {
    return request({
        url: '/admin/auth/doLogin',
        method: 'post',
        params
    })
}

export function doLogout(params) {
    return request({
        url: '/admin/auth/doLogout',
        method: 'post',
        params
    })
}

export function doGetInfo(params) {
    return request({
        url: '/admin/auth/doGetInfo',
        method: 'get',
        params
    })
}

export function doEditAdmin(params) {
    return request({
        url: '/admin/auth/doEditAdmin',
        method: 'post',
        data: params,
        contentType: 'application/json'
    })
}

export function doGetAdmins(params) {
    return request({
        headers: {'Content-Type': 'application/json'},
        url: '/admin/auth/doGetAdmins',
        method: 'post',
        data: params
    })
}

