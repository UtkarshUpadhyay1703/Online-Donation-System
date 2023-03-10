import axios from "axios";

class EmployeeService{
    constructor(){
        this.url="http://localhost:8080/employees";
    }
    GetAllEmployees(){
        return axios.get(this.url+"/Employeetrue");
    }
    AddEmployees(employee){
        return axios.post(this.url,employee);
    }
    SignInEmployee(employee){
        return axios.post(this.url+"/signIn",employee);
    }
    DeleteEmployee(id){
        return axios.put(this.url+"/",id);
    }
    UpdateEmployee(employee){
        return axios.put(this.url,employee);
    }
    GetBalance(){
        console.log("fetched data");
        return axios.get(this.url+"/balance");
    }
    GetAllTopFiveBookBids(){
        return axios.get(this.url+"/employees/books");
    }
}
export default new EmployeeService();