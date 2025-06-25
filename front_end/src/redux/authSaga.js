import { authApi } from '../api/auth.api'
import { authActions } from '../redux/authSlice'
import { history } from '../utils/history'
import { setAccessTokenToLS, setRefreshTokenToLS } from '../utils/storage'
import { call, fork, put, takeLatest } from 'redux-saga/effects'

// Hàm xử lý đăng nhập
function* handleLogin(action) {
  try {
    const res = yield call(authApi.login, action.payload)
    setAccessTokenToLS(res.access_token)
    setRefreshTokenToLS(res.refresh_token)
    // yield put(authActions.loginSuccess(res)) // Nếu cần cập nhật state
    yield call(history.push, `/`)
  } catch (error) {
    yield put(authActions.loginFailed(error.message))
  }
}

// Theo dõi action login
function* watchLoginFlow() {
  yield takeLatest(authActions.login.type, handleLogin)
}

// Export saga chính
export default function* authSaga() {
  yield fork(watchLoginFlow)
}
