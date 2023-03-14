// using System.Collections.Generic;
// using System.Linq;
// using Microsoft.EntityFrameworkCore;
// namespace BOL;
// public class DonorServiceImpl : IDonorService
// {
//     private readonly NeedyContext _context;

//     public DonorServiceImpl(NeedyContext context)
//     {
//         _context = context;
//     }

//     public List<Donor> GetAllDonors()
//     {
//         return _context.Donor.ToList();
//     }

//     public Donor AddDonor(Donor donor)
//     {
//         _context.Donor.Add(donor);
//         _context.SaveChanges();
//         return donor;
//     }

//     // public string DeleteDonor(long donorId)
//     // {
//     //     var donor = _context.Donor.Find(donorId);
//     //     if (donor != null)
//     //     {
//     //         _context.Donor.Remove(donor);
//     //         _context.SaveChanges();
//     //         return "Donor deleted successfully";
//     //     }
//     //     return "Invalid donor ID, deletion failed";
//     // }

//     // public Donor GetOneDonor(long donId)
//     // {
//     //     var donor = _context.Donor.Find(donId);
//     //     if (donor == null)
//     //     {
//     //         throw new ResourceNotFoundException("Invalid Donator Id");
//     //     }
//     //     return donor;
//     // }

//     // public Donor UpdateDonor(Donor don)
//     // {
//     //     var existingDonor = _context.Donor.Find(don.Id);
//     //     if (existingDonor != null)
//     //     {
//     //         existingDonor.Name = don.Name;
//     //         existingDonor.Email = don.Email;
//     //         existingDonor.Password = don.Password;
//     //         existingDonor.Status = don.Status;
//     //         _context.SaveChanges();
//     //         return existingDonor;
//     //     }
//     //     throw new ResourceNotFoundException("Invalid Donor id so updation failed");
//     // }

//     // public Donor ValidateDon(DonorLoginDto don)
//     // {
//     //     var donor = _context.Donor.FirstOrDefault(d => d.Email == don.Email && d.Password == don.Password);
//     //     if (donor == null)
//     //     {
//     //         throw new ResourceNotFoundException("Invalid Email or password");
//     //     }
//     //     return donor;
//     // }

//     // public List<Donor> GetAllTrueDonors()
//     // {
//     //     return _context.Donor.Where(d => d.Status == true).ToList();
//     // }

//     // public string DeleteFalseDonor(long donorId)
//     // {
//     //     var donor = _context.Donor.Find(donorId);
//     //     if (donor != null)
//     //     {
//     //         donor.Status = false;
//     //         _context.SaveChanges();
//     //         return "Set to false (Updated)";
//     //     }
//     //     throw new ResourceNotFoundException("Invalid Id");		
// 	// }

// }
