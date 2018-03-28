import http from '@/utils/http'

/**
 * 查询会员
 */
export function find(id) {
  return http.get('/member/' + id)
}

/**
 * 更新状态
 */
export function updateStatus(ids, status) {
  return http.post('/member/status', { 'id[]': ids, 'status': status })
}
/**
 * 删除会员
 */
export function remove(ids) {
  return http.post('/member/delete', { 'id[]': ids })
}

/**
 * 保存会员
 */
export function save(params) {
  return http.post('/member', params)
}
