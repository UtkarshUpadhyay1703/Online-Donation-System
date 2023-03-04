import { useState } from "react";
import DonorService from "../Services/DonorService";
// import 'bootstrap/dist/css/bootstrap.min.css';
import { Link, useHistory } from "react-router-dom";
import Dropdown from 'react-bootstrap/Dropdown';
import DropdownButton from 'react-bootstrap/DropdownButton';

// import "./DonorSignIn.css";
// import "./logo.png";
import './Donor.css';

const DonorDonateForm = () => {
    let [donorob, setdonorob] = useState({});
    let [donorob1, setdonorob1] = useState({});
    var history = useHistory();

    const Change = (event) => {
        var { name, value } = event.target
        setdonorob({ ...donorob, [name]: value });
    }

    const SignInFun = (event) => {
        DonorService.SignInDonor(donorob).then((response) => {
            // localStorage.don=response;
            // history.push("/rfvhe")
            localStorage.setItem("don", JSON.stringify(response));
            // setdonorob1(JSON.stringify(response));
            // alert(donorob1);
        });
    }
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
                        <h2>Application<br /> Login Page</h2>
                        <p>Login or register from here to access.</p>
                    </div>
                </div>

                <div class="main">
                    <div class="col-md-6 col-sm-12">
                        <div class="login-form">
                            <form>
                                <div class="form-group">
                                    <label>Email Id</label>
                                    <input type="text" class="form-control" id="email" name="donorEmailId" value={donorob.donorEmailId} onChange={Change} placeholder="Email Id" />
                                </div>
                                <div class="form-group">
                                    <label>Password</label>
                                    <input type="password" class="form-control" id="password" name="donorPassword" value={donorob.donorPassword} onChange={Change} placeholder="Password" />
                                </div>
                                <DropdownButton id="dropdown-item-button" title="Item Type">
                                    <Dropdown.Item as="option" value="Cloth">Cloth</Dropdown.Item>
                                    <Dropdown.Item as="option" value="Books">Books</Dropdown.Item>
                                    <Dropdown.Item as="option" value="Toys">Toys</Dropdown.Item>
                                    <Dropdown.Item as="option" value="e-Items">Electronic Items</Dropdown.Item>
                                    <Dropdown.Item as="option" value="Others">Others</Dropdown.Item>
                                </DropdownButton>
                                <label for="formFileLg" class="form-label">Enter Image of your donation item</label>
                                <input class="form-control form-control-lg" id="formFileLg" type="file" />
                                <button type="button" class="btn btn-black" id="btn" name="btn1" onClick={SignInFun}>Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </body>
        </div>
    )
}
export default DonorDonateForm;