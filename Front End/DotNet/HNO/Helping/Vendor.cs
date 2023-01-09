namespace HNO;

public class Vendor
{
    public int VendorId { get; set; }
    public string VendorCompanyName { get; set; }
    public string VendorCompanyAddress { get; set; }
    public int VendorMobNo { get; set; }
    public int VendorAadharno { get; set; }
    public int VendorCompanyBankAccountNo { get; set; }
    public string VendorEmailid { get; set; }
    public string VendorPassword { get; set; }
    public string VendorStatus { get; set; }

    public override string ToString()
    {
        return base.ToString()
            + "  "
            + VendorId
            + "  "
            + VendorCompanyName
            + "  "
            + VendorCompanyAddress
            + "  "
            + VendorMobNo
            + "  "
            + VendorAadharno
            + "  "
            + VendorCompanyBankAccountNo
            + "  "
            + VendorEmailid
            + "  "
            + VendorPassword
            + "  "
            + VendorStatus;
    }
}
