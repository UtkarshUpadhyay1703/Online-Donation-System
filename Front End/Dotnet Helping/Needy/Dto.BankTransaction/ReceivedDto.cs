using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace BOL; // namespace MyApp.Models

    public class ReceivedDto
    {
        public double AmountReceived { get; set; }

        [ForeignKey("Donor")]
        public int DonorId { get; set; }

        public virtual Donor Donor { get; set; }

        public ReceivedDto()
        {
        }

        public ReceivedDto(double amountReceived, Donor don)
        {
            AmountReceived = amountReceived;
            Donor = don;
        }

        public override string ToString()
        {
            return "ReceivedDto [amountReceived=" + AmountReceived + "]";
        }
    }

