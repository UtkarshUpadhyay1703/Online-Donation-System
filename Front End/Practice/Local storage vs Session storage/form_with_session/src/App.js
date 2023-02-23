import './App.css';
import video from "./Background/video.mp4"
import {BrowserRouter as Router,Route,Switch} from "react-router-dom";
import Employee from './Component/Employee/Employee';
import DonorRegitster from './Component/Donor/DonorRegister';
import DonorRegDemo from './Component/Donor/DonorRegDemo';
import DonorSignIn from './Component/Donor/DonorSignIn';
import DonorView from './Component/Donor/DonorView';
import DonorUpdate from './Component/Donor/DonorUpdate';

function App() {
  return (
    <div className="App">
      {/* <video autoPlay muted loop>
        <source src={video} type="video/mp4"/>
      </video> */}

      <Router>
        <Switch>
        <Route path="/Employee" exact component={Employee}></Route>
        {/* <Route path="/DonorRegitster" exact component={DonorRegitster}></Route> */}
        <Route path="/DonorReg" exact component={DonorRegDemo}></Route>
        <Route path="/DonorSignIn" exact component={DonorSignIn}></Route>
        <Route path="/DonorView" exact component={DonorView}></Route>
        <Route path="/DonorUpdate" exact component={DonorUpdate}></Route>
        </Switch>
      </Router>

{/* <div className='abc'>
  dfgyhjikolkjhgfghjkl
</div> */}
    </div>
  );
}
export default App;