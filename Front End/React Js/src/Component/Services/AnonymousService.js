import axios from "axios";

class AnonymousService{
    constructor(){
        this.url="http://localhost:8080/anonymous/";
    }
    DonateMoney(payob){
        return axios.post(this.url+"deposit",payob);
    }
}
export default new AnonymousService();