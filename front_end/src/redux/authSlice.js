import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  isLoggedIn: false,
  logging: false,
  error: undefined,
  loading: false
}

const authSlice = createSlice({
  name: 'auth',
  initialState,
  reducers: {
    login(state) {
      state.loading = true
      state.logging = true
      state.error = ''
    },
    loginSuccess(state) {
      state.loading = false
      state.logging = false
      state.isLoggedIn = true
    },
    loginFailed(state, action) {
      state.loading = false
      state.logging = false
      state.error = action.payload
    },
    logout(state) {
      state.logging = false
      state.isLoggedIn = false
    }
  }
})

export const authActions = authSlice.actions

const authReducer = authSlice.reducer
export default authReducer
