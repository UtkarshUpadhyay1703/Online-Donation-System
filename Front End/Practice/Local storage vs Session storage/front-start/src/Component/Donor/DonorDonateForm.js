import { useEffect, useState } from "react";
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
    var history = useHistory();
    useEffect(() => {
        // if (localStorage.getItem("don") != null) {
            setdonorob(JSON.parse(localStorage.getItem('don')));
            // alert(donorob.toSource());
            alert(donorob.id);
        // }
        // alert(donorob.data);
        // let list=localStorage.getItem("don").data;
        // console.log(list);
        // alert(JSON.parse(list));
        // alert(list.data.id.value);
        // if(list){
            
        // }else{
        //     return [];
        // }
    }, [])

    // const Change = (event) => {
    //     var { name, value } = event.target
    //     setdonorob({ ...donorob, [name]: value });
    // }
    // const SignInFun = (event) => {
    //     DonorService.SignInDonor(donorob).then((response) => {
    //         // localStorage.don=response;
    //         // history.push("/rfvhe")
    //         localStorage.setItem("don", JSON.stringify(response));
    //         // setdonorob1(JSON.stringify(response));
    //         // alert(donorob1);
    //     });
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
        formData.append('type',document.getElementById("type").value);
        fetch('http://localhost:8080/file/upload/{'+donorob.id+'}/donor', {
            method: 'post',
            body: formData
        }).then(res => {
            if (res.ok) {
                console.log(res.data);
                alert("File uploaded successfully.")
            }
        });
    })

    return (
        <div>
            <head>
                <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css" />
                <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
                <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
                <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />
                <script src="//ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
                <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
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
                                                <input type="file" class="form-control" name="file" onChange={onFileChangeHandler} />
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <button type="button" class="btn btn-black" id="btn" name="btn1" onClick={Send}>Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
            </body>
        </div>
    )
}
export default DonorDonateForm;