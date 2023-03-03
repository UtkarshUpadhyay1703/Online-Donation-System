import { useState } from "react";
import BiddingTableService from "../Services/BiddingTableService";
//import { useHistory } from "react-router-dom";

const BiddingTable=()=>{
    let [biddingtableob,setbiddingtableob]=useState({});
    //var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setbiddingtableob({...biddingtableob,[name]:value});
    }

    const Add=(event)=>{
        BiddingTableService.AddBiddingTable(biddingtableob).then((response)=>{
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

                Low Price Toy : <input id="lpt" name="low_price_toy" value={biddingtableob.low_price_toy} onChange={Change} placeholder="Low Price Toy"></input><br /><br />

                Low Price Cloth : <input id="ipc" name="low_price_cloth" value={biddingtableob.low_price_cloth} onChange={Change} placeholder="Low Price Cloth"></input><br /><br />

                Low Price Notebook : <input id="ipn" name="low_price_notebook" value={biddingtableob.low_price_notebook} onChange={Change} placeholder="Low Price Notebook"></input><br /><br />

                Low Price Cycle : <input id="isd" name="low_price_cycle" value={biddingtableob.low_price_cycle} onChange={Change} placeholder="Low Price Cycle"></input><br /><br />
 
                <button type="button" id="btn" name="btn1" onClick={Add}>Submit</button>
            </form>
    </div>
)
}
export default BiddingTable;