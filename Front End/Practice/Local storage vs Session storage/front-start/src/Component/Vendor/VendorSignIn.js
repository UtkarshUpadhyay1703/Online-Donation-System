import { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import VendorService from "../Services/VendorService";
// import './Donor.css';

const VendorSignIn=()=>{
    let [vendorob,setvendorob]=useState({});
    var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setvendorob({...vendorob,[name]:value});
    }

    useEffect(() => {
      localStorage.removeItem("ven"); 
}, [])

    const SignInFun=(event)=>{
        VendorService.SignInVendor(vendorob).then((response)=>{
         localStorage.setItem("ven",JSON.stringify(response.data));
         history.push("/Vendor")
        });
    }
    return(
        <div>
          <head>
          <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"/>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
          </head>
          <body>

          <div class="sidenav">
         <div class="login-main-text">
            <h2>Application<br/> Vendor Login Page</h2>
            <p>Login from here to access.</p>
         </div>
      </div>

      <div class="main">
         <div class="col-md-3 col-sm-12">
            <div class="login-form">
               <form>
                  <div class="form-group">
                     <label for="email">Email Id</label>
                     <input type="text" class="form-control" id="email" name="vendorEmailId" value={vendorob.vendorEmailId} onChange={Change} autoFocus placeholder="Email Id"/>
                  </div>
                  <div class="form-group">
                     <label for="password">Password</label>
                     <input type="password" class="form-control" id="password" name="vendorPassword" value={vendorob.vendorPassword} onChange={Change} placeholder="Password"/>
                  </div>
                  <button type="button" class="btn btn-black"  id="btn" name="btn1" onClick={SignInFun}>Submit</button>
                  <Link to="/VendorRegister">
                  <button type="button" class="btn btn-secondary">Register</button></Link>
               </form>
            </div>
         </div>
      </div>
</body>
</div>
        )
}
export default VendorSignIn;