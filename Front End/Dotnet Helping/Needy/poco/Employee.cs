using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace BOL;
    public class Employee : BaseEntity
    {
       
        //public int Id { get; set; }

        [Column("employee_name")]
        [Required]
        [StringLength(20)]
        public string EmployeeName { get; set; }

        [Column("employee_address")]
        [Required]
        [StringLength(100)]
        public string EmployeeAddress { get; set; }

        [Column("employee_mobile_no")]
        [Required]
        [StringLength(10)]
       // [Index(IsUnique = true)]
        public string EmployeeMobileNo { get; set; }

        [Column("employee_aadhar_no")]
        [Required]
        [StringLength(12)]
        //[Index(IsUnique = true)]
        public string EmployeeAadharNo { get; set; }

        [Column("employee_bank_account_no")]
        [Required]
        [StringLength(18)]
        //[Index(IsUnique = true)]
        public string EmployeeBankAccountNo { get; set; }

        [Column("employee_company_bankifsc")]
        [Required]
        [StringLength(11)]
        //[Index(IsUnique = true)]
        public string EmployeeCompanyBankIFSC { get; set; }

        [Column("employee_email_id")]
        [Required]
        [StringLength(30)]
        //[Index(IsUnique = true)]
        public string EmployeeEmailId { get; set; }

        [Column("employee_password")]
        [Required]
        [StringLength(20)]
        //[JsonIgnore]
        public string EmployeePassword { get; set; }

        [Column("employee_qualification")]
        [Required]
        [StringLength(10)]
        public string EmployeeQualification { get; set; }

        [Column("employee_status")]
        [Required]
        public bool EmployeeStatus { get; set; } = true;

       // public virtual ICollection<BankTransaction> Transactions { get; set; } = new List<BankTransaction>();

        //public virtual ICollection<ItemDonation> Items { get; set; } = new List<ItemDonation>();
    }

