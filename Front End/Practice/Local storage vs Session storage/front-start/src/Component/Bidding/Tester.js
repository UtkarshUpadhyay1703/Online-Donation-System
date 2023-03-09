import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import EmployeeService from "../Services/EmployeeService";
import DonorService from "../Services/DonorService";



const Tester=()=>{

        const [form1, setform1] = useState(false);
        const [form2, setform2] = useState(false);
        const [form3, setform3] = useState(false);
        const [form4, setform4] = useState(false);
        useEffect(() => {
            console.log("in useeffect")
            EmployeeService.GetBalance().then((resp) => {
                alert("hello"+resp.data);
                let bal=resp.data-30000;
                let book=.3*bal;
                let cloth=.3*bal;
                let toy=.2*bal;
                let cycle=.2*bal;
                if(cycle>50000 && cycle<100000){
                 alert(resp.data);
                 setform4(true);
                }
                else if(toy>20000 && toy<50000){
                 alert(resp.data);
                 setform3(true);
                }
                else if(cloth>10000 && cloth<20000){
                 alert(resp.data);
                 setform2(true);
                }
               else if(book>5000 && book<10000){
                alert(resp.data);
                setform1(true);
               }
            });
        }, []);
        
    return(
<div>
        <h1>HNO</h1>

{form1?(<div>
    <table>
        <tr>
            <th>
                <h3> Bidding available for Books</h3>
                </th>
            <td>
            <Link to="/VendorSignIn">
            <button type="button" class="btn btn-black"  id="btn" name="btn1">Bid</button></Link>
            </td>
        </tr>
        </table>
    </div>):""}



    {form2?(<div>
    <table>
        <tr>
            <th>
                <h3> Bidding available for Books</h3>
                </th>
            <td>
            <Link to="/VendorSignIn">
            <button type="button" class="btn btn-black"  id="btn" name="btn1">Bid</button></Link>
            </td>
        </tr>
        <tr>
            <th>
                <h3> Bidding available for Cloths</h3>
                </th>
            <td>
            <Link to="/VendorSignIn">
            <button type="button" class="btn btn-black"  id="btn" name="btn1">Bid</button></Link>
            </td>
        </tr>
        </table>
    </div>):""}





    {form3?(<div>
    <table>
        <tr>
            <th>
                <h3> Bidding available for Books</h3>
                </th>
            <td>
            <Link to="/VendorSignIn">
            <button type="button" class="btn btn-black"  id="btn" name="btn1">Bid</button></Link>
            </td>
        </tr>
        <tr>
            <th>
                <h3> Bidding available for Cloths</h3>
                </th>
            <td>
            <Link to="/VendorSignIn">
            <button type="button" class="btn btn-black"  id="btn" name="btn1">Bid</button></Link>
            </td>
        </tr>
        <tr>
            <th>
                <h3> Bidding available for Toys</h3>
                </th>
            <td>
            <Link to="/VendorSignIn">
            <button type="button" class="btn btn-black"  id="btn" name="btn1">Bid</button></Link>
            </td>
        </tr>
        </table>
    </div>):""}



    {form4?(<div>
    <table>
        <tr>
            <th>
                <h3> Bidding available for Books</h3>
                </th>
            <td>
            <Link to="/VendorSignIn">
            <button type="button" class="btn btn-black"  id="btn" name="btn1">Bid</button></Link>
            </td>
        </tr>
        <tr>
            <th>
                <h3> Bidding available for Cloths</h3>
                </th>
            <td>
            <Link to="/VendorSignIn">
            <button type="button" class="btn btn-black"  id="btn" name="btn1">Bid</button></Link>
            </td>
        </tr>
        <tr>
            <th>
                <h3> Bidding available for Toys</h3>
                </th>
            <td>
            <Link to="/VendorSignIn">
            <button type="button" class="btn btn-black"  id="btn" name="btn1">Bid</button></Link>
            </td>
        </tr>
        <tr>
            <th>
                <h3> Bidding available for Cycle</h3>
                </th>
            <td>
            <Link to="/VendorSignIn">
            <button type="button" class="btn btn-black"  id="btn" name="btn1">Bid</button></Link>
            </td>
        </tr>
        </table>
    </div>):""}
</div>
    )
}
export default Tester;

