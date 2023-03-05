using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Collections.Generic;
namespace BOL;
public class Vendor : BaseEntity
{
    [Key]
    public int Id { get; set; }

    [Column(TypeName = "nvarchar(20)")]
    [Required]
    public string VendorCompanyName { get; set; }

    [Column(TypeName = "nvarchar(100)")]
    [Required]
    public string VendorCompanyAddress { get; set; }

    [Column(TypeName = "nvarchar(10)")]
    [Required]
    [Index(IsUnique = true)]
    public string VendorMobileNo { get; set; }

    [Column(TypeName = "nvarchar(18)")]
    [Required]
    [Index(IsUnique = true)]
    public string VendorAadharNo { get; set; }

    [Column(TypeName = "nvarchar(18)")]
    [Required]
    [Index(IsUnique = true)]
    public string VendorCompanyBankAccountNo { get; set; }

    [Column(TypeName = "nvarchar(11)")]
    [Required]
    [Index(IsUnique = true)]
    public string VendorCompanyBankIFSC { get; set; }

    [Column(TypeName = "nvarchar(30)")]
    [Required]
    [Index(IsUnique = true)]
    public string VendorEmailId { get; set; }

    [Column(TypeName = "nvarchar(20)")]
    [Required]
    [JsonProperty(access = JsonPropertyAccess.WriteOnly)]
    public string VendorPassword { get; set; }

    [Column(TypeName = "bit")]
    public bool VendorStatus { get; set; } = true;

    public virtual ICollection<BankTransaction> Transactions { get; set; } = new HashSet<BankTransaction>();

    public virtual ICollection<Bidding> Biddings { get; set; } = new HashSet<Bidding>();
}
