import { useState } from "react";
import VendorService from "../Services/VendorService";
import { useHistory } from "react-router-dom";

const VendorRegDemo=()=>{
    let [vendorob,setvendorob]=useState({});
    var history=useHistory();
                
    const Change=(event)=>{
        var {name,value}=event.target
        setvendorob({...vendorob,[name]:value});
    }
              
    const Add=(event)=>{
        alert(vendorob.vendorName)
        VendorService.AddVendor(vendorob).then((response)=>{
            console.log(response.data);
            history.push("VendorSignIn");
        });
    }
    return(
        <div>
            <form>
            {/* "vendorName": "string",
  "vendorAddress": "string",
  "vendor_mobile_no": "string",
  "vendorEmailId": "string",
  "vendorPassword": "string"*/}
                Company Name : <input id="name11" name="vendorCompanyName" value={vendorob.vendorName} onChange={Change} placeholder="Name"></input><br /><br />

                Company Address : <input id="address" name="vendorCompanyAddress" value={vendorob.vendorAddress} onChange={Change} placeholder="Address"></input><br /><br />

                Mobile Number : <input id="mobile" name="vendor_mobile_no" value={vendorob.vendor_mobile_no} onChange={Change} placeholder="Mobile Number"></input><br /><br />

                Aadhar Number : <input id="aadhar" name="vendor_aadhar_no" value={vendorob.vendor_aadhar_no} onChange={Change} placeholder="Aadhar Number"></input><br /><br />

                Company Bank Account Number : <input id="mobile" name="vendorCompanyBankAccountNo" value={vendorob.vendorCompanyBankAccountNo} onChange={Change} placeholder="Company Bank Account Number"></input><br /><br />

                Email Id : <input id="email" name="vendorEmailId" value={vendorob.vendorEmailId} onChange={Change} placeholder="Email Id"></input><br /><br />

                Password : <input id="password" name="vendorPassword" value={vendorob.vendorPassword} onChange={Change} placeholder="Password"></input><br /><br />
 
                <button type="button" id="btn" name="btn1" onClick={Add}>Submit</button>
            </form>
        </div>
    )
}
export default VendorRegDemo;