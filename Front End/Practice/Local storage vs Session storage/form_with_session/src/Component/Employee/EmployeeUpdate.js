import { useState } from "react";
import EmployeeService from "../Services/EmployeeService";
import { useHistory } from "react-router-dom";

const EmployeeUpdate = () => {
    let [employeeob, setemployeeob] = useState({});
    var history = useHistory();

    const Change = (event) => {
        var { name, value } = event.target
        setemployeeob({ ...employeeob, [name]: value });
    }

    const Update = (event) => {
        EmployeeService.UpdateEmployee(employeeob).then((response) => {
            console.log(response.data);
            history.push("EmployeeSignIn");
        });
    }
    return (
        <div>
            <form>
                Id : <input id="id2" name="id" value={employeeob.id} onChange={Change} placeholder="Id"></input><br /><br />

                Name : <input id="name12" name="employeeName" value={employeeob.employeeName} onChange={Change} placeholder="Name"></input><br /><br />

                Address : <input id="address" name="employeeAddress" value={employeeob.employeeAddress} onChange={Change} placeholder="Address"></input><br />< br/>

                Mobile Number : <input id="mobile" name="employeeMobileNo" value={employeeob.employeeMobileNo} onChange={Change} placeholder="Mobile Number"></input><br/><br/>

                Aadhar Number : <input id="aadharnumber" name="employeeAadharNo" value={employeeob.employeeAadharno} onChange={Change} placeholder="Aadhar Number"></input><br/><br/>

                Bank Account number : <input id="bank" name="employeeBankAccountNo" value={employeeob.employeeBankAccountNo} onChange={Change} placeholder="Bank Account number"></input><br/><br/>

                Email Id : <input id="email" name="employeeEmailId" value={employeeob.employeeEmailId} onChange={Change} placeholder="Email Id"></input><br /><br />

                Password : <input id="password" name="employeePassword" value={employeeob.employeePassword} onChange={Change} placeholder="Password"></input><br /><br />

                {/* Qualification : <input id="qualification" name="employeeQualification" value={employeeob.employeeQualification} onChange={Change} placeholder="Qualification"></input><br/><br/> */}

                Qualification : <select id="qualification" name="employeeQualification">
                    <option value="Illiterate">Illiterate</option>
                    <option value="8th">8th</option>
                    <option value="10th">10th</option>
                    <option value="12th">12th</option>
                    <option value="Graduate and Above">Graduate and Above</option>
                </select>


                <button type="button" id="btn" name="btn2" onClick={Update}>Submit</button>
            </form>
        </div>
    )
}
export default EmployeeUpdate;