using System;
using System.Collections.Generic;
using System.Linq.Expressions;
using System.Net.Http;
using System.Threading.Tasks;
using Domain.Models;

namespace WebClient.Services
{
	public class SearchService : ServiceBase, ISearchService
	{
		public async Task<IEnumerable<Phone>> GetPhonesAsync()
		{
			IEnumerable<Phone> phones = null;
			// HTTP GET request
			HttpResponseMessage response = await Client.GetAsync(Path);

			if (response.IsSuccessStatusCode)
			{
				// deserialize JSON to Phone
				phones = await response.Content.ReadAsAsync<IEnumerable<Phone>>();
			}

			return phones;
		}

		public async Task<Phone> GetPhoneByIdAsync(int id)
		{
			Phone phone = null;
			// HTTP GET request
			HttpResponseMessage response = await Client.GetAsync(Path + id);

			if (response.IsSuccessStatusCode)
			{
				// deserialize JSON to Phone
				phone = await response.Content.ReadAsAsync<Phone>();
			}

			return phone;
		}

		public IEnumerable<Phone> FindByFilter(Expression<Func<Phone, bool>> filter)
		{
			throw new NotImplementedException();
		}
	}
}