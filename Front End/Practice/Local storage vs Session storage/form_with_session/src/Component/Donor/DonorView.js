import { Link } from "react-router-dom";

const DonorView=()=>{
    const Delete=()=>{
        
    }
    return(
        <div>
            {/* delete via session */}
            <button type="button" onClick={Delete}>Delete your Id</button>
            <Link to="DonorUpdate">
                <button id="b" name="b">Update Details</button>
            </Link>
        </div>
    )
}
export default DonorView;