import axiosClient from '../api/axiosClient'

export const authApi = {
  login(params) {
    const url = '/auth/login'
    return axiosClient.post(url, params)
  },
  register(params) {
    const url = '/auth/register'
    return axiosClient.post(url, params)
  }
}
