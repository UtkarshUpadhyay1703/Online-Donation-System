import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter as Router,Route,Switch} from "react-router-dom";


import DonorRegister from './Component/Donor/DonorRegister';
import DonorSignIn from './Component/Donor/DonorSignIn';
import DonorDonateForm from './Component/Donor/DonorDonateForm';
// import Employee from './Component/Employee/Employee';
import DonorDashBoard from './Component/Donor/DashBord/DonorDashBoard';
import EmployeeDashBoard from './Component/Employee/EmployeeDashBoard';
import DonorTableDashBoard from './Component/Employee/Tables/DonorTableDashboard';
import WelcomePage from './Component/LandingPage/WelcomePage';
import DonationPayment from './Component/Payment/DonationPayment';
import QRDonation from './Component/Payment/QRDonation';
import DonorDonationPayment from './Component/Donor/DonorDonationPayment';
import DonorUpdate from './Component/Donor/DonorUpdate';

import EmployeeSignIn from './Component/Employee/EmployeeSignIn';
import EmployeeRegister from './Component/Employee/EmployeeRegister';
import EmployeeBidsDashBoard from './Component/Employee/EmployeeBidsDashBoard';
// import EmployeeImage from './Component/Employee/EmployeeImage';
import DonationsTableDashboard from './Component/Employee/Tables/DonationsTableDashboard';
import EmployeeUpdate from './Component/Employee/EmployeeUpdate';



import VendorRegister from './Component/Vendor/VendorRegister';
import VendorSignIn from './Component/Vendor/VendorSignIn';
import VendorBidding from './Component/Vendor/VendorBidding';
import VendorBiddingSystem from './Component/Vendor/VendorBiddingSystem';
import VendorDashBoard from './Component/Vendor/VendorDashBoard.js';
import VendorUpdate from './Component/Vendor/VendorUpdate';
import VendorTableDashBoard from './Component/Employee/Tables/VendorTableDashboard';



import AvailableBidding from './Component/Bidding/AvailableBidding';
import Tester from './Component/Bidding/Tester';
import EmployeeSelectedBidsDashBoard from './Component/Employee/EmployeeSelectedBidsDashBoard';

function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route path="/" exact component={WelcomePage}></Route>
        <Route path="/DonorRegister" exact component={DonorRegister}></Route>
        <Route path="/DonorSignIn" exact component={DonorSignIn}></Route>
        <Route path="/DonorDonateForm" exact component={DonorDonateForm}></Route>
        {/* <Route path="/Employee" exact component={Employee}></Route> */}
        <Route path="/Donor" exact component={DonorDashBoard}></Route>
        <Route path="/DonorTableDashBorad" exact component={DonorTableDashBoard}></Route>
        <Route path="/DonationPayment" exact component={DonationPayment}></Route>
        <Route path="/QRDonation" exact component={QRDonation}></Route>
        <Route path="/DonorDonationPayment" exact component={DonorDonationPayment}></Route>
        <Route path="/DonorUpdate" exact component={DonorUpdate}></Route>
        



        <Route path="/Employee" exact component={EmployeeDashBoard}></Route>
        <Route path="/EmployeeSignIn" exact component={EmployeeSignIn}></Route>
        <Route path="/EmployeeRegister" exact component={EmployeeRegister}></Route>
        <Route path="/EmployeeBidsDashBoard" exact component={EmployeeBidsDashBoard}></Route>
        <Route path="/EmployeeSelectedBidsDashBoard" exact component={EmployeeSelectedBidsDashBoard}></Route>        
        {/* <Route path="/EmployeeImage" exact component={EmployeeImage}></Route> */}
        <Route path="/DonationsTableDashboard" exact component={DonationsTableDashboard}/>
        <Route path="/EmployeeUpdate" exact component={EmployeeUpdate}/>




        
        
        
        <Route path="/VendorRegister" exact component={VendorRegister}></Route>
        <Route path="/VendorSignIn" exact component={VendorSignIn}></Route>
        <Route path="/VendorBiddingSystem" exact component={VendorBiddingSystem}></Route>
        {/* <Route path="/Vendor" exact component={VendorDashBoard}></Route> */}
        <Route path="/vendor" exact component={VendorDashBoard}></Route>
        <Route path="/VendorUpdate" exact component={VendorUpdate}></Route>
        <Route path="/VendorTableDashBoard" exact component={VendorTableDashBoard}></Route>
        {/* <Route path="/VendorSignInDashBoard" exact component={VendorSignInDashBoard}></Route> */}
        {/* <Route path="/VendorRegisterDashBoard" exact component={VendorRegisterDashBoard}></Route> */}
        <Route path="/VendorBidding" exact component={VendorBidding}></Route>



        <Route path="/AvailableBidding" exact component={AvailableBidding}></Route>
        <Route path="/Tester" exact component={Tester}></Route>
        
        </Switch>
        </Router>
    </div>
  );
}

export default App;
