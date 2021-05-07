
import {BrowserRouter, Route} from 'react-router-dom';
import Home from './pages/Home';
import Dashboard from './pages/Dashboard';

const Routes = () => {
    return (
        
        <BrowserRouter>
        <switch>
          <Route path="/"exact>
            <Home />

          </Route>
          <Route path="/dashboard">
              <Dashboard />
          </Route>

        </switch>
         </BrowserRouter>
    );
  }
  
  export default Routes;