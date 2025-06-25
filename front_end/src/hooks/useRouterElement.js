import { useContext } from 'react';
import { Navigate, useRoutes } from 'react-router-dom';

import { AppContext } from '../contexts/app.context';
// import LayoutMain from '@/layouts/LayoutMain';
import Home from '../pages/user/home';
import Login from '../pages/auth/login';
import Register from '../pages/auth/register';
// import UsersDetails from '@/page/users/UsersDetails';
// import UsersPage from '@/page/users/UsersPage';

export default function useRoutesElements() {
  const { isAuthenticated } = useContext(AppContext);

  const ProtectedRoute = ({ children }) => {
    return isAuthenticated ? children : <Navigate to='/login' />;
  };

  const routeElements = useRoutes([
    // { path: '/', element: <LayoutMain>{<Home />}</LayoutMain> },
    { path: '/', element: <Home /> },
    {
      path: '/login',
      element: isAuthenticated ? <Navigate to='/' /> : <Login />
    },
    {
      path: '/register',
      element: isAuthenticated ? <Navigate to='/' /> : <Register />
    },
    // {
    //   path: '/users',
    //   element: (
    //     <ProtectedRoute>
    //       <LayoutMain>{<UsersPage />}</LayoutMain>
    //     </ProtectedRoute>
    //   )
    // },
    // {
    //   path: '/users/:id',
    //   element: (
    //     <ProtectedRoute>
    //       <LayoutMain>{<UsersDetails />}</LayoutMain>
    //     </ProtectedRoute>
    //   )
    // },
    { path: '*', element: <h1>404</h1> }
  ]);

  return routeElements;
}
