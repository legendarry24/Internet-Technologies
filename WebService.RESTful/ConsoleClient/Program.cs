using System;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;

namespace ConsoleClient
{
	class Program
	{
		static readonly HttpClient client = new HttpClient();
		private const string baseUri = "https://localhost:44334/";

		static void Main(string[] args)
		{
			client.BaseAddress = new Uri(baseUri);
			client.DefaultRequestHeaders.Accept.Clear();
			// set Accept header to "application/json"
			client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));

			RunAsync().GetAwaiter().GetResult();
		}

		static async Task RunAsync()
		{
			try
			{
				// Get phone by Id
				Phone phone = await GetPhoneAsync(baseUri + "api/phones/1");
				Console.WriteLine(phone);
			}
			catch (Exception e)
			{
				Console.WriteLine(e.Message);
			}
		}

		static async Task<Phone> GetPhoneAsync(string path)
		{
			Phone phone = null;
			// HTTP GET request
			HttpResponseMessage response = await client.GetAsync(path);

			if (response.IsSuccessStatusCode)
			{
				// deserialize JSON to Phone
				phone = await response.Content.ReadAsAsync<Phone>();
			}

			return phone;
		}
	}
}
