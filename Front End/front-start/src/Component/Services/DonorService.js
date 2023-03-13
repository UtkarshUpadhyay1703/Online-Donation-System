import axios from "axios";

class DonorService{
    constructor(){
        this.url="http://localhost:8080/donors";
    }
    GetAllDonors(){
        return axios.get(this.url+"/Donortrue");
    }
    AddDonor(donor){
        return axios.post(this.url,donor);
    }
    SignInDonor(donor){
        alert(donor.donorEmailId);
        return axios.post(this.url+"/signIn",donor);
    }
    DeleteDonor(id){
        return axios.put(this.url+"/false"+`/${id}`);
    }
    UpdateDonor(donor,id){
        return axios.put(this.url+`/${id}`,donor);
    }
    DonateMoney(payob,id){
        return axios.post(this.url+"/Transaction/deposit/"+id,payob);
    }
    
}
export default new DonorService();