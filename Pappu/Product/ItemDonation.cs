using System.ComponentModel.DataAnnotations.Schema;
namespace BOL;
[Table("item_donation")]
public class ItemDonation : BaseEntity
{
[Column("item_type", TypeName = "nvarchar(20)")]
public string ItemType { get; set; }

[Column("item_pic_via_donator", TypeName = "nvarchar(100)")]
public string ItemPicViaDonator { get; set; }

[Column("item_pic_via_employee", TypeName = "nvarchar(100)")]
public string ItemPicViaEmployee { get; set; }

[Column("item_status_donation")]
public bool ItemStatusDonation { get; set; }

[ForeignKey("itemDonor")]
public int DonorId { get; set; }
public virtual Donor ItemDonor { get; set; }

[ForeignKey("itemEmployee")]
public int EmployeeId { get; set; }
public virtual Employee ItemEmployee { get; set; }
}