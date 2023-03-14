namespace BOL;
using Microsoft.EntityFrameworkCore;
public interface IDonorService
{
    List<Donor> GetAllDonors();
    Donor AddDonor(Donor donor);
    // string DeleteDonor(long donorId);
    // Donor GetOneDonor(long donId);
    // Donor UpdateDonor(Donor don);
    // Donor ValidateDon(DonorLoginDto don);
    // List<Donor> GetAllTrueDonors();
    // string DeleteFalseDonor(long donorId);
    // BankTransaction DepositBankTransaction(BankTransaction transaction);
    // BankTransaction WithdrawBankTransaction(BankTransaction Transaction);
}
