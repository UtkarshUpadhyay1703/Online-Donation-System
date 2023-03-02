import { useState } from "react";
import EmployeeService from "../Services/EmployeeService";
import { useHistory } from "react-router-dom";

const EmployeeSignIn=()=>{
    let [employeeob,setemployeeob]=useState({});
    var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setemployeeob({...employeeob,[name]:value});
    }

    const SignIn=(event)=>{
        EmployeeService.SignInEmployee(employeeob).then((response)=>{
            console.log(response.data);
            // history.push("EmployeeSignIn");
        });
    }
    return(
        <div>
            <form>
                Email Id : <input id="employeeEmailId" name="employeeEmailId" value={employeeob.employeeEmailId} onChange={Change} placeholder="Email Id"></input><br/><br/>

                Password : <input id="employeePassword" name="employeePassword" value={employeeob.employeePassword} onChange={Change} placeholder="Password"></input><br/><br/>

                <button type="button" id="btn" name="btn1" onClick={SignIn}>Submit</button>
            </form>
        </div>
    )
}
export default EmployeeSignIn;