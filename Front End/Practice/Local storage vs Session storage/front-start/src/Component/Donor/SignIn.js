import { useState } from "react";
import DonorService from "../Services/DonorService";
// import 'bootstrap/dist/css/bootstrap.min.css';
import { Link, useHistory } from "react-router-dom";
// import "./DonorSignIn.css";
// import "./logo.png";
import './Donor.css';

const SignIn=()=>{
    let [donorob,setdonorob]=useState({});
    var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setdonorob({...donorob,[name]:value});
    }

    const SignInFun=(event)=>{
        DonorService.SignInDonor(donorob).then((response)=>{
            console.log(response.data);
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
          <img src="./logo.png">
          <div class="sidenav">
         <div class="login-main-text">
            <h2>Application<br/> Login Page</h2>
            <p>Login or register from here to access.</p>
         </div>
      </div>
      </img>
      <div class="main">
         <div class="col-md-6 col-sm-12">
            <div class="login-form">
               <form>
                  <div class="form-group">
                     <label>User Name</label>
                     <input type="text" class="form-control" placeholder="User Name"/>
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" placeholder="Password"/>
                  </div>
                  <button type="submit" class="btn btn-black">Login</button>
                  <Link to="/DonorRegister">
                  <button type="submit" class="btn btn-secondary">Register</button></Link>
               </form>
            </div>
         </div>
      </div>
</body>
</div>
        )
}
export default SignIn;