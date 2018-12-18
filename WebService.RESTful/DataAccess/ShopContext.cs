using DataAccess.EntityConfigurations;
using Domain.Models;
using Microsoft.EntityFrameworkCore;

namespace DataAccess
{
	public class ShopContext : DbContext
	{
		public ShopContext(DbContextOptions<ShopContext> options)
			: base(options)
		{ }

		public DbSet<Phone> Phones { get; set; }

		protected override void OnModelCreating(ModelBuilder modelBuilder)
		{
			modelBuilder.ApplyConfiguration(new PhoneConfiguration());

			base.OnModelCreating(modelBuilder);
		}
	}
}
