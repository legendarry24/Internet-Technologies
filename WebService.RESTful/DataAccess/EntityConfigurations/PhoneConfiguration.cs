using Domain.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata.Builders;

namespace DataAccess.EntityConfigurations
{
	public class PhoneConfiguration : IEntityTypeConfiguration<Phone>
	{
		public void Configure(EntityTypeBuilder<Phone> builder)
		{
			builder.Property(p => p.Id)
				.ValueGeneratedOnAdd();

			builder.Property(p => p.Manufacturer)
				.IsRequired()
				.IsUnicode()
				.HasMaxLength(25);

			builder.Property(p => p.Model)
				.IsRequired()
				.IsUnicode()
				.HasMaxLength(50);
		}
	}
}