﻿using CarsMatter.Infrastructure.Models.MsSQL;
using Microsoft.EntityFrameworkCore;

namespace CarsMatter.Infrastructure.Db
{
    public sealed class CarsMatterDbContext : DbContext
    {
        public DbSet<RefillNote> RefillNotes { get; set; }

        public DbSet<ConsumablesNote> ConsumablesNotes { get; set; }

        public DbSet<User> Users { get; set; }

        public DbSet<Brand> Brands { get; set; }

        public DbSet<BrandModel> BrandModels { get; set; }

        public DbSet<Car> Cars { get; set; }

        public DbSet<KindOfService> KindsOfService { get; set; }

        public DbSet<MyCar> MyCars { get; set; }

        public CarsMatterDbContext(DbContextOptions<CarsMatterDbContext> options) : base(options)
        {
            this.Database.EnsureCreated();
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<UserCar>()
                .HasKey(fc => new { fc.CarId, fc.UserId });

            modelBuilder.Entity<ConsumablesNote>()
                .HasOne(c => c.KindOfService);

            modelBuilder.Entity<ConsumablesNote>()
                .HasOne(n => n.MyCar);

            modelBuilder.Entity<RefillNote>()
                .HasOne(n => n.MyCar);

            modelBuilder.Entity<MyCar>()
                .HasMany(c => c.RefillNotes)
                .WithOne(n => n.MyCar)
                .OnDelete(DeleteBehavior.Cascade);

            modelBuilder.Entity<MyCar>()
                .HasMany(c => c.ConsumablesNotes)
                .WithOne(n => n.MyCar)
                .OnDelete(DeleteBehavior.Cascade);

        }
    }
}
