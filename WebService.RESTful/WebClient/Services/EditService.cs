using System.Net.Http;
using System.Threading.Tasks;
using WebClient.Models;

namespace WebClient.Services
{
	public class EditService : ServiceBase
	{
		public async Task<Phone> UpdatePhoneAsync(Phone phone)
		{
			// HTTP PUT request
			HttpResponseMessage response = await _client.PutAsJsonAsync(
				$"api/phones/{phone.Id}", phone);
			response.EnsureSuccessStatusCode();

			// Deserialize the updated phone from the response body.
			phone = await response.Content.ReadAsAsync<Phone>();

			return phone;
		}
	}
}