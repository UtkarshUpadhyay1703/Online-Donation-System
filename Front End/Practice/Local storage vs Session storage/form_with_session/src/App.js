import './App.css';
import video from "./Background/video.mp4"
// import {BrowserRouter as Router,Route,Switch} from "react-router-dom";
import Employee from './Component/Employee/Employee';
import DonorRegitster from './Component/Donor/DonorRegister';
function App() {
  return (
    <div className="App">
      {/* <video autoPlay muted loop>
        <source src={video} type="video/mp4"/>
      </video> */}
{/* 
      <Router>
        <Switch>
        <Route path="/Employee" exact component={Employee}></Route>
        <Route path="/DonorRegitster" exact component={DonorRegitster}></Route>
        </Switch>
      </Router> */}
<DonorRegitster/>

{/* <div className='abc'>
  dfgyhjikolkjhgfghjkl
</div> */}
    </div>
  );
}
export default App;