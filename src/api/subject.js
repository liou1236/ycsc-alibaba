import request from '@/utils/request'
export function fetchListAll() {
  return request({
    url:'/shop-content/subject/listAll',
    method:'get',
  })
}

export function fetchList(params) {
  return request({
    url:'/shop-content/subject/list',
    method:'get',
    params:params
  })
}
