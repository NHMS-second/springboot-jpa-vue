import http from '@/utils/http'

/**
 * 查询设备唯一序列号
 */
export function find(id) {
  return http.get('/device/key/' + id)
}

/**
 * 更新状态
 */
export function updateStatus(ids, status) {
  return http.post('/device/key/status', { 'id[]': ids, 'status': status })
}

/**
 * 删除设备唯一序列号
 */
export function remove(ids) {
  return http.post('/device/key/delete', { 'id[]': ids })
}

/**
 * 保存设备唯一序列号
 */
export function save(params) {
  return http.post('/device/key', params)
}
