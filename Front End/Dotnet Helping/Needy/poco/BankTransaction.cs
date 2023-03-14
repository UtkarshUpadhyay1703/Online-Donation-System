using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace BOL; //namespace MyApp.Models
    [Table("bank_transaction")]
    public class BankTransaction : BaseEntity
    {
        [Key]
        public int Id { get; set; }

        [ForeignKey("Donor")]
        [Column("donor_id")]
        public int DonorId { get; set; }

        public Donor Donor { get; set; }

        [ForeignKey("Employee")]
        [Column("employee_id")]
        public int EmployeeId { get; set; }

        public Employee Employee { get; set; }

        [ForeignKey("Vendor")]
        [Column("vendor_id")]
        public int VendorId { get; set; }

        public Vendor Vendor { get; set; }

        [Column("created_on")]
        public DateTime CreatedOn { get; set; }

        [Column("amount_received")]
        public double AmountReceived { get; set; }

        [Column("amount_send")]
        public double AmountSend { get; set; }

        [Column("balance")]
        public double Balance { get; set; }

//         public BankTransaction()
//         {
//             CreatedOn = DateTime.Now;
//         }

//         public BankTransaction(Donor donor, double amountReceived)
//         {
//             Donor = donor;
//             AmountReceived = amountReceived;
//             CreatedOn = DateTime.Now;
//         }

//         public BankTransaction(double balance)
//         {
//             Balance = balance;
//             CreatedOn = DateTime.Now;
//         }

//         public void Deposit(double amount)
//         {
//             Balance += amount;
//         }

//         public void Withdraw(double amount)
//         {
//             Console.WriteLine("inside withdraw balance = " + Balance + "Amount = " + amount);
//             if (Balance > amount)
//             {
//                 Balance -= amount;
//             }
//             else
//             {
//                 throw new ResourceNotFoundException("Insufficient balance");
//             }
//         }

//         public override string ToString()
//         {
//             return $"BankTransaction [createdOn={CreatedOn}, amountReceived={AmountReceived}, amountSend={AmountSend}, balance={Balance}]";
//         }
        }               

