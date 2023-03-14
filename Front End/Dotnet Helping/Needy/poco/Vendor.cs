using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Collections.Generic;
namespace BOL;
//[Index(nameof(VendorMobileNo),nameof(VendorAadharNo),nameof(VendorCompanyBankAccountNo),nameof(VendorCompanyBankIFSC),nameof(VendorEmailId), IsUnique = true)]
public class Vendor : BaseEntity
{

   // public int Id { get; set; }

    [Column("vendor_company_name")]
    [Required]
    [StringLength(20)]
    public string VendorCompanyName { get; set; }

    [Column("vendor_company_address")]
    [Required]
    [StringLength(100)]
    public string VendorCompanyAddress { get; set; }

    [Column("vendor_mobile_no")]
    [Required]
    //[Index(nameof(Vendor.VendorMobileNo),IsUnique = true)]
    [StringLength(10)]
    public string VendorMobileNo { get; set; }

    [Column("vendor_aadhar_no")]
    [Required]
    //[Index(nameof(Vendor.VendorAadharNo),IsUnique = true)]
    [StringLength(18)]
    public string VendorAadharNo { get; set; }

    [Column("vendor_company_bank_account_no")]
    [Required]
   //[Index(nameof(Vendor.VendorCompanyBankAccountNo),IsUnique = true)]
    [StringLength(18)]
    public string VendorCompanyBankAccountNo { get; set; }

    [Column("vendor_company_bankifsc")]
    [Required]
    //[Index(nameof(Vendor.VendorCompanyBankIFSC),IsUnique = true)]
    [StringLength(11)]
    public string VendorCompanyBankIFSC { get; set; }

    [Column("vendor_email_id")]
    [Required]
    //[Index(nameof(Vendor.VendorEmailId),IsUnique = true)]
    [StringLength(30)]
    public string VendorEmailId { get; set; }

    [Column("vendor_password")]
    [Required]
    [StringLength(20)]
    //      
    public string VendorPassword { get; set; }

    [Column("vendor_status")]
    public bool VendorStatus { get; set; } = true;

   //public virtual ICollection<BankTransaction> Transactions { get; set; } = new HashSet<BankTransaction>();

   //public virtual ICollection<Bidding> Biddings { get; set; } = new HashSet<Bidding>();
}
