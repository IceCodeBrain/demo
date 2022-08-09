import request from './interceptors/request'
import download from './interceptors/download'

export function doExport(params) {
    return download({
        url: '/admin/info/doExport',
        method: 'post',
        responseType: 'blob',
        data: params
    })
}

export function doQueryByPage(params) {
    return request({
        url: '/admin/info/doQueryByPage',
        method: 'post',
        data: params
    })
}

export function doAdd(params) {
    return request({
        url: '/admin/info/doAdd',
        method: 'post',
        data: params
    })
}

export function doEdit(params) {
    return request({
        url: '/admin/info/doEdit',
        method: 'post',
        data: params
    })
}

export function doDeleteById(params) {
    return request({
        url: '/admin/info/doDeleteById/' + params,
        method: 'delete'
    })
}


