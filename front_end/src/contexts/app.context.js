import { createContext, useState } from 'react';
import { getAccessTokenFromLS } from '../utils/storage';

const initAppContext = {
  isAuthenticated: Boolean(getAccessTokenFromLS()),
  setIsAuthenticated: () => null
};

export const AppContext = createContext(initAppContext);

const AppContextProvider = ({ children }) => {
  const [isAuthenticated, setIsAuthenticated] = useState(initAppContext.isAuthenticated);

  return (
    <AppContext.Provider value={{ isAuthenticated, setIsAuthenticated }}>
      {children}
    </AppContext.Provider>
  );
};

export default AppContextProvider;
