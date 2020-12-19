import request from '@/utils/request'

export function fetchList(query) {
  return request({
    url: '/taobao/list/getList',
    method: 'get',
    params: query,
  })
}
export function historicalData(query) {
  return request({
    url: '/taobao/listpage/getList',
    method: 'get',
    params: query,
  })
}

