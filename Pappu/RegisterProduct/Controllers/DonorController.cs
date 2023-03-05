using Microsoft.AspNetCore.Mvc;
using System.Collections.Generic;
using System.Linq;

using BOL;
using DAL;
[ApiController]
[Route("donors")]
public class DonorController : BaseEntity
{
    private readonly DonorDbContext _context;

    public DonorController(DonorDbContext context)
    {
        _context = context;
    }

    [HttpGet]
    public ActionResult<IEnumerable<Donor>> GetAllDonors()
    {
        return _context.Donors.ToList();
    }

    [HttpPost]
    public ActionResult<Donor> AddDonor(DonorAddDto donorDto)
    {
        var donor = new Donor
        {
            DonorName = donorDto.DonorName,
            DonorEmail = donorDto.DonorEmail,
            DonorAddress = donorDto.DonorAddress,
            DonorPhoneNumber = donorDto.DonorPhoneNumber,
            DonorStatus = true
        };

        _context.Donors.Add(donor);
        _context.SaveChanges();

        return Ok(donor);
    }

    [HttpDelete("{donId}")]
    public ActionResult DeleteDonor(long donId)
    {
        var donor = _context.Donors.Find(donId);

        if (donor == null)
        {
            return NotFound();
        }

        _context.Donors.Remove(donor);
        _context.SaveChanges();

        return NoContent();
    }

    [HttpGet("{donId}")]
    public ActionResult<Donor> GetOneDonor(long donId)
    {
        var donor = _context.Donors.Find(donId);

        if (donor == null)
        {
            return NotFound();
        }

        return Ok(donor);
    }

    [HttpPut]
    public ActionResult<Donor> UpdateDonor(Donor don)
    {
        var existingDonor = _context.Donors.Find(don.DonorId);

        if (existingDonor == null)
        {
            return NotFound();
        }

        existingDonor.DonorName = don.DonorName;
        existingDonor.DonorEmail = don.DonorEmail;
        existingDonor.DonorAddress = don.DonorAddress;
        existingDonor.DonorPhoneNumber = don.DonorPhoneNumber;

        _context.SaveChanges();

        return Ok(existingDonor);
    }

    [HttpPost("signIn")]
    public ActionResult<Donor> ValidateDonor(DonorLoginDto donLogIn)
    {
        var donor = _context.Donors.FirstOrDefault(d => d.DonorEmail == donLogIn.DonorEmail && d.DonorPassword == donLogIn.DonorPassword);

        if (donor == null)
        {
            return NotFound();
        }

        return Ok(donor);
    }

    [HttpGet("Donortrue")]
    public ActionResult<IEnumerable<Donor>> GetAllTrueDonors()
    {
        return _context.Donors.Where(d => d.DonorStatus == true).ToList();
    }

    [HttpPut("{donId}")]
    public ActionResult DeleteFalseDonor(long donId)
    {
        var donor = _context.Donors.Find(donId);

        if (donor == null)
        {
            return NotFound();
        }

        donor.DonorStatus = false;
        _context.SaveChanges();

        return NoContent();
    }

    [HttpPost("Transaction/deposit")]
    public ActionResult<BankTransaction> DepositBankTransaction(ReceivedDto rec)
    {
        var donor = _context.Donors.Find(rec.Don.DonorId);

        if (donor == null)
        {
            return NotFound();
        }

        var transaction = new BankTransaction
        {
            Donor = donor,
            AmountReceived = rec.AmountReceived
        };

        _context.BankTransactions.Add(transaction);
    }
}