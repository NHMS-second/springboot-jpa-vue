import http from '@/utils/http'

/**
 * 查询设备固件
 */
export function find(id) {
  return http.get('/firmware/' + id)
}

/**
 * 删除设备固件
 */
export function remove(ids) {
  return http.post('/firmware/delete', { 'id[]': ids })
}

/**
 * 保存设备固件
 */
export function save(params) {
  return http.post('/firmware', params)
}
