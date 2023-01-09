namespace HNO;

public class Employee
{
    public int EmployeeId { get; set; }
    public string EmployeeName { get; set; }
    public string EmployeeAddress { get; set; }
    public int EmployeeMobNo { get; set; }
    public int EmployeeAadharNo { get; set; }
    public int EmployeeBankAccountNo { get; set; }
    public string EmployeeEmailId { get; set; }
    public string EmployeePassword { get; set; }
    public string EmployeeQualification { get; set; }
    public string EmployeeStatus { get; set; }

    public override string ToString()
    {
        return base.ToString()
            + "  "
            + EmployeeId
            + "  "
            + EmployeeName
            + "  "
            + EmployeeAddress
            + "  "
            + EmployeeMobNo
            + "  "
            + EmployeeAadharNo
            + "  "
            + EmployeeBankAccountNo
            + "  "
            + EmployeeEmailId
            + "  "
            + EmployeePassword
            + "  "
            + EmployeeQualification
            + "  "
            + EmployeeStatus;
    }
}
