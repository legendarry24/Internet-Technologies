using System;
using System.Net.Http;
using System.Net.Http.Headers;

namespace WebClient.Services
{
	public abstract class ServiceBase
	{
		protected readonly HttpClient _client;

		protected const string baseUri = "https://localhost:44334/";

		protected ServiceBase()
		{
			_client = new HttpClient();
			_client.BaseAddress = new Uri(baseUri);
			_client.DefaultRequestHeaders.Accept.Clear();
			// set Accept header to "application/json"
			_client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
		}
	}
}