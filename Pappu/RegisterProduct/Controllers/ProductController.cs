using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Cors;
namespace RegisterProduct.Controllers;
using BOL;
using DAL;


[ApiController]
[Route("[controller]")]
public class ProductController : ControllerBase
{

    private readonly ILogger<ProductController> _logger;

    public ProductController(ILogger<ProductController> logger)
    {
        _logger = logger;
    }

    [HttpGet(Name = "GetProduct")]
    public IEnumerable<Product> GetAllProducts()
    {
        DBManager dbm=new DBManager();
        List<Product> all =dbm.GetAllProducts();
        return all;
    }
}
