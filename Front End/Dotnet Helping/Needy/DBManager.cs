using BOL;
namespace DAL;
public class DBManager:IDBManager{
    public List<Donor> GetAllDonors(){
        using(var context=new NeedyContext()){
            var donors=from don in context.Donors select don;
            return donors.ToList<Donor>();
        }
    }

    public Donor GetByDonorId(int donorid){
        using(var context=new NeedyContext()){
            var donor=context.Donors.Find(donorid);
            return donor;
        }
    }

    public List<Vendor> GetAllVendors(){
        using(var context=new NeedyContext()){
            var vendors=from ven in context.Vendors select ven;
            return vendors.ToList<Vendor>();
        }
    }

    public Vendor GetByVendorId(int vendorid){
        using(var context=new NeedyContext()){
            var vendor=context.Vendors.Find(vendorid);
            return vendor;
        }
    }

    public List<Employee> GetAllEmployees(){
        using(var context=new NeedyContext()){
            var employees=from emp in context.Employees select emp;
            return employees.ToList<Employee>();
        }
    }

    public Employee GetByEmployeeId(int employeeid){
        using(var context=new NeedyContext()){
            var employee=context.Employees.Find(employeeid);
            return employee;
        }
    }

    public void InsertDonor(Donor donor){
        using(var context=new NeedyContext()){
            context.Donors.Add(donor);
            context.SaveChanges();
        }
    }

    // public ActionResult<Donor> AddDonor(DonorAddDto donorDto)
    // {
      
    //     var donor = new Donor
    //     {
    //         DonorName = donorDto.DonorName,
    //         DonorEmailId = donorDto.DonorEmailId,
    //         DonorAddress = donorDto.DonorAddress,
    //         DonorMobileNo = donorDto.DonorMobileNo,
    //         DonorStatus = true
    //     };

    //      using(var context=new NeedyContext()){
    //         context.Donors.Add(donor);
    //         context.SaveChanges();
    //     }

    //     return Ok(donor);
    // }
    public void DeleteDonor(int donorid){
        using(var context=new NeedyContext()){
            context.Donors.Remove(context.Donors.Find(donorid));
            context.SaveChanges();
        }
    }
    public void UpdateDonor(int donorid,Donor donor){
        using(var context=new NeedyContext()){
            var don=context.Donors.Find(donorid);
            don.Id=donor.Id;
            don.DonorName=donor.DonorName;
            don.DonorAddress=donor.DonorAddress;
            don.DonorMobileNo=donor.DonorMobileNo;
            don.DonorEmailId=donor.DonorEmailId;
            don.DonorPassword=donor.DonorPassword;
            don.DonorStatus=donor.DonorStatus;
            context.SaveChanges();
        }
    }

    public  void InsertVendor(Vendor vendor){
        using(var context=new NeedyContext()){
            context.Vendors.Add(vendor);
            context.SaveChanges();
        }
    }

       public  void DeleteVendor(int vendorid){
        using(var context=new NeedyContext()){
            context.Vendors.Remove(context.Vendors.Find(vendorid));
            context.SaveChanges();
        }
    }
    public void UpdateVendor(int vendorid,Vendor vendor){
        using(var context=new NeedyContext()){
           var ven=context.Vendors.Find(vendorid);
            ven.Id=vendor.Id;
            ven.VendorCompanyName=vendor.VendorCompanyName;
            ven.VendorCompanyAddress=vendor.VendorCompanyAddress;
            ven.VendorMobileNo=vendor.VendorMobileNo;
            ven.VendorAadharNo=vendor.VendorAadharNo;
            ven.VendorCompanyBankAccountNo=vendor.VendorCompanyBankAccountNo;
            ven.VendorCompanyBankIFSC=vendor.VendorCompanyBankIFSC;
            ven.VendorEmailId=vendor.VendorEmailId;
            ven.VendorPassword=vendor.VendorPassword;
            ven.VendorStatus=vendor.VendorStatus;
            context.SaveChanges();
        }
    }

    public void InsertEmployee(Employee employee){
        using(var context=new NeedyContext()){
            context.Employees.Add(employee);
            context.SaveChanges();
        }
    }

       public void DeleteEmployee(int employeeid){
        using(var context=new NeedyContext()){
            context.Employees.Remove(context.Employees.Find(employeeid));
            context.SaveChanges();
        }
    }
    public void UpdateEmployee(int employeeid,Employee employee){
        using(var context=new NeedyContext()){
           var emp=context.Employees.Find(employeeid);
            emp.Id=employee.Id;
            emp.EmployeeName=employee.EmployeeName;
            emp.EmployeeAddress=employee.EmployeeAddress;
            emp.EmployeeMobileNo=employee.EmployeeMobileNo;
            emp.EmployeeAadharNo=employee.EmployeeAadharNo;
            emp.EmployeeBankAccountNo=employee.EmployeeBankAccountNo;
            emp.EmployeeCompanyBankIFSC=employee.EmployeeCompanyBankIFSC;
            emp.EmployeeEmailId=employee.EmployeeEmailId;
            emp.EmployeePassword=employee.EmployeePassword;
            emp.EmployeeQualification=employee.EmployeeQualification;
            emp.EmployeeStatus=employee.EmployeeStatus;
            context.SaveChanges();
        }
    }
}