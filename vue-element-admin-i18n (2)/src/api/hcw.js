import request from '@/utils/request'
export function fetchList(query) {
  return request({
    url: '/hc/list/getList',
    method: 'get',
    params: query,
  })
}
export function historicalData(query) {
  return request({
    url: '/hc/listpage/getList',
    method: 'get',
    params: query,
  })
}