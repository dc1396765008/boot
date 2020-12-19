import request from '@/utils/request'
export function fetchList(query) {
  return request({
    url: '/dd/list/getList',
    method: 'get',
    params: query,
  })
}
export function historicalData(query) {
  return request({
    url: '/dd/listpage/getList',
    method: 'get',
    params: query,
  })
}
