using BOL;
namespace DAL;
public interface IDBManager{
    List<Donor> GetAllDonors();

     Donor GetByDonorId(int donorid);

     List<Vendor> GetAllVendors();

     Vendor GetByVendorId(int vendorid);

     List<Employee> GetAllEmployees();

     Employee GetByEmployeeId(int employeeid);

//ActionResult<Donor> AddDonor(DonorAddDto donorDto);
    void InsertDonor(Donor donor);
    void DeleteDonor(int donorid);
    void UpdateDonor(int donorid,Donor donor);

    void InsertVendor(Vendor vendor);
    void DeleteVendor(int vendorid);
    void UpdateVendor(int vendorid,Vendor vendor);

    void InsertEmployee(Employee employee);
    void DeleteEmployee(int employeeid);
    void UpdateEmployee(int employeeid,Employee employee);
    

}