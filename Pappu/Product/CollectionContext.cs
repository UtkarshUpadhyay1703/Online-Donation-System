using BOL;
namespace DAL;
using Microsoft.EntityFrameworkCore;
public class CollectionContext:DbContext{
    public DbSet<Donor> Donors{get;set;}
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder){
        string conString=@"server=localhost;port=3306;user=root;password=root;database=test";
        optionsBuilder.UseMySQL(conString);
    }
    protected override void OnModelCreating(ModelBuilder modelBuilder){
        base.OnModelCreating(modelBuilder);
        modelBuilder.Entity<Donor>(entity=>{
            entity.HasKey(e=>e.Id);
            entity.Property(e=>e.DonorName);
            entity.Property(e=>e.DonorAddress);
            entity.Property(e=>e.DonorMobileNo);
            entity.Property(e=>e.DonorEmailId);
            entity.Property(e=>e.DonorPassword);
            entity.Property(e=>e.DonorStatus);


        });
        modelBuilder.Entity<Donor>().ToTable("signup_donor");
    }
}