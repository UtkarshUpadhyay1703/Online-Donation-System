import { useState } from "react";
import VendorService from "../Services/VendorService";
import { useHistory } from "react-router-dom";

const VendorSignIn=()=>{
    let [vendorob,setvendorob]=useState({});
    var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setvendorob({...vendorob,[name]:value});
    }

    const SignIn=(event)=>{
        VendorService.SignInVendor(vendorob).then((response)=>{
            console.log(response.data);
            // history.push("VendorSignIn");
        });
    }
    return(
        <div>
            <form>
                Email Id : <input id="email" name="vendorEmailId" value={vendorob.vendorEmailId} onChange={Change} placeholder="Email Id"></input><br/><br/>

                Password : <input id="password" name="vendorPassword" value={vendorob.vendorPassword} onChange={Change} placeholder="Password"></input><br/><br/>

                <button type="button" id="btn" name="btn1" onClick={SignIn}>Submit</button>
            </form>
        </div>
    )
}
export default VendorSignIn;