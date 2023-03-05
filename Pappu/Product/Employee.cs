using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace BOL;
    [Table("signup_employee")]
    public class Employee : BaseEntity
    {
        [Key]
        public int Id { get; set; }

        [Column(TypeName = "varchar(20)")]
        [Required]
        public string EmployeeName { get; set; }

        [Column(TypeName = "varchar(100)")]
        [Required]
        public string EmployeeAddress { get; set; }

        [Column(TypeName = "varchar(10)")]
        [Required]
        [Index(IsUnique = true)]
        public string EmployeeMobileNo { get; set; }

        [Column(TypeName = "varchar(12)")]
        [Required]
        [Index(IsUnique = true)]
        public string EmployeeAadharNo { get; set; }

        [Column(TypeName = "varchar(18)")]
        [Required]
        [Index(IsUnique = true)]
        public string EmployeeBankAccountNo { get; set; }

        [Column(TypeName = "varchar(11)")]
        [Required]
        [Index(IsUnique = true)]
        public string VendorCompanyBankIFSC { get; set; }

        [Column(TypeName = "varchar(30)")]
        [Required]
        [Index(IsUnique = true)]
        public string EmployeeEmailId { get; set; }

        [Column(TypeName = "varchar(20)")]
        [Required]
        [JsonIgnore]
        public string EmployeePassword { get; set; }

        [Column(TypeName = "varchar(10)")]
        [Required]
        public string EmployeeQualification { get; set; }

        [Column(TypeName = "bit")]
        [Required]
        public bool EmployeeStatus { get; set; } = true;

        public virtual ICollection<BankTransaction> Transactions { get; set; } = new List<BankTransaction>();

        public virtual ICollection<ItemDonation> Items { get; set; } = new List<ItemDonation>();
    }

