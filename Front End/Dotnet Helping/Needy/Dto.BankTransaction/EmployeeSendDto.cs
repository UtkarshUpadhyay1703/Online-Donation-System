using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

//namespace MyApp.Models
namespace BOL;
    public class EmployeeSendDto
    {
        public double AmountSend { get; set; }

        [ForeignKey("Employee")]
        public int EmployeeId { get; set; }

        public virtual Employee Employee { get; set; }

        public EmployeeSendDto()
        {
        }

        public EmployeeSendDto(double amountSend, Employee employee)
        {
            AmountSend = amountSend;
            Employee = employee;
        }

        public override string ToString()
        {
            return "SendDto [amountSend=" + AmountSend + "]";
        }
    }

