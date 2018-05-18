import http from '@/utils/http'

/**
 * 查询设备ID使用记录
 */
export function find(id) {
  return http.get('/device/key/log/' + id)
}

/**
 * 更新状态
 */
export function updateStatus(ids, status) {
  return http.post('/device/key/log/status', { 'id[]': ids, 'status': status })
}

/**
 * 删除设备ID使用记录
 */
export function remove(ids) {
  return http.post('/device/key/log/delete', { 'id[]': ids })
}

/**
 * 保存设备ID使用记录
 */
export function save(params) {
  return http.post('/device/key/log', params)
}
