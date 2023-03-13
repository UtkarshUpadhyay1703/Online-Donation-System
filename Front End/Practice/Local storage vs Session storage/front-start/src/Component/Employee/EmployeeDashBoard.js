import { useEffect, useState } from "react"
import { Link, useHistory } from "react-router-dom";
import DonorService from "../Services/DonorService"
import EmployeeService from "../Services/EmployeeService";
import VendorService from "../Services/VendorService"

const EmployeeDashBoard = () => {
    let [vendorob, setvendorob] = useState({});
    const history=useHistory();
    useEffect(() => {
        // if (localStorage.getItem("don") != null) {
            if(!localStorage.getItem('emp')){
                history.push("/EmployeeSignIn");
            }
            setvendorob(JSON.parse(localStorage.getItem('emp')));
            
    }, [])

    const del=()=>{
        alert(JSON.parse(localStorage.getItem('emp')).id)
        EmployeeService.DeleteEmployee(JSON.parse(localStorage.getItem('emp')).id).then((resp)=>{
            console.log(resp.data);
        })
    }
       
    const upd=()=>{
        history.push("/EmployeeUpdate");
    }

    const logout = () => {
        localStorage.removeItem("emp");
        history.push("/EmployeeSignIn");
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
                        <div className="sidebar-brand-text mx-3">Employee DashBoard</div>
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
                            <a className="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseDonor"
                                aria-expanded="true" aria-controls="collapseDonor">
                                <i className="fas fa-fw fa-table"></i>
                                <span>Tables</span>
                            </a>
                            <div id="collapseDonor" className="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                                <div className="bg-white py-2 collapse-inner rounded">
                                    <h6 className="collapse-header">Custom Components:</h6>

                                    <Link className="collapse-item" to="/DonorTableDashBorad">Donor table</Link>
                                    <Link className="collapse-item" to="/VendorTableDashBoard">Vendor table</Link>
                                    <Link className="collapse-item" to="/DonationsTableDashboard">Donations Till Now</Link>
                                </div>
                            </div>
                        </li>

                        <li className="nav-item">
                            <a className="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseDonor"
                                aria-expanded="true" aria-controls="collapseDonor">
                                <i className="fas fa-fw fa-table"></i>
                                <span>Bidding</span>
                            </a>
                            <div id="collapseDonor" className="collapse" aria-labelledby="headingTwo" data-parent="#accordionSidebar">
                                <div className="bg-white py-2 collapse-inner rounded">
                                    <h6 className="collapse-header">Bidding Components</h6>
                                    
                                    <Link className="collapse-item" to="/EmployeeBidsDashBoard">Bidding table</Link>
                                    <Link className="collapse-item" to="/EmployeeSelectedBidsDashBoard">Selected Bidding table</Link>
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
                                        <span className="mr-2 d-none d-lg-inline text-gray-600 small">Employee</span>
                                        <img className="img-profile rounded-circle"
                                            src="img/undraw_profile.svg" />
                                    </a>
                                    {/* <!-- Dropdown - User Information --> */}
                                    <div className="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                            aria-labelledby="userDropdown">
                                            <a className="dropdown-item" href="#">
                                                <i className="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                                <button onClick={upd} > Update</button>
                                            </a>
                                            <a className="dropdown-item" href="#">
                                                <i className="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                                <button onClick={del} > Delete</button>
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
                         {/* <!-- Begin Page Content --> */}
                        <div className="container-fluid">

                            {/* <!-- Page Heading --> */}
                            <div className="d-sm-flex align-items-center justify-content-between mb-4">
                                <h1 className="h3 mb-0 text-gray-800">Dashboard</h1>
                                <a href="#" className="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm"><i
                                    className="fas fa-download fa-sm text-white-50"></i> Generate Report</a>
                            </div>
                            {/* <!-- Footer --> */}
                            <footer className="sticky-footer bg-white">
                                <div className="container my-auto">
                                    <div className="copyright text-center my-auto">
                                        <span>Copyright &copy; Your Website 2023</span>
                                    </div>
                                </div>
                            </footer>
                            {/* <!-- End of Footer --> */}

                        </div>
                        {/* <!-- End of Content Wrapper --> */}

                    </div>
                    {/* <!-- End of Page Wrapper --> */}

                    {/* <!-- Scroll to Top Button--> */}
                    <a className="scroll-to-top rounded" href="#page-top">
                        <i className="fas fa-angle-up"></i>
                    </a>

                    {/* <!-- Logout Modal--> */}
                    <div className="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div className="modal-dialog" role="document">
                            <div className="modal-content">
                                <div className="modal-header">
                                    <h5 className="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                                    <button className="close" type="button" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">×</span>
                                    </button>
                                </div>
                                <div className="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                                <div className="modal-footer">
                                    <button className="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                                    <a className="btn btn-primary" href="login.html">Logout</a>
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
export default EmployeeDashBoard;