import logo from './logo.svg';
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router,Route,Switch} from "react-router-dom";
// import WelcomePage from './Component/LandingPage/WelcomePage';
import DonorRegDemo from './Component/Donor/DonorRegDemo';
import SignIn from './Component/Donor/SignIn';
import DonorDonateForm from './Component/Donor/DonorDonateForm';
// import Employee from './Component/Employee/Employee';
import DonorDashBoard from './Component/DashBord/DonorDashBoard';
import EmployeeDashBoard from './Component/Employee/EmployeeDashBoard';
import DonorTableDashBoard from './Component/Employee/Tables/DonorTableDashboard';
function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          {/* <Route path="/" exact component={WelcomePage}></Route> */}
        <Route path="/DonorRegister" exact component={DonorRegDemo}></Route>
        <Route path="/SignIn" exact component={SignIn}></Route>
        <Route path="/DonorDonateForm" exact component={DonorDonateForm}></Route>
        {/* <Route path="/Employee" exact component={Employee}></Route> */}
        <Route path="/Donor" exact component={DonorDashBoard}></Route>
        <Route path="/Employee" exact component={EmployeeDashBoard}></Route>
        <Route path="/DonorTable" exact component={DonorTableDashBoard}></Route>
        </Switch>
        </Router>
    </div>
  );
}

export default App;
