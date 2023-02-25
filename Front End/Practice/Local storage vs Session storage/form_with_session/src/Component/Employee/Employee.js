import { useEffect, useState } from "react"
import DonorService from "../Services/DonorService"
import VendorService from "../Services/VendorService"

const Employee=()=>{
    const [Donors,setDonors]=useState([]);
    useEffect (()=>{
        DonorService.GetAllDonors().then((resp)=>{
            console.log(resp.data);
            setDonors(resp.data);
        });
    },[]);

    const [Vendors,setVendors]=useState([]);
    useEffect (()=>{
        VendorService.GetAllVendors().then((resp)=>{
            console.log(resp.data);
            setVendors(resp.data);
        });
    },[]);

    let DonorRender=()=>{
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

    let VendorRender=()=>{
        return Vendors.map((ven)=>{
            return <tr key={ven.id}>
                <td>{ven.id}</td>
                <td>{ven.vendorCompanyName}</td>
                <td>{ven.vendorCompanyAddress}</td>
                <td>{ven.vendor_mobile_no}</td>
                <td>{ven.vendor_aadhar_no}</td>
                <td>{ven.vendorEmailId}</td>
                <td>{ven.vendorStatus}</td>
            </tr>
        })
    }
    return(
        <div>
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
                {DonorRender()}
            </table>
            </div>
            <div>
        Vendors Table
        <table>
            <tr>
                <th>Id</th>
                <th>Company Name</th>
                <th>Company Address</th>
                <th>Mobile Number</th>
                <th>Aadhar Number</th>
                <th>Email Id</th>
                <th>Status</th>
            </tr>
            {VendorRender()}
        </table>
        </div>
    </div>
    )
}
export default Employee;