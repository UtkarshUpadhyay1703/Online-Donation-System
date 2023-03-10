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
        return axios.post(this.url+"/signIn",donor);
    }
    DeleteDonor(id){
        return axios.put(this.url+"/",id);
    }
    UpdateDonor(donor){
        return axios.put(this.url,donor);
    }
    DonateMoney(payob,id){
        return axios.post(this.url+"/Transaction/deposit/"+id,payob);
    }
    
}
export default new DonorService();