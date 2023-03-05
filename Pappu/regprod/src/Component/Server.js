import axios from "axios";
class Server{
    constructor(){
        this.url="http://localhost:5010/Product";
    }
    getAllProduct(){
        return axios.get(this.url);
    }
}
export default new Server();