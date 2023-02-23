import { useState } from "react";
import Service from "../Services/DonorService";
import { useHistory } from "react-router-dom";

const DonorSignIn=()=>{
    let [donorob,setdonorob]=useState({});
    var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setdonorob({...donorob,[name]:value});
    }

    const SignIn=(event)=>{
        Service.SignInDonor(donorob).then((response)=>{
            console.log(response.data);
            // history.push("DonorSignIn");
        });
    }
    return(
        <div>
            <form>
                Email Id : <input id="email" name="donorEmailId" value={donorob.donorEmailId} onChange={Change} placeholder="Email Id"></input><br/><br/>

                Password : <input id="password" name="donorPassword" value={donorob.donorPassword} onChange={Change} placeholder="Password"></input><br/><br/>

                <button type="button" id="btn" name="btn1" onClick={SignIn}>Submit</button>
            </form>
        </div>
    )
}
export default DonorSignIn;