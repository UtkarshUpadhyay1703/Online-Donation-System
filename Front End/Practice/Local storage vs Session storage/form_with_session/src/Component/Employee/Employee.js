import { useEffect, useState } from "react"
import Service from "../Service"

const Employee=()=>{
    const [Donors,setDonors]=useState([]);
    useEffect (()=>{
        Service.GetAllDonors().then((resp)=>{
            console.log(resp.data);
            setDonors(resp.data);
        });
    },[]);

    let Render=()=>{
        return Donors.map((don)=>{
            return <tr key={don.id}>
                <td>{don.id}</td>
                <td>{don.donorName}</td>
                <td>{don.donorAddress}</td>
                <td>{don.donorEmailId}</td>
                <td>{don.donorStatus}</td>
                <td>{don.donor_mobile_no}</td>
            </tr>
        })
    }
    return(
        <div>
            Donors Table
            <table>
                <tr>
                    <th>Id</th>
                    <th>Address</th>
                    <th>Email Id</th>
                    <th>Name</th>
                    <th>Status</th>
                    <th>Mobile Number</th>
                </tr>
                {Render()}
            </table>
        </div>
    )
}
export default Employee;