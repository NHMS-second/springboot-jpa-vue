import http from '@/utils/http'

/**
 * 查询用户反馈
 */
export function find(id) {
  return http.get('/member/opinion/' + id)
}

/**
 * 删除用户反馈
 */
export function remove(ids) {
  return http.post('/member/opinion/delete', { 'id[]': ids })
}

/**
 * 保存用户反馈
 */
export function save(params) {
  return http.post('/member/opinion', params)
}
