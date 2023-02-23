import { useState } from "react";
import Service from "../Services/DonorService";
import { useHistory } from "react-router-dom";

const DonorUpdate = () => {
    let [donorob, setdonorob] = useState({});
    var history = useHistory();

    const Change = (event) => {
        var { name, value } = event.target
        setdonorob({ ...donorob, [name]: value });
    }

    const Update = (event) => {
        Service.UpdateDonor(donorob).then((response) => {
            console.log(response.data);
            history.push("DonorSignIn");
        });
    }
    return (
        <div>
            <form>
                Id : <input id="id1" name="id" value={donorob.id} onChange={Change} placeholder="Id"></input><br /><br />

                Name : <input id="name11" name="donorName" value={donorob.donorName} onChange={Change} placeholder="Name"></input><br /><br />

                Address : <input id="address" name="donorAddress" value={donorob.donorAddress} onChange={Change} placeholder="Address"></input><br /><br />

                Mobile Number : <input id="mobile" name="donor_mobile_no" value={donorob.donor_mobile_no} onChange={Change} placeholder="Mobile Number"></input><br /><br />

                Email Id : <input id="email" name="donorEmailId" value={donorob.donorEmailId} onChange={Change} placeholder="Email Id"></input><br /><br />

                Password : <input id="password" name="donorPassword" value={donorob.donorPassword} onChange={Change} placeholder="Password"></input><br /><br />

                <button type="button" id="btn" name="btn1" onClick={Update}>Submit</button>
            </form>
        </div>
    )
}
export default DonorUpdate;