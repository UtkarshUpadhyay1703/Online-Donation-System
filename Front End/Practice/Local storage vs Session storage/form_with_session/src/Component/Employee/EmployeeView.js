import { Link } from "react-router-dom";

const EmployeeView=()=>{
    const Delete=()=>{
        
    }
    return(
        <div>
            {/* delete via session */}
            <button type="button" onClick={Delete}>Delete your Id</button>
            <Link to="EmployeeUpdate">
                <button id="b" name="b">Update Details</button>
            </Link>
        </div>
    )
}
export default EmployeeView;