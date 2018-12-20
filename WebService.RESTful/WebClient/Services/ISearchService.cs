using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Threading.Tasks;
using WebClient.Models;

namespace WebClient.Services
{
	public interface ISearchService
	{
		Task<IEnumerable<Phone>> GetPhonesAsync();
		Task<Phone> GetPhoneByIdAsync(int id);
		IEnumerable<Phone> FindByFilter(Expression<Func<Phone, bool>> filter);
	}
}