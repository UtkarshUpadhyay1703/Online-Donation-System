using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace BOL;//namespace MyApp.Models
    public class Donor : BaseEntity
    {
        public int Id { get; set; }

        [Required]
        [StringLength(20)]
        public string DonorName { get; set; }

        [Required]
        [StringLength(100)]
        public string DonorAddress { get; set; }

        [Required]
        [StringLength(10)]
        public string DonorMobileNo { get; set; }

        [Required]
        [StringLength(30)]
        [Index(IsUnique = true)]
        public string DonorEmailId { get; set; }

        [Required]
        [StringLength(20)]
        public string DonorPassword { get; set; }

        public bool DonorStatus { get; set; }

        public virtual ICollection<BankTransaction> Transactions { get; set; } = new List<BankTransaction>();

        public virtual ICollection<ItemDonation> Items { get; set; } = new List<ItemDonation>();
    }

