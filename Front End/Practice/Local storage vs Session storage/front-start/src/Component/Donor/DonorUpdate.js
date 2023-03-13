import { useEffect, useState } from "react";
import DonorService from "../Services/DonorService";
import { Link, useHistory } from "react-router-dom";
// import './Donor.css';

const DonorUpdate = () => {
    let [donorobOld, setdonorobOld] = useState({});
    let [donorob, setdonorob] = useState({});
    var history = useHistory();

    useEffect(() => {
        //if (localStorage.getItem("don") != null) {
            if(!localStorage.getItem('don')){
                history.push("/DonorSignIn");
            }
            setdonorobOld(JSON.parse(localStorage.getItem('don')));
        }, [])

    const Change = (event) => {
        var { name, value } = event.target
        setdonorob({ ...donorob, [name]: value });
        // <gyf hui={uh}></gyf>
    }

    const Add = (event) => {
        // alert(JSON.parse(localStorage.getItem('don')).id)
        DonorService.UpdateDonor(donorob,JSON.parse(localStorage.getItem('don')).id).then((response) => {
            console.log(response.data);
            history.push("/DonorsignIn");

        });
    }
    //     return(
    //         <div>
    //             <form>
    //                 Name : <input id="name11" name="donorName" value={donorob.donorName} onChange={Change} placeholder="Name"></input><br/><br/>

    //                 Address : <input id="address" name="donorAddress" value={donorob.donorAddress} onChange={Change} placeholder="Address"></input><br/><br/>

    //                 Mobile Number : <input id="mobile" name="donor_mobile_no" value={donorob.donor_mobile_no} onChange={Change} placeholder="Mobile Number"></input><br/><br/>

    //                 Email Id : <input id="email" name="donorEmailId" value={donorob.donorEmailId} onChange={Change} placeholder="Email Id"></input><br/><br/>

    //                 Password : <input id="password" name="donorPassword" value={donorob.donorPassword} onChange={Change} placeholder="Password"></input><br/><br/>
    // <Link to={"/SignIn"}>
    //                 <button type="button" id="btn" name="btn1" onClick={Add} >Submit</button>
    //             </Link>
    //             </form>
    //         </div>
    //     )
    return (
        <div>
            <head>
                <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
                <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
                <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
            </head>
            <body>
                <div class="sidenav">
         <div class="login-main-text">
            <h2>Application<br/>Update Donor</h2>
            <p>Register from here to access.</p>
         </div>
      </div>
                <div class="main">
                    <div class="col-md-3 col-sm-12">
                        <div class="login-form">
                            <form>
                                <div class="form-group">
                                    <label>Name</label>
                                    <input type="text" class="form-control" id="name11" name="donorName" value={donorob.donorName} onChange={Change} placeholder="Name" autoFocus required />
                                </div>
                                <div class="form-group">
                                    <label>Address</label>
                                    <textarea type="text" class="form-control" id="address" name="donorAddress" value={donorob.donorAddress} onChange={Change} placeholder="Address" required />
                                </div>
                                
                                <div class="form-group">
                                    <label>Mobile Number</label>
                                    <input type="tel" class="form-control" id="mobile" name="donorMobileNo" value={donorob.donorMobileNo} onChange={Change} placeholder="Mobile Number" required />
                                </div>
                                <div class="form-group">
                                    <label>Email Id</label>
                                    <input type="email" class="form-control" id="email" name="donorEmailId" value={donorob.donorEmailId} onChange={Change} placeholder="Email Id" required />
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" class="form-control" id="password" name="donorPassword" value={donorob.donorPassword} onChange={Change} placeholder="Password" required />
                                </div>
                                <Link to={"/DonorSignIn"}>
                                    <button type="button" class="btn btn-black" id="btn" name="btn1" onClick={Add} >Submit</button>
                                </Link>
                                <Link to={"/DonorSignIn"}>
                                <button type="submit" class="btn btn-secondary" >SignIn</button></Link>
                            </form>
                        </div>
                    </div>
                </div>
            </body>
        </div>
    )
}
export default DonorUpdate;