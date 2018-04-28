import http from '@/utils/http'

/**
 * 查询设备上下线记录
 */
export function find(id) {
  return http.get('/device/status/log/' + id)
}

/**
 * 删除设备上下线记录
 */
export function remove(ids) {
  return http.post('/device/status/log/delete', { 'id[]': ids })
}

/**
 * 保存设备上下线记录
 */
export function save(params) {
  return http.post('/device/status/log', params)
}
