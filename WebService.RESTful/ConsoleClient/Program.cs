using System;
using System.Net.Http;

namespace ConsoleClient
{
	class Program
	{
		static void Main(string[] args)
		{
			Console.WriteLine("Hello World!");
			const string uri = "https://localhost:44334/api/phones";

			using (HttpClient httpClient = new HttpClient())
			{
				
			}
		}
	}
}
