import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  loading: false,
  error: undefined,
  size: undefined,
  apiState: 200
}

const appSlice = createSlice({
  name: 'app',
  initialState,
  reducers: {
    setAPIState(state, action) {
      state.apiState = action.payload
    }
  }
})

export const appAction = appSlice.actions
const appReducer = appSlice.reducer
export default appReducer
