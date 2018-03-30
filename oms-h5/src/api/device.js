import http from '@/utils/http'

/**
 * 查询设备
 */
export function find(id) {
  return http.get('/device/' + id)
}

/**
 * 更新状态
 */
export function updateStatus(ids, status) {
  return http.post('/device/status', { 'id[]': ids, 'status': status })
}

/**
 * 删除设备
 */
export function remove(ids) {
  return http.post('/device/delete', { 'id[]': ids })
}

/**
 * 保存设备
 */
export function save(params) {
  return http.post('/device', params)
}
