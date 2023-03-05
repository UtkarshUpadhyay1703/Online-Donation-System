using BOL;
namespace DAL;
using Microsoft.EntityFrameworkCore;
public class CollectionContext1:DbContext{
    public DbSet<Product> Products{get;set;}
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder){
        string str;
        optionsBuilder.UseMySQL(str);
    }
    protected override void OnModelCreating(ModelBuilder modelBuilder){
        this.OnModelCreating(modelBuilder);
        modelBuilder.Entity<Product>(entity=>{
            entity.HasKey(e=>e.Id);
            entity.Property(e=>e.Name).HasMaxLength(20).IsRequired();
        });
        modelBuilder.Entity<Product>().ToTable("signup_donor");
        protected override void OnModelCreating(ModelBuilder modelBuilder)
{
    modelBuilder.Entity<MyEntity>()
        .Property(e => e.MyColumn)
        .HasMaxLength(100)
        .IsRequired();
}

    }
}