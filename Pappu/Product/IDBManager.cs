using BOL;
namespace DAL;
public interface IDBManager{
    List<Donor> GetColAllDonors();

    ActionResult<IEnumerable<Donor>> GetAllDonors();
    
    ActionResult<Donor> AddDonor(DonorAddDto donorDto);

}