using System.Net;
using System.Net.Http;
using System.Threading.Tasks;

namespace WebClient.Services
{
	public class DeleteService : ServiceBase
	{
		public async Task<HttpStatusCode> DeletePhoneAsync(int id)
		{
			// HTTP DELETE request
			HttpResponseMessage response = await Client.DeleteAsync($"{Query}{id}");

			return response.StatusCode;
		}
	}
}