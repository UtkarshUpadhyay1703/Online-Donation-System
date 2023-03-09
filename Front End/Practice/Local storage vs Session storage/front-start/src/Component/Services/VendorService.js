import axios from "axios";

class VendorService{
    constructor(){
        this.url="http://localhost:8080/vendors";
    }
    GetAllVendors(){
        return axios.get(this.url+"/Vendortrue");
    }
    AddVendor(vendor){
        return axios.post(this.url,vendor);
    }
    SignInVendor(vendor){
        return axios.post(this.url+"/signIn",vendor);
    }
    DeleteVendor(id){
        return axios.put(this.url+"/",id);
    }
    UpdateVendor(vendor){
        return axios.put(this.url,vendor);
    }
    DoBidding(formob,id){
        return axios.post(this.url+"/Bidding/Vendor"+id,formob);
    }
}
export default new VendorService();