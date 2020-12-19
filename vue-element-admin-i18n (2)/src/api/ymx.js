import request from '@/utils/request'
export function fetchList(query) {
  return request({
    url: '/ymx/list/getList',
    method: 'get',
    params: query,
  })
}

export function historicalData(query) {
  return request({
    url: '/ymx/listpage/getList',
    method: 'get',
    params: query,
  })
}