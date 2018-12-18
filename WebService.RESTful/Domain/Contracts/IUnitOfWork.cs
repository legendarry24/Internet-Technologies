using System;

namespace Domain.Contracts
{
	public interface IUnitOfWork : IDisposable
	{
		IPhoneRepository PhoneRepository { get; }

		void Save();
	}
}