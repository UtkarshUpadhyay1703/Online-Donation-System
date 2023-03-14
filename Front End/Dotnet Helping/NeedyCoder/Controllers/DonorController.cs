using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Cors;
namespace NeedyCoder.Controllers;

using BOL;
using DAL;
[ApiController]
[Route("[controller]")]
public class DonorController : ControllerBase
{
     private readonly ILogger<DonorController> _logger;
  
    public DonorController(ILogger<DonorController> logger)
    {
        _logger = logger;
    }
   
    [HttpGet(Name = "GetDonor")]
        public IEnumerable<Donor> Get()
    {
        List<Donor> AllDonor=new List<Donor>();
        DBManager dbm=new DBManager();
        AllDonor=dbm.GetAllDonors();
        return AllDonor;
    }

    [HttpGet]
    [Route ("{donorid:}")]
    public Donor GetByDonorId([FromRoute] int donorid){
        Donor donor=new Donor();
        DBManager dbm=new DBManager();
        donor=dbm.GetByDonorId(donorid);
        return donor;
    }

    [HttpPost]
    public void InsertDonor(Donor donor){
        DBManager dbm=new DBManager();
        dbm.InsertDonor(donor);
    }
    [HttpDelete]
    [Route ("{donorid:}")]
    public void DeleteDonor(int donorid){
        DBManager dbm=new DBManager();
        dbm.DeleteDonor(donorid);
    }
    [HttpPut]
    [Route ("{donorid:}")]
    public void UpdateDonor(int donorid,Donor donor){
        DBManager dbm=new DBManager();
        dbm.UpdateDonor(donorid,donor);
    }

    // [HttpGet]
    // public ActionResult<IEnumerable<Donor>> GetAllDonors()
    // {
    //     return _context.Donors.ToList();
    // }

//    [HttpPost]
//     public ActionResult<Donor> AddDonor(DonorAddDto donorDto)
//     {
//        DBManager dbm=new DBManager();
//           dbm.AddDonor(donorDto);
       
//         var donor = new Donor
//         {
//             DonorName = donorDto.DonorName,
//             DonorEmailId = donorDto.DonorEmailId,
//             DonorAddress = donorDto.DonorAddress,
//             DonorMobileNo = donorDto.DonorMobileNo,
//             DonorStatus = true
//         };

//         _context.Donors.Add(donor);
//         _context.SaveChanges();

//         return Ok(donor);
//     }

    // [HttpDelete("{donorId}")]
    // public ActionResult DeleteDonor(long donorId)
    // {
    //     var donor = _context.Donors.Find(donorId);

    //     if (donor == null)
    //     {
    //         return NotFound();
    //     }

    //     _context.Donors.Remove(donor);
    //     _context.SaveChanges();

    //     return NoContent();
    // }

    // [HttpGet("{donId}")]
    // public ActionResult<Donor> GetOneDonor(long donId)
    // {
    //     var donor = _context.Donors.Find(donId);

    //     if (donor == null)
    //     {
    //         return NotFound();
    //     }

    //     return Ok(donor);
    // }

    // [HttpPut]
    // public ActionResult<Donor> UpdateDonor(Donor don)
    // {
    //     var existingDonor = _context.Donors.Find(don.DonorId);

    //     if (existingDonor == null)
    //     {
    //         return NotFound();
    //     }

    //     existingDonor.DonorName = don.DonorName;
    //     existingDonor.DonorEmail = don.DonorEmail;
    //     existingDonor.DonorAddress = don.DonorAddress;
    //     existingDonor.DonorPhoneNumber = don.DonorPhoneNumber;

    //     _context.SaveChanges();

    //     return Ok(existingDonor);
    // }

    // [HttpPost("signIn")]
    // public ActionResult<Donor> ValidateDonor(DonorLoginDto donLogIn)
    // {
    //     var donor = _context.Donors.FirstOrDefault(d => d.DonorEmail == donLogIn.DonorEmail && d.DonorPassword == donLogIn.DonorPassword);

    //     if (donor == null)
    //     {
    //         return NotFound();
    //     }

    //     return Ok(donor);
    // }

    // [HttpGet("Donortrue")]
    // public ActionResult<IEnumerable<Donor>> GetAllTrueDonors()
    // {
    //     return _context.Donors.Where(d => d.DonorStatus == true).ToList();
    // }

    // [HttpPut("{donId}")]
    // public ActionResult DeleteFalseDonor(long donId)
    // {
    //     var donor = _context.Donors.Find(donId);

    //     if (donor == null)
    //     {
    //         return NotFound();
    //     }

    //     donor.DonorStatus = false;
    //     _context.SaveChanges();

    //     return NoContent();
    // }

    // [HttpPost("Transaction/deposit")]
    // public ActionResult<BankTransaction> DepositBankTransaction(ReceivedDto rec)
    // {
    //     var donor = _context.Donors.Find(rec.Don.DonorId);

    //     if (donor == null)
    //     {
    //         return NotFound();
    //     }

    //     var transaction = new BankTransaction
    //     {
    //         Donor = donor,
    //         AmountReceived = rec.AmountReceived
    //     };

    //     _context.BankTransactions.Add(transaction);
    // }
}