using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Cors;
namespace NeedyCoder.Controllers;

using BOL;
using DAL;
[ApiController]
[Route("[controller]")]
public class VendorController : ControllerBase
{
     private readonly ILogger<VendorController> _logger;

    public VendorController(ILogger<VendorController> logger)
    {
        _logger = logger;
    }

    [HttpGet(Name = "GetVendor")]
        public IEnumerable<Vendor> Get()
    {
        List<Vendor> AllVendor=new List<Vendor>();
        DBManager dbm=new DBManager();
        AllVendor=dbm.GetAllVendors();
        return AllVendor;
    }

    [HttpGet]
    [Route ("{vendorid:}")]
    public Vendor GetByVendorId([FromRoute] int vendorid){
        Vendor vendor=new Vendor();
        DBManager dbm=new DBManager();
        vendor=dbm.GetByVendorId(vendorid);
        return vendor;
    }

    [HttpPost]
    public void InsertVendor(Vendor vendor){
        DBManager dbm=new DBManager();
        dbm.InsertVendor(vendor);
    }
    [HttpDelete]
    [Route ("{vendorid:}")]
    public void DeleteVendor(int vendorid){
        DBManager dbm=new DBManager();
        dbm.DeleteVendor(vendorid);
    }
    [HttpPut]
    [Route ("{vendorid:}")]
    public void UpdateVendor(int vendorid,Vendor vendor){
        DBManager dbm=new DBManager();
        dbm.UpdateVendor(vendorid,vendor);
        }
}