import fetch from '@/utils/http'

export function getToken() {
  return fetch({
    url: '/qiniu/upload/token', // 假地址 自行替换
    method: 'get'
  })
}
