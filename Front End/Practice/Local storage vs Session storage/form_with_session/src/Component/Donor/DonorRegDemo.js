import { useState } from "react";
import Service from "../Services/DonorService";
import { useHistory } from "react-router-dom";

const DonorRegDemo=()=>{
    let [donorob,setdonorob]=useState({});
    var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setdonorob({...donorob,[name]:value});
    }

    const Add=(event)=>{
        alert(donorob.donorName)
        Service.AddDonor(donorob).then((response)=>{
            console.log(response.data);
            history.push("DonorSignIn");
        });
    }
    return(
        <div>
            <form>
            {/* "donorName": "string",
  "donorAddress": "string",
  "donor_mobile_no": "string",
  "donorEmailId": "string",
  "donorPassword": "string"*/}
                Name : <input id="name11" name="donorName" value={donorob.donorName} onChange={Change} placeholder="Name"></input><br/><br/>

                Address : <input id="address" name="donorAddress" value={donorob.donorAddress} onChange={Change} placeholder="Address"></input><br/><br/>

                Mobile Number : <input id="mobile" name="donor_mobile_no" value={donorob.donor_mobile_no} onChange={Change} placeholder="Mobile Number"></input><br/><br/>

                Email Id : <input id="email" name="donorEmailId" value={donorob.donorEmailId} onChange={Change} placeholder="Email Id"></input><br/><br/>

                Password : <input id="password" name="donorPassword" value={donorob.donorPassword} onChange={Change} placeholder="Password"></input><br/><br/>

                <button type="button" id="btn" name="btn1" onClick={Add}>Submit</button>
            </form>
        </div>
    )
}
export default DonorRegDemo;