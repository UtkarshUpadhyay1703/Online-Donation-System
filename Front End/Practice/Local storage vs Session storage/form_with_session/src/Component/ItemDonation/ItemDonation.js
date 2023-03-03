import { useState } from "react";
import ItemDonationService from "../Services/ItemDonationService";
//import { useHistory } from "react-router-dom";

const ItemDonation=()=>{
    let [itemdonationob,setitemdonationob]=useState({});
    //var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setitemdonationob({...itemdonationob,[name]:value});
    }

    const Add=(event)=>{
        ItemDonationService.AddItemDonation(itemdonationob).then((response)=>{
            console.log(response.data);
            //history.push("DonorSignIn");
        });
    }

return(
    <div>
        <form>
                {/* Item Id : <input id="itemid" name="id" value={itemdonationob.id} onChange={Change} placeholder="Item Id"></input><br /><br />

                Donor Id : <input id="donid" name="donorId" value={itemdonationob.donorId} onChange={Change} placeholder="Donor Id"></input><br /><br />

                Employee Id : <input id="empid" name="employeeId" value={itemdonationob.employeeId} onChange={Change} placeholder="Employee Id"></input><br /><br /> */}

                Item Type : <input id="itemtype" name="itemType" value={itemdonationob.itemType} onChange={Change} placeholder="Item Type"></input><br /><br />

                Item Pic Via Donator : <input id="ipvd" name="itemPicViaDonator" value={itemdonationob.itemPicViaDonator} onChange={Change} placeholder="Item Pic Via Donator"></input><br /><br />

                Item Pic Via Employee  : <input id="ipve" name="itemPicViaEmployee" value={itemdonationob.itemPicViaEmployee} onChange={Change} placeholder="Item Pic Via Employee"></input><br /><br />

                Item Status Donation  : <input id="isd" name="itemStatusDonation" value={itemdonationob.itemStatusDonation} onChange={Change} placeholder="Item Status Donation"></input><br /><br />
 
                <button type="button" id="btn" name="btn1" onClick={Add}>Submit</button>
            </form>
    </div>
)
}
export default ItemDonation;