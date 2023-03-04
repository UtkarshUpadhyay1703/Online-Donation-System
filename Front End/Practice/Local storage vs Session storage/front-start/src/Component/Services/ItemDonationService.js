import axios from "axios";

class ItemDonationService{
    constructor(){
        this.url="http://localhost:8080/itemdonations";
    }
     GetAllItemDonations(){
         return axios.get(this.url+"/ItemDonationtrue");
       }
    // AddDonor(donor){
    //     return axios.post(this.url,donor);
    // }
    // SignInDonor(donor){
    //     return axios.post(this.url+"/signIn",donor);
    // }
    // DeleteDonor(id){
    //     return axios.put(this.url+"/",id);
    // }
    // UpdateDonor(donor){
    //     return axios.put(this.url,donor);
    // }
}
export default new ItemDonationService();