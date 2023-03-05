using BOL;
namespace DAL;
using Microsoft.EntityFrameworkCore;
public class CollectionContext:DbContext{
    public DbSet<Product> Products{get;set;}
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder){
        string conString=@"server=localhost;port=3306;user=root;password=root;database=test";
        optionsBuilder.UseMySQL(conString);
    }
    protected override void OnModelCreating(ModelBuilder modelBuilder){
        base.OnModelCreating(modelBuilder);
        modelBuilder.Entity<Product>(entity=>{
            entity.HasKey(e=>e.Id);
            entity.Property(e=>e.donorName);
            entity.Property(e=>e.Price);
        });
        modelBuilder.Entity<Product>().ToTable("Product11");
    }
}