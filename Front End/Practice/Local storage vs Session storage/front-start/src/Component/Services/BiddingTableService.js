import axios from "axios";

class BiddingTableService{
    constructor(){
        this.url="http://localhost:8080/biddingtable";
    }
     GetAllItemDonations(){
         return axios.get(this.url+"/BiddingTabletrue");
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
export default new BiddingTableService();