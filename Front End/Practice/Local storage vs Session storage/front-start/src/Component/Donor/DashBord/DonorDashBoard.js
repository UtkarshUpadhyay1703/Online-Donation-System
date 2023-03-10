// import CustomerLogin from "../Login/CustomerLogin";

import React, { useEffect, useState } from "react";
import { Link, useHistory } from "react-router-dom";
// import DonorService from "../../Services/DonorService";
// import DonorDonationPayment from "../DonorDonationPayment";
export const UserContext = React.createContext()

const DonorDashBoard = () => {

    let [donorob, setdonorob] = useState({});
    var history = useHistory();

    useEffect(() => {
        // if (localStorage.getItem("don") != null) {
        // if(!localStorage.getItem('don')){
        //     history.push("/DonorSignIn");
        // }
        setdonorob(JSON.parse(localStorage.getItem('don')));
    }, [])
    // const del=()=>{
    //     alert(donorob.id)
    //     DonorService.DeleteDonor(donorob.id).then((resp)=>{
    //         alert("deleted");
    //     })
    // }

    // const payment=()=>{
    //     alert(donorob.id)
    //     return <DonorDonationPayment donob={donorob}>Go</DonorDonationPayment>
    // }
    const onFileChangeHandler = (e) => {
        e.preventDefault();
        this.setState({
            selectedFile: e.target.files[0]
        });

    };
    const Send = ((event) => {
        const formData = new FormData();
        formData.append('image', this.state.selectedFile);
        alert(document.getElementById("type").value);//for checking
        formData.append('type', document.getElementById("type").value);
        fetch('http://localhost:8080/file/upload/{' + donorob.id + '}/donor', {
            method: 'post',
            body: formData
        }).then(res => {
            if (res.ok) {
                console.log(res.data);
                alert("File uploaded successfully.")
            }
        });
    })

    const logout = () => {
        localStorage.removeItem("don");
    }

    return (
        <div>
            <body id="page-top">
                {/* <UserContext.Provider value={donorob}>
                    <DonorDonationPayment/>
                </UserContext.Provider>
                <button type="button" onClick={payment}>Donate</button> */}

                {/* <!-- Page Wrapper --> */}
                <div id="wrapper">

                    {/* <!-- Sidebar --> */}
                    <ul className="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                        {/* <!-- Sidebar - Brand --> */}
                        <a className="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                            <div className="sidebar-brand-icon rotate-n-15">
                                <i className="fas fa-laugh-wink"></i>
                            </div>
                            <div className="sidebar-brand-text mx-3">Donor DashBoard</div>
                        </a>

                        {/* <!-- Divider --> */}
                        <hr className="sidebar-divider my-0" />



                        {/* <!-- Divider --> */}
                        <hr className="sidebar-divider" />

                        {/* <!-- Heading --> */}
                        {/* <div className="sidebar-heading">
                            Interface
                        </div> */}

                        {/* <!-- Nav Item - Pages Collapse Menu --> */}
                        <li className="nav-item">
                            <a className="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTwo"
                                aria-expanded="true" aria-controls="collapseTwo">
                                <i className="fas fa-fw fa-cog"></i>
                                <span>Components</span>
                            </a>
                            <div id="collapseTwo" className="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                                <div className="bg-white py-2 collapse-inner rounded">
                                    <h6 className="collapse-header">Functionalities of Donor</h6>
                                    <Link className="collapse-item" to="/DonorDonateForm">Donation Form</Link>
                                    <Link className="collapse-item" to="/DonorDonationPayment">Donate Money</Link>
                                </div>
                            </div>
                        </li>



                        {/* <!-- Divider --> */}
                        <hr className="sidebar-divider" />



                        {/* <!-- Nav Item - Tables --> */}
                        <li className="nav-item">
                            <a className="nav-link" href="tables.html">
                                <i className="fas fa-fw fa-table"></i>
                                <span>Tables</span></a>
                        </li>

                        {/* <!-- Divider --> */}
                        <hr className="sidebar-divider d-none d-md-block" />



                    </ul>


                    {/* <!-- Content Wrapper --> */}
                    <div id="content-wrapper" className="d-flex flex-column">

                        {/* <!-- Main Content --> */}
                        <div id="content">

                            {/* <!-- Topbar --> */}
                            <nav className="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">



                                <ul className="navbar-nav ml-auto">






                                    {/* <!-- Nav Item - User Information --> */}
                                    <li className="nav-item dropdown no-arrow">
                                        <a className="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                            <span className="mr-2 d-none d-lg-inline text-gray-600 small">Donor</span>
                                            <img className="img-profile rounded-circle"
                                                src="img/undraw_profile.svg" />
                                        </a>
                                        {/* <!-- Dropdown - User Information --> */}
                                        <div className="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                            aria-labelledby="userDropdown">
                                            <a className="dropdown-item" href="#">
                                                <i className="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                                Profile
                                            </a>
                                            <a className="dropdown-item" href="#">
                                                <i className="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                                Settings
                                            </a>
                                            <div className="dropdown-divider"></div>
                                            <a className="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                                <i className="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                                <button onClick={logout} > Logout </button>
                                            </a>
                                        </div>
                                    </li>

                                </ul>

                            </nav>
                            <div class="main">
                                <div class="col-md-6 col-sm-12">
                                    <div class="login-form">
                                        <form>
                                            <select class="selectpicker" data-style="btn-success" name="type" id="type">
                                                <option value="Cloth">Cloth</option>
                                                <option value="Books">Books</option>
                                                <option value="Toys">Toys</option>
                                                <option value="e-Items">Electronic Items</option>
                                                <option value="Others">Others</option>
                                            </select>
                                            {/* <label for="formFileLg" class="form-label">Enter Image of your donation item</label>
                                <input class="form-control form-control-lg" id="formFileLg" type="file" />
                                <button type="button" class="btn btn-black" id="btn" name="btn1" onClick={SignInFun}>Submit</button> */}
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        <div class="form-group files color">
                                                            <label>Upload Your File </label>
                                                            <input type="file" class="form-control" name="file" width="40px" onChange={onFileChangeHandler} />
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <button type="button" class="btn btn-black" id="btn" name="btn1" onClick={Send}>Submit</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </body >
        </div >
    );
}
export default DonorDashBoard;