import { Link } from "react-router-dom";

const VendorView=()=>{
    const Delete=()=>{
        
    }
    return(
        <div>
            {/* delete via session */}
            <button type="button" onClick={Delete}>Delete your Id</button>
            <Link to="VendorUpdate">
                <button id="c" name="c">Update Details</button>
            </Link>
        </div>
    )
}
export default VendorView;