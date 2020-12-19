import request from '@/utils/request'
export function fetchList(query) {
  return request({
    url: '/wph/list/getList',
    method: 'get',
    params: query,
  })
}
export function historicalData(query) {
  return request({
    url: '/wph/listpage/getList',
    method: 'get',
    params: query,
  })
}