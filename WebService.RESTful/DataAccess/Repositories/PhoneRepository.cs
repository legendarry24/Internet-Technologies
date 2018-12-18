using System.Collections.Generic;
using System.Linq;
using Domain.Contracts;
using Domain.Models;
using Microsoft.EntityFrameworkCore;

namespace DataAccess.Repositories
{
	public class PhoneRepository : IPhoneRepository
	{
		private readonly DbSet<Phone> _phoneEntities;

		public PhoneRepository(ShopContext context)
		{
			_phoneEntities = context.Phones;
		}

		public IEnumerable<Phone> GetAll()
		{
			return _phoneEntities.ToList();
		}

		public Phone GetById(int id)
		{
			return _phoneEntities.Find(id);
		}

		public void Add(Phone entity)
		{
			_phoneEntities.Add(entity);
		}

		public void Remove(int Id)
		{
			var phoneEntity = _phoneEntities.Find(Id);

			_phoneEntities.Remove(phoneEntity);
		}

		public IEnumerable<Phone> GetTheCheapestPhones()
		{
			return _phoneEntities.OrderBy(p => p.Price).Take(5);
		}
	}
}