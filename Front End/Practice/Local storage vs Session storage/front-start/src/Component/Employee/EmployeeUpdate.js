import { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
import EmployeeService from "../Services/EmployeeService";

const EmployeeUpdate = () => {
    let [employeeob, setemployeeob] = useState({});
    var history = useHistory();

    const Change = (event) => {
        var { name, value } = event.target
        setemployeeob({ ...employeeob, [name]: value });
    }
    useEffect(() => {
        //if (localStorage.getItem("don") != null) {
            if(!localStorage.getItem('emp')){
                history.push("/EmployeeSignIn");
            }
        }, [])
    const Add = (event) => {
        alert(JSON.parse(localStorage.getItem('emp')).id)
        EmployeeService.UpdateEmployee(JSON.parse(localStorage.getItem('emp')).id,employeeob).then((response) => {
            console.log(response.data);
            history.push("/EmployeeSignIn");

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
                        <h2>Application<br />Registration Employee</h2>
                        <p>Register from here to access.</p>
                    </div>
                </div>
                <div class="main">
                    <div class="col-md-3 col-sm-12">
                        <div class="login-form">
                            <form>
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" id="name1" name="employeeName" value={employeeob.employeeName} onChange={Change} placeholder="Name" autoFocus required></input><br/><br/>
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <textarea type="text" class="form-control" id="address" name="employeeAddress" value={employeeob.employeeAddress} onChange={Change} placeholder="Address" required />
                                </div>

                                <div class="form-group">
                                    <label>Mobile Number</label>
                                    <input type="tel" class="form-control" id="mobile" name="employeeMobileNo" value={employeeob.employeeMobileNo} onChange={Change} placeholder="Mobile Number" required />
                                </div>

                                <div class="form-group">
                                    <label>Aadhar Number</label>
                                    <input type="number" class="form-control" id="aadharnumber" name="employeeAadharNo" value={employeeob.employeeAadharno} onChange={Change} placeholder="Aadhar Number" required></input><br/><br/>
                                </div>
                                <div class="form-group">
                                    <label>Bank Account Number</label>
                                    <input type="number" class="form-control" id="bank" name="employeeBankAccountNo" value={employeeob.employeeBankAccountNo} onChange={Change} placeholder="Bank Account number" required></input><br/><br/>
                                </div>


                                <div class="form-group">
                                    <label>Email Id</label>
                                    <input type="email" class="form-control" id="email" name="employeeEmailId" value={employeeob.employeeEmailId} onChange={Change} placeholder="Email Id" required />
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" class="form-control" id="password" name="employeePassword" value={employeeob.employeePassword} onChange={Change} placeholder="Password" required />
                                </div>

                                <select class="selectpicker" data-style="btn-success" id="qualification" name="employeeQualification">
                                    <option value="Illiterate">Illiterate</option>
                    <option value="8th">8th</option>
                    <option value="10th">10th</option>
                    <option value="12th">12th</option>
                    <option value="Graduate and Above">Graduate and Above</option>
                                </select>

                                <Link to={"/EmployeeSignIn"}>
                                    <button type="button" class="btn btn-black" id="btn" name="btn2" onClick={Add} >Submit</button>
                                </Link>
                                <Link to={"/EmployeeSignIn"}>
                                    <button type="button" class="btn btn-secondary" >SignIn</button>
                                    </Link>
                            </form>
                        </div>
                    </div>
                </div>
            </body>
        </div>
    )
}
export default EmployeeUpdate;