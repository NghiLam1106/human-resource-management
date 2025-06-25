import { clearLS } from '../../utils/storage';
import { useNavigate } from 'react-router-dom';
import { Button } from '@mui/material';
import { AppContext } from '../../contexts/app.context';
import { useContext } from 'react';
import { toast } from 'sonner';

export default function Home() {
  const navigate = useNavigate();
  const { setIsAuthenticated } = useContext(AppContext);

  const handleLogout = () => {
    // Xóa token khỏi localStorage
    clearLS()

    setIsAuthenticated(false)
    toast.success('Logout successfully!')

    // Chuyển hướng
    navigate('/login')
  }

  return <>
    <h1>Hello</h1>
    <Button onClick={handleLogout}>Logout</Button>
  </>;
}

