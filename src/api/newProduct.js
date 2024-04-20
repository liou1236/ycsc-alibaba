import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-sale/home/newProduct/list',
    method:'get',
    params:params
  })
}

export function updateRecommendStatus(data) {
  return request({
    url:'/shop-sale/home/newProduct/update/recommendStatus',
    method:'post',
    data:data
  })
}

export function deleteNewProduct(data) {
  return request({
    url:'/shop-sale/home/newProduct/delete',
    method:'post',
    data:data
  })
}

export function createNewProduct(data) {
  return request({
    url:'/shop-sale/home/newProduct/create',
    method:'post',
    data:data
  })
}

export function updateNewProductSort(params) {
  return request({
    url:'/shop-sale/home/newProduct/update/sort/'+params.id,
    method:'post',
    params:params
  })
}
