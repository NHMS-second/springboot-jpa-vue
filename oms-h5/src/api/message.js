import http from '@/utils/http'

/**
 * 查询系统消息
 */
export function find(id) {
  return http.get('/message/' + id)
}

/**
 * 删除系统消息
 */
export function remove(ids) {
  return http.post('/message/delete', { 'id[]': ids })
}

/**
 * 保存系统消息
 */
export function save(params) {
  return http.post('/message', params)
}
