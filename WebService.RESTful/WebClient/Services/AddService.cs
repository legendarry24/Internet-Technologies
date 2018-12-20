using System;
using System.Net.Http;
using System.Threading.Tasks;
using Domain.Models;

namespace WebClient.Services
{
	public class AddService : ServiceBase
	{
		public async Task<Uri> CreatePhoneAsync(Phone phone)
		{
			// HTTP POST request
			HttpResponseMessage response = await Client.PostAsJsonAsync(Query, phone);
			// throws an exception if the status code falls outside the range 200–299
			response.EnsureSuccessStatusCode();

			// return URI of the created resource.
			return response.Headers.Location;
		}
	}
}