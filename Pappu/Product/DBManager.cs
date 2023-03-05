using BOL;
namespace DAL;
public class DBManager:IDBManager{
    public List<Donor> GetColAllDonors(){
        using(var context=new CollectionContext()){
            var donors=from don in context.Donors select don;
            return products.ToList<Donor>();
        }
    }
}