namespace HNO;

public class Donator
{
    public int DonatorId { get; set; }
    public string DonatorName { get; set; }
    public string DonatorAddress { get; set; }
    public int DonatorMobileNo { get; set; }
    public string DonatorEmailId { get; set; }
    public string DonatorPassword { get; set; }
    public string DonatorStatus { get; set; }

    public override string ToString()
    {
        return base.ToString()
            + "  "
            + DonatorId
            + "  "
            + DonatorName
            + "  "
            + DonatorAddress
            + "  "
            + DonatorMobileNo
            + "  "
            + DonatorEmailId
            + "  "
            + DonatorPassword
            + "  "
            + DonatorStatus;
    }
}
