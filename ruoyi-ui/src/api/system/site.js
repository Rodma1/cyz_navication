import request from '@/utils/request'

// 查询导航网站列表
export function listSite(query) {
  return request({
    url: '/system/site/list',
    method: 'get',
    params: query
  })
}

// 查询导航网站详细
export function getSite(id) {
  return request({
    url: '/system/site/' + id,
    method: 'get'
  })
}

// 新增导航网站
export function addSite(data) {
  return request({
    url: '/system/site',
    method: 'post',
    data: data
  })
}

// 修改导航网站
export function updateSite(data) {
  return request({
    url: '/system/site',
    method: 'put',
    data: data
  })
}

// 删除导航网站
export function delSite(id) {
  return request({
    url: '/system/site/' + id,
    method: 'delete'
  })
}
