import { useEffect, useState } from "react";
import DonorService from "../Services/DonorService";
// import 'bootstrap/dist/css/bootstrap.min.css';
import { Link, useHistory } from "react-router-dom";
// import "./DonorSignIn.css";
// import "./logo.png";
import './Donor.css';

const DonorSignIn=()=>{
    let [donorob,setdonorob]=useState({});
    var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setdonorob({...donorob,[name]:value});
    }
    
//     useEffect(() => {
//          localStorage.removeItem("emp");
//          localStorage.removeItem("ven");
//   }, [])

    const SignInFun=(event)=>{
        DonorService.SignInDonor(donorob).then((response)=>{
         // localStorage.don=response;
         alert(response.data)
         console.log(response.data);
         localStorage.setItem("don",JSON.stringify(response.data));
         history.push("/Donor")
         // setdonorob1(JSON.stringify(response));
         // alert(donorob1);
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
            <h2>Application<br/> Donor Login Page</h2>
            <p>Login from here to access.</p>
         </div>
      </div>

      <div class="main">
         <div class="col-md-3 col-sm-12">
            <div class="login-form">
               <form>
                  <div class="form-group">
                     <label>Email Id</label>
                     <input type="text" class="form-control" id="email" name="donorEmailId" value={donorob.donorEmailId} onChange={Change} placeholder="Email Id"/>
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" id="password" name="donorPassword" value={donorob.donorPassword} onChange={Change} placeholder="Password"/>
                  </div>
                  <button type="button" class="btn btn-black"  id="btn" name="btn1" onClick={SignInFun}>Submit</button>
                  <Link to="/DonorRegister">
                  <button type="button" class="btn btn-secondary">Register</button></Link>
               </form>
            </div>
         </div>
      </div>
</body>
</div>
        )
}
export default DonorSignIn;