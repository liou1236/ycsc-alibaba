import request from '@/utils/request'
export function fetchList(params) {
  return request({
    url:'/shop-sale/couponHistory/list',
    method:'get',
    params:params
  })
}
