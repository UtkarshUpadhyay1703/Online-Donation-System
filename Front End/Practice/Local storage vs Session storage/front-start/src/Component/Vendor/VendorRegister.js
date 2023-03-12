import { useState } from "react";
import { Link, useHistory } from "react-router-dom";
import VendorService from "../Services/VendorService";
// import './Donor.css';

const VendorRegister = () => {
    let [vendorob,setvendorob]=useState({});
    var history=useHistory();
                
    const Change=(event)=>{
        var {name,value}=event.target
        setvendorob({...vendorob,[name]:value});
    }

    useEffect(() => {
        localStorage.removeItem("ven"); 
  }, [])
              
    const Add=(event)=>{
        VendorService.AddVendor(vendorob).then((response)=>{
            console.log(response.data);
            history.push("/VendorSignIn");
        });
    }

    return (
        <div>
            <head>
                <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
                <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
                <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
            </head>
            <body>
                <div class="sidenav">
         <div class="login-main-text">
            <h2>Application<br/>Registration Vendor</h2>
            <p>Register from here to access.</p>
         </div>
      </div>
                <div class="main">
                    <div class="col-md-3 col-sm-12">
                        <div class="login-form">
                            <form>
                                <div class="form-group">
                                    <label for="name11">Name</label>
                                    <input type="text" class="form-control" id="name11" name="vendorCompanyName" value={vendorob.vendorName} onChange={Change} placeholder="Name" autoFocus required />
                                </div>
                                <div class="form-group">
                                    <label for="address">Address</label>
                                    <textarea type="text" class="form-control" id="address" name="vendorCompanyAddress" value={vendorob.vendorAddress} onChange={Change} placeholder="Address" required />
                                </div>
                                
                                <div class="form-group">
                                    <label>Mobile Number</label>
                                    <input type="tel" class="form-control" id="mobile" name="vendorMobileNo" value={vendorob.vendorMobileNo} onChange={Change} placeholder="Mobile Number" required />
                                </div>
                                <div class="form-group">
                                    <label>Aadhar Number</label>
                                    <input type="number" class="form-control" id="aadhar" name="vendorAadharNo" value={vendorob.vendorAadharNo} onChange={Change} placeholder="Aadhar Number" required />
                                </div>
                                <div class="form-group">
                                    <label>Company Bank Account Number</label>
                                    <input type="number" class="form-control" id="account" name="vendorCompanyBankAccountNo" value={vendorob.vendorCompanyBankAccountNo} onChange={Change} placeholder="Company Bank Account Number" required />
                                </div>
                                <div class="form-group">
                                    <label>Company Bank IFSC Number</label>
                                    <input type="number" class="form-control" id="ifsc" name="vendorCompanyBankIFSC" value={vendorob.vendorCompanyBankIFSC} onChange={Change} placeholder="Company Bank IFSC Number" required />
                                </div>
                                <div class="form-group">
                                    <label for="email">Email Id</label>
                                    <input type="email" class="form-control" id="email" name="vendorEmailId" value={vendorob.vendorEmailId} onChange={Change} placeholder="Email Id" required />
                                </div>
                                <div class="form-group">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" id="password" name="vendorPassword" value={vendorob.vendorPassword} onChange={Change} placeholder="Password" required />
                                </div>
                                <Link to={"/VendorSignIn"}>
                                    <button type="button" class="btn btn-black" id="btn" name="btn1" onClick={Add} >Submit</button>
                                </Link>
                                <Link to={"/VendorSignIn"}>
                                <button type="submit" class="btn btn-secondary" >SignIn</button></Link>
                            </form>
                        </div>
                    </div>
                </div>
            </body>
        </div>
    )
}
export default VendorRegister;