import { useEffect, useState } from "react";
import EmployeeService from "../Services/EmployeeService";
// import 'bootstrap/dist/css/bootstrap.min.css';
import { Link, useHistory } from "react-router-dom";
// import "./DonorSignIn.css";
// import "./logo.png";
import './Employee.css';

const EmployeeSignIn=()=>{
    let [empob,setempob]=useState({});
    var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setempob({...empob,[name]:value});
    }

    useEffect(() => {
      localStorage.removeItem("emp"); 
}, [])


    const SignInFun=(event)=>{
      EmployeeService.SignInEmployee(empob).then((response)=>{
         // localStorage.don=response;
         localStorage.setItem("emp",JSON.stringify(response.data));
         history.push("/Employee")
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
            <h2>Application<br/> Employee Login Page</h2>
            <p>Login from here to access.</p>
         </div>
      </div>

      <div class="main">
         <div class="col-md-3 col-sm-12">
            <div class="login-form">
               <form>
                  <div class="form-group">
                     <label>Email Id</label>
                     <input type="text" class="form-control" id="email" name="employeeEmailId" value={empob.employeeEmailId} onChange={Change} placeholder="Email Id"/>
                  </div>
                  <div class="form-group">
                     <label>Password</label>
                     <input type="password" class="form-control" id="password" name="employeePassword" value={empob.employeePassword} onChange={Change} placeholder="Password"/>
                  </div>
                  <button type="button" class="btn btn-black"  id="btn" name="btn1" onClick={SignInFun}>Submit</button>
                  <Link to="/EmployeeRegister">
                  <button type="button" class="btn btn-secondary">Register</button></Link>
               </form>
            </div>
         </div>
      </div>

      







</body>
</div>
        )
}
export default EmployeeSignIn;