namespace BOL;
using System.ComponentModel.DataAnnotations;
public class signup_donor
{

public string donor_id {get;set;}
[Required]
public string donor_name {get;set;}
[Required]
public string donor_address {get;set;}
[Required]
[StringLength(10)]
public string donor_mobile_no {get;set;}
[Required]
[Range((string)),6,20]
public string donor_email_id {get;set;}
[Required]
public string donor_password {get;set;}
public string donor_status {get;set;}
}
