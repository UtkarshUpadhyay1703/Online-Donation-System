using BOL;
namespace DAL;
public class DBManager:IDBManager{
    public List<Product> GetAllProducts(){
        using(var context=new CollectionContext()){
            var products=from prod in context.Products select prod;
            return products.ToList<Product>();
        }
    }
}