using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Collections.Generic;
namespace BOL;
[Table("item_donation")]
public class ItemDonation : BaseEntity
{
[Column("item_type")]
[StringLength(100)]
public string ItemType { get; set; }

[Column("item_pic_via_donator")]
[StringLength(100)]
public string ItemPicViaDonator { get; set; }

[Column("item_pic_via_employee")]
[StringLength(100)]
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