using BOL;
using DAL;
using System.Collections.Generic;
using System;
Console.WriteLine("Welcome Dotnet Helping");
IDBManager dbm=new DBManager();
bool status=true;

while(status){
    Console.WriteLine("Choose Option :");
    Console.WriteLine("1. Display donor records");
    Console.WriteLine("2. Display donor By Id");
    Console.WriteLine("3. Display vendor records");
    Console.WriteLine("4. Display vendor By Id");
    Console.WriteLine("5. Display employee records");
    Console.WriteLine("6. Display employee By Id");
    Console.WriteLine("5. Exit");
    switch(int.Parse(Console.ReadLine())){
        case 1:
        {
            List<Donor> list=dbm.GetAllDonors();
            foreach(var don in list){
                Console.WriteLine("Id : "+don.Id+"Name : "+don.DonorName+"Address : "+don.DonorAddress+"Mobile no. : "+don.DonorMobileNo+"EmailId : "+don.DonorEmailId+"Password : "+don.DonorPassword+"Status : "+don.DonorStatus);
            }
        }
        break;
        case 2:
        Console.WriteLine("Enter Id ");
        int donorid=int.Parse(Console.ReadLine());
        Donor donor=dbm.GetByDonorId(donorid);
        Console.WriteLine(donor);
        break;
         case 3:
        {
            List<Vendor> list=dbm.GetAllVendors();
            foreach(var ven in list){
                Console.WriteLine("Id : "+ven.Id+"Name : "+ven.VendorCompanyName+"Address : "+ven.VendorCompanyAddress+"Mobile no. : "+ven.VendorMobileNo+"AadharNo : "+ven.VendorAadharNo+"BankAccountNo : "+ven.VendorCompanyBankAccountNo+"CompanyBankIFSC : "+ven.VendorCompanyBankIFSC+"EmailId : "+ven.VendorEmailId+"Password : "+ven.VendorPassword+"Status : "+ven.VendorStatus);
            }
        }
        break;
        case 4:
        Console.WriteLine("Enter Id ");
        int vendorid=int.Parse(Console.ReadLine());
        Vendor vendor=dbm.GetByVendorId(vendorid);
        Console.WriteLine(vendor);
        break;
        case 5:
        {
            List<Employee> list=dbm.GetAllEmployees();
            foreach(var emp in list){
                Console.WriteLine("Id : "+emp.Id+"Name : "+emp.EmployeeName+"Address : "+emp.EmployeeAddress+"Mobile no. : "+emp.EmployeeMobileNo+"AadharNo : "+emp.EmployeeAadharNo+"BankAccountNo : "+emp.EmployeeBankAccountNo+"CompanyBankIFSC : "+emp.EmployeeCompanyBankIFSC+"EmailId : "+emp.EmployeeEmailId+"Password : "+emp.EmployeePassword+"Qualification : "+emp.EmployeeQualification+"Status : "+emp.EmployeeStatus);
            }
        }
        break;
        case 6:
        Console.WriteLine("Enter Id ");
        int employeeid=int.Parse(Console.ReadLine());
        Employee employee=dbm.GetByEmployeeId(employeeid);
        Console.WriteLine(employee);
        break;
        case 7:
        status=false;
        break;
    }
}