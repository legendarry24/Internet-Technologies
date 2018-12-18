using System.Collections.Generic;
using Domain.Models;

namespace Domain.Contracts
{
	public interface IPhoneRepository : IRepository<Phone>
	{
		IEnumerable<Phone> GetTheCheapestPhones();
	}
}