using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace BOL;
//namespace MyApp.Models
    public class Donor : BaseEntity
    {    
        //public int Id { get; set; }
        [Column("donor_name")]
        [Required]
        [StringLength(20)]
        public string DonorName { get; set; }

         [Column("donor_address")]
        [Required]
        [StringLength(100)]
        public string DonorAddress { get; set; }
        
        [Column("donor_mobile_no")]
        [Required]
        [StringLength(10)]
        public string DonorMobileNo { get; set; }
         
         [Column("donor_email_id")]
        [Required]
        [StringLength(30)]
        //[Index(nameof(Donor.DonorEmailId),IsUnique = true)]
        public string DonorEmailId { get; set; }
        
        [Column("donor_password")]
        [Required]
        [StringLength(20)]
        public string DonorPassword { get; set; }

        [Column("donor_status")]
        public bool DonorStatus { get; set; }

       // public virtual ICollection<BankTransaction> Transactions { get; set; } = new List<BankTransaction>();

        //public virtual ICollection<ItemDonation> Items { get; set; } = new List<ItemDonation>();
    }

