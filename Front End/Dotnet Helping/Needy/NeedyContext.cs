using BOL;
namespace DAL;
using Microsoft.EntityFrameworkCore;
public class NeedyContext:DbContext{
    public DbSet<Donor> Donors{get;set;}
    public DbSet<Vendor> Vendors{get;set;}
    public DbSet<Employee> Employees{get;set;}

    public DbSet<ItemDonation> ItemDonations{get;set;}

    //public ActionResult<Donor> AddDonor(DonorAddDto donorDto);
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder){
        string conString=@"server=localhost;port=3306;user=root;password=Sahas123@;database=helping";
        optionsBuilder.UseMySQL(conString);
    }
    protected override void OnModelCreating(ModelBuilder modelBuilder){
        base.OnModelCreating(modelBuilder);
        modelBuilder.Entity<Donor>(entity=>{
            entity.HasKey(e=>e.Id);
            entity.Property(e=>e.DonorAddress);
            entity.Property(e=>e.DonorEmailId);
            entity.Property(e=>e. DonorMobileNo);
            entity.Property(e=>e.DonorName);
            entity.Property(e=>e.DonorPassword);
            entity.Property(e=>e.DonorStatus);
        });
        modelBuilder.Entity<Donor>().ToTable("signup_donor");

        modelBuilder.Entity<Vendor>(entity=>{
            entity.HasKey(e=>e.Id);
            entity.Property(e=>e.VendorCompanyName);
            entity.Property(e=>e.VendorCompanyAddress);
            entity.Property(e=>e.VendorMobileNo);
            entity.Property(e=>e.VendorAadharNo);
            entity.Property(e=>e.VendorCompanyBankAccountNo);
            entity.Property(e=>e.VendorCompanyBankIFSC);           
            entity.Property(e=>e.VendorEmailId);
            entity.Property(e=>e.VendorPassword);
            entity.Property(e=>e.VendorStatus);
        });
        modelBuilder.Entity<Vendor>().ToTable("signup_vendor");

           modelBuilder.Entity<Employee>(entity=>{
            entity.HasKey(e=>e.Id);
            entity.Property(e=>e.EmployeeAddress);
            entity.Property(e=>e.EmployeeMobileNo);
            entity.Property(e=>e.EmployeeBankAccountNo);
            entity.Property(e=>e.EmployeeCompanyBankIFSC);
            entity.Property(e=>e.EmployeeEmailId);
            entity.Property(e=>e.EmployeeMobileNo);
            entity.Property(e=>e.EmployeeName);
            entity.Property(e=>e.EmployeePassword);
            entity.Property(e=>e.EmployeeQualification);
            entity.Property(e=>e.EmployeeStatus);
        });
        modelBuilder.Entity<Employee>().ToTable("signup_employee");

        // for foreign key with one to many
           
           

//     public ICollection<Employee> Employees { get; set; }

// public class MyDbContext : DbContext
// {
//     public DbSet<Employee> Employees { get; set; }
//     public DbSet<Department> Departments { get; set; }

//     protected override void OnModelCreating(ModelBuilder modelBuilder)
//     {
//         modelBuilder.Entity<Employee>()
//             .HasOne(e => e.Department)
//             .WithMany(d => d.Employees)
//             .HasForeignKey(e => e.DepartmentId);
//     }
// }
    }
}