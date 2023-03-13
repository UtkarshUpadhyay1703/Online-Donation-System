import { useEffect, useState } from "react";
import { useHistory } from "react-router-dom";
import EmployeeService from "../Services/EmployeeService";
import "./Employee.css";


const EmployeeImage=()=>{

    const [itemsArr,setitemsArr]=useState([]);

    const history=useHistory();
    useEffect(() => {
        // if (localStorage.getItem("don") != null) {

            if(!localStorage.getItem('emp')){
                history.push("/EmployeeSignIn");
            }
            EmployeeService.GetAllItemDonations().then((resp)=>{
                console.log(resp.data);
                setitemsArr(resp.data);
            })
    }, []);
    const logout = () => {
        localStorage.removeItem("emp");
        history.push("/EmployeeSignIn");
    }

    let DonorRender = () => {
        return itemsArr.map((don) => {
            return <tr key={don.id}>
                <td>{don.id}</td>
                <td>{don.itemType}</td>
                <td><img className="don1" src={`http://localhost:8080/file/download/donor/${don.id}`}/></td>
                <td><img className="emp1" src={`http://localhost:8080/file/download/employee/${don.id}`}/></td>
                <td>{don.itemStatusDonation}</td>
            </tr>
        })
    }

    return(
        <div>
            {/* <img src=""></img> */}
            Items Table
    <table class="table table-hover table-dark">
        <tr>
            <th>Id</th>
            <th>Item Type</th>
            <th>Donor pic</th>
            <th>Employee Pic</th>
            <th>Status</th>
        </tr>
        {DonorRender()}
    </table>
        </div>
    )
}
export default EmployeeImage;