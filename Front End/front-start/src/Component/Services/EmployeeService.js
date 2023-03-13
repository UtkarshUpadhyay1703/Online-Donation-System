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
    UpdateEmployee(id,employee){
        return axios.put(this.url+`/update/${id}`,employee);
    }
    GetBalance(){
        console.log("fetched data");
        return axios.get(this.url+"/balance");
    }
    GetAllTopFiveBookBids(){
        return axios.get(this.url+"/books");
    }
    GetAllTopFiveClothBids(){
        return axios.get(this.url+"/Cloths");
    }
    GetAllTopFiveToyBids(){
        return axios.get(this.url+"/toys");
    }
    GetAllTopFiveCycleBids(){
        return axios.get(this.url+"/cycles");
    }
    GetSelected(){
        return axios.get(this.url+"/getSelected");
    }
    SetSelectedBook(id){
        return axios.put(this.url+"/setSelectedBook/"+id);
    }
    SetSelectedCloth(id){
        return axios.put(this.url+"/setSelectedCloth/"+id);
    }
    SetSelectedToy(id){
        return axios.put(this.url+"/setSelectedToy/"+id);
    }
    SetSelectedCycle(id){
        return axios.put(this.url+"/setSelectedCycle/"+id);
    }
    SetReceivedBooks(id){
        return axios.put(this.url+"/setReceived/Books/"+id);
    }
    SetReceivedCloths(id){
        return axios.put(this.url+"/setReceived/Cloths/"+id);
    }
    SetReceivedToys(id){
        return axios.put(this.url+"/setReceived/Toys/"+id);
    }
    SetReceivedCycles(id){
        return axios.put(this.url+"/setReceived/Cycles/"+id);
    }
    GetAllItemDonations(){
        return axios.get(this.url+"/ItemDonation");
      }
}
export default new EmployeeService();