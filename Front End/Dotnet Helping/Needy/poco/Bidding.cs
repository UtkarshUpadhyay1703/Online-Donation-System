using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace BOL;
 //namespace MyApp.Models


 public enum BiddingStatus
{
    APPLIED,
    SELECTED,
    RECEIVED
}
    [Table("bidding")]
    public class Bidding : BaseEntity
    {
        [Column("low_price_toy")]
        public double LowPriceToy { get; set; }

        [Column("low_price_cloth")]
        public double LowPriceCloth { get; set; }

        [Column("low_price_notebook")]
        public double LowPriceNotebook { get; set; }

        [Column("low_price_cycle")]
        public double LowPriceCycle { get; set; }

        [Column("date_of_bid")]
        [DatabaseGenerated(DatabaseGeneratedOption.Computed)]
        public DateTime DateOfBid { get; set; }

        [StringLength(8)]
        [Column("bidding_status_approve")]
        [EnumDataType(typeof(BiddingStatus))]
        public BiddingStatus BiddingStatusApprove { get; set; } = BiddingStatus.APPLIED;

        public int Quantity { get; set; }

        public int VendorId { get; set; }
        public Vendor VendorBidding { get; set; }
    }

