import http from '@/utils/http'

/**
 * dashboard
 */
export function dashboard() {
  return http.get('/dashboard')
}

export function currentTime() {
  return http.get('/current')
}

export function statisticsDevice(month) {
  return http.get('/statistics/device', { 'month': month })
}

