import axios from "axios";

class Service{
    constructor(){
        this.url="http://localhost:8080/";
    }
    GetAllDonors(){
        return axios.get(this.url+"donors/Donortrue");
    }
    // AddDonor(donor){
    //     return axios.post(this.url,donor);
    // }
}
export default new Service();