import request from '@/utils/request'
export function fetchList(query) {
  return request({
    url: '/jd/list/getList',
    method: 'get',
    params: query,
  })
}
export function historicalData(query) {
  return request({
    url: '/jd/listpage/getList',
    method: 'get',
    params: query,
  })
}