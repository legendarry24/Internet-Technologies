using System;
using System.Net.Http;
using System.Net.Http.Headers;

namespace WebClient.Services
{
	public abstract class ServiceBase
	{
		protected HttpClient Client { get; }

		private const string _baseUri = "https://localhost:44334/";
		private const string _query = "api/phones/";

		protected string Query => _query;
		protected string Path => _baseUri + _query;

		protected ServiceBase()
		{
			Client = new HttpClient();
			Client.BaseAddress = new Uri(_baseUri);
			Client.DefaultRequestHeaders.Accept.Clear();
			// set Accept header to "application/json"
			Client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
		}
	}
}