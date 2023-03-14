// using System.Collections.Generic;
// using System.Linq;
// using System.Threading.Tasks;
// using Microsoft.EntityFrameworkCore;
// //using MyNamespace.Models;
// //using BOL;
// //using BOL.poco;
// namespace BOL;
// //public class DonorRepository : IDonorRepository
// public class DonorRepository 
// {
//     private readonly MyDbContext _dbContext;

//     public DonorRepository(MyDbContext dbContext)
//     {
//         _dbContext = dbContext;
//     }

//     public async Task<Donor> FindByDonorEmailIdAndDonorPasswordAsync(string em, string pass)
//     {
//         return await _dbContext.Donors.FirstOrDefaultAsync(d => d.DonorEmailId == em && d.DonorPassword == pass);
//     }

//     public async Task<List<Donor>> FindByDonorStatusAsync(bool status)
//     {
//         return await _dbContext.Donors.Where(d => d.DonorStatus == status).ToListAsync();
//     }

//     public void SetDonorStatusToFalse(long id)
//     {
//         var donor = _dbContext.Donors.FirstOrDefault(d => d.Id == id);
//         if (donor != null)
//         {
//             donor.DonorStatus = false;
//             _dbContext.SaveChanges();
//         }
//     }
// }
