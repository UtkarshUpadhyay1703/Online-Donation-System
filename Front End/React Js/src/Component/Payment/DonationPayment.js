import React, { useState } from "react";
import { Link, useHistory } from "react-router-dom";
import {
  MDBBtn,
  MDBCard,
  MDBCardBody,
  MDBCol,
  MDBContainer,
  MDBInput,
  MDBRow,
} from "mdb-react-ui-kit";
import AnonymousService from "../Services/AnonymousService";

export default function DonationPayment() {

  
  let [payob,setpayob]=useState({});
    var history=useHistory();

    const Change=(event)=>{
        var {name,value}=event.target
        setpayob({...payob,[name]:value});
    }

    const SignInFun=(event)=>{
        AnonymousService.DonateMoney(payob).then((response)=>{
          console.log(response.data);
         history.push("/");
        });
    }



  return (
    <MDBContainer
      className="py-5"
      fluid
      style={{
        backgroundImage:
          "url(https://mdbcdn.b-cdn.net/img/Photos/Others/background3.webp)",
      }}
    >
      <MDBRow className=" d-flex justify-content-center">
        <MDBCol md="10" lg="8" xl="5">
          <MDBCard className="rounded-3">
            <MDBCardBody className="p-4">
              <div className="text-center mb-4">
                <h3>Donation</h3>
                <h5>Payment</h5>
              </div>
              <div className="d-flex flex-row align-items-center mb-4 pb-1">
                <img
                  className="img-fluid"
                  src="https://cdn.iconscout.com/icon/free/png-512/payment-rupay-card-pay-bank-transaction-51318.png?f=avif&w=256"
                />
              </div>
              {/* <div><img src="./Utkarsh_Paytm.jpg"/></div> */}
              <div className="lol"></div>
              <h6><label for="form"> Amount for Donation </label></h6>
              <input
                id="form"
                type="number"
                size="lg"
                name="amountReceived" value={payob.amountReceived} onChange={Change} placeholder="Enter amount for donation"
              /><br/><br/>
              
                <h6><label for="form1"> Card Number </label></h6>
                  <input
                    label="Card Number"
                    id="form1"
                    type="text"
                    size="lg"
                    name="cardNumber" value={payob.cardNumber} onChange={Change} placeholder="Enter card number"
                  /><br/><br/>
                
              <button type="button" class="btn btn-success" size="lg" block id="btn" name="btn1" onClick={SignInFun}>
                Pay
              </button><br/>
              OR<br/>
              <Link to="/QRDonation">
              <button type="button" class="btn btn-success" size="lg" block id="btn" name="btn1">
                Pay using QR Code
              </button></Link>
            </MDBCardBody>
          </MDBCard>
        </MDBCol>
      </MDBRow>
    </MDBContainer>
  );
}