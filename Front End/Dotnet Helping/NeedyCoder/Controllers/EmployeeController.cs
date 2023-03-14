using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Cors;
namespace NeedyCoder.Controllers;

using BOL;
using DAL;
[ApiController]
[Route("[controller]")]
public class EmployeeController : ControllerBase
{
     private readonly ILogger<EmployeeController> _logger;

    public EmployeeController(ILogger<EmployeeController> logger)
    {
        _logger = logger;
    }

    [HttpGet(Name = "GetEmployee")]
        public IEnumerable<Employee> Get()
    {
        List<Employee> AllEmployee=new List<Employee>();
        DBManager dbm=new DBManager();
        AllEmployee=dbm.GetAllEmployees();
        return AllEmployee;
    }

    [HttpGet]
    [Route ("{employeeid:}")]
    public Employee GetByEmployeeId([FromRoute] int employeeid){
        Employee employee=new Employee();
        DBManager dbm=new DBManager();
        employee=dbm.GetByEmployeeId(employeeid);
        return employee;
    }

    [HttpPost]
    public void InsertEmployee(Employee employee){
        DBManager dbm=new DBManager();
        dbm.InsertEmployee(employee);
    }
    [HttpDelete]
    [Route ("{employeeid:}")]
    public void DeleteEmployee(int employeeid){
        DBManager dbm=new DBManager();
        dbm.DeleteEmployee(employeeid);
    }
    [HttpPut]
    [Route ("{employeeid:}")]
    public void UpdateEmployee(int employeeid,Employee employee){
        DBManager dbm=new DBManager();
        dbm.UpdateEmployee(employeeid,employee);
        }
}