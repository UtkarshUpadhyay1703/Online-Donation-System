import { Link } from "react-router-dom";
import EmployeeService from "../Services/EmployeeService";
import { useHistory } from "react-router-dom";
import VendorHome from "../Vendor/VendorHome";
import { useState } from "react";
const EmployeeView=()=>{
    const [bid1,setBid1]=useState({});

    var history=useHistory();
    const Delete=()=>{
        
    }
    const Bidding=(event)=>{
        EmployeeService.GetBalance().then((balance)=>{
            if(balance>30000){
                balance=balance-30000;
                let book=balance*.3;
                if(book<5000){return ;}
                let cloths=balance*.3;
                if(cloths<10000){return {
                    setBid1(...bid1,"")
                    <VendorHome                     
                    history.push("VendorHome");
                }}
            }
        })
    }

    return(
        <div>
            {/* delete via session */}
            <button type="button" onClick={Delete}>Delete your Id</button>
            <Link to="EmployeeUpdate">
                <button id="b" name="b">Update Details</button>
            </Link>
            <button onClick={Bidding}>Check for bidding</button>
        </div>
    )
}
export default EmployeeView;