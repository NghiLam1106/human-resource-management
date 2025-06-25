import HttpStatusCode from '../constants/http'
import { useAppDispatch } from '../redux/hooks'
import { appAction } from '../redux/store/appSlice'
import { history } from '../utils/history'
import { getRefreshTokenFromLS } from '../utils/storage'
import axios from 'axios'
import config from '../configs/index'

const updateLocalAccessToken = (res) => {
  localStorage.setItem('access_token', res.access_token)
  localStorage.setItem('refresh_token', res.refresh_token)
}

const axiosClient = axios.create({
  baseURL: config.baseUrl,
  headers: {
    'Content-Type': 'application/json'
  }
})

// Add a request interceptor
axiosClient.interceptors.request.use(
  function (config) {
    const token = localStorage.getItem('access_token')
    if (token) {
      config.headers.Authorization = `Bearer ${token}`
    }
    return config
  },
  function (error) {
    return Promise.reject(error)
  }
)

// Add a response interceptor
axiosClient.interceptors.response.use(
  function (response) {
    return response.data
  },
  async function (error) {
    const originalConfig = error.config
    const dispatch = useAppDispatch()
    if (error.response?.status === HttpStatusCode.Forbidden) {
      await dispatch(appAction.setAPIState(403))
    }
    if (error.response?.status === HttpStatusCode.Unauthorized) {
      try {
        const url = `${originalConfig.baseURL}/auth/refresh-token`
        const result = await getRefreshTokenFromLS()
        const rs = await axios.post(url, {
          refresh_token: result
        })
        updateLocalAccessToken(rs.data)
        return axiosClient(originalConfig)
      } catch (_error) {
        localStorage.clear()
        history.push('/')
        return Promise.reject(_error)
      }
    }
    return Promise.reject(error)
  }
)

export default axiosClient
