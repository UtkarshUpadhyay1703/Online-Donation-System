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
        return axios.get(this.url+"/balance");
    }
}
export default new EmployeeService();