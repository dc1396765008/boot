import request from '@/utils/request'
export function fetchList(query) {
  return request({
    url: '/sn/list/getList',
    method: 'get',
    params: query,
  })
}
export function historicalData(query) {
  return request({
    url: '/sn/listpage/getList',
    method: 'get',
    params: query,
  })
}
