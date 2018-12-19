using DataAccess.Repositories;
using Domain.Contracts;

namespace DataAccess
{
	public class UnitOfWork : IUnitOfWork
	{
		private readonly ShopContext _context;

		public UnitOfWork(ShopContext context)
		{
			_context = context;
			PhoneRepository = new PhoneRepository(_context);
		}

		public IPhoneRepository PhoneRepository { get; }

		public void Save()
		{
			_context.SaveChanges();
		}

		public void Dispose()
		{
			_context.Dispose();
		}
	}
}