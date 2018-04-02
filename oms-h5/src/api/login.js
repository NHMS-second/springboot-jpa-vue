import http from '@/utils/http'

/**
 * 登录
 * @param {*} username 用户名
 * @param {*} password 密码
 */
export function loginByUsername(username, password, language) {
  return http.post('/login', {
    username: username,
    password: password,
    lang: language
  })
}

/**
 * 退出登录
 */
export function logout() {
  return http.post('/logout')
}

/**
 * 获取登录用户信息
 */
export function getUserInfo() {
  return http.get('/admin')
}

/**
 * 获取登录用户的菜单
 */
export function getMenus(lang) {
  return http.get('/menuList', { lang: lang })
}

