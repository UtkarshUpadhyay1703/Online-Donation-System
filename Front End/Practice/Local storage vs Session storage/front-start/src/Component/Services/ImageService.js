import axios from "axios";

class ImageService{
    constructor(){
        this.url="http://localhost:8080/file";
    }
    AddDonorImage(donId){
        return axios.post(this.url+"/upload/donor"+`/${donId}`);
    }
    AddEmployeeImage(empId,imgId){
        return axios.post(this.url+"/upload/employee"+`/${empId}`+`/${imgId}`);
    }
    GetEmployeeImage(empId){
        return axios.get(this.url+"/download/employee"+`/${empId}`);
    }
    GetDonorImage(donId){
        return axios.get(this.url+"/download/donor"+`/${donId}`);
    }
}
export default new ImageService;