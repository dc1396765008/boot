import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/tm/list/getList',
    method: 'get',
    params: query,
  })
}
export function historicalData(query) {
  return request({
    url: '/tm/listpage/getList',
    method: 'get',
    params: query,
  })
}
