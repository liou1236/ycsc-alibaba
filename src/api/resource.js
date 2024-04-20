import request from '@/utils/request'

export function fetchList(params) {
  return request({
    url: '/shop-user/resource/list',
    method: 'get',
    params: params
  })
}

export function createResource(data) {
  return request({
    url: '/shop-user/resource/create',
    method: 'post',
    data: data
  })
}

export function updateResource(id, data) {
  return request({
    url: '/shop-user/resource/update/' + id,
    method: 'post',
    data: data
  })
}

export function deleteResource(id) {
  return request({
    url: '/shop-user/resource/delete/' + id,
    method: 'post'
  })
}

export function fetchAllResourceList() {
  return request({
    url: '/shop-user/resource/listAll',
    method: 'get'
  })
}
