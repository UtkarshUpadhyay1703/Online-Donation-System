using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace BOL; //namespace MyApp.Models
    [Table("bidding")]
    public class Bidding : BaseEntity
    {
        public double LowPriceToy { get; set; }
        public double LowPriceCloth { get; set; }
        public double LowPriceNotebook { get; set; }
        public double LowPriceCycle { get; set; }

        [Column(TypeName = "date")]
        [DatabaseGenerated(DatabaseGeneratedOption.Computed)]
        public DateTime DateOfBid { get; set; }

        [StringLength(8)]
        [Column(TypeName = "varchar(8)")]
        [EnumDataType(typeof(BiddingStatus))]
        public BiddingStatus BiddingStatusApprove { get; set; } = BiddingStatus.APPLIED;

        public int Quantity { get; set; }

        public int VendorId { get; set; }
        public Vendor VendorBidding { get; set; }
    }

