using System;
using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Threading.Tasks;

namespace ConsoleClient
{
	public class ConsoleHttpClient
	{
		private static readonly HttpClient _client;
		private static ConsoleHttpClient _consoleHttpClient;

		private const string baseUri = "https://localhost:44334/";

		static ConsoleHttpClient()
		{
			_consoleHttpClient = new ConsoleHttpClient();

			_client = new HttpClient();
			_client.BaseAddress = new Uri(baseUri);
			_client.DefaultRequestHeaders.Accept.Clear();
			// set Accept header to "application/json"
			_client.DefaultRequestHeaders.Accept.Add(new MediaTypeWithQualityHeaderValue("application/json"));
		}

		private ConsoleHttpClient()
		{ }

		public static ConsoleHttpClient GetInstance => _consoleHttpClient;

		public async Task RunMenuAsync()
		{
			while (true)
			{
				Console.WriteLine($"\r{new string('>', 73)}\nWhat do you want?\n" +
				                  "Press 1 to find all phones\n" +
				                  "Press 2 to find the phone by id\n" +
				                  "Press 3 to create new phone\n" +
				                  "Press 4 to update the phone\n" +
				                  "Press 5 to delete the phone\n" +
				                  $"Press Escape to Exit\n{new string('-', 73)}");
				ConsoleKeyInfo answer = Console.ReadKey();

				if (answer.Key == ConsoleKey.Escape)
					break;

				Phone phone;
				switch (answer.Key)
				{
					case ConsoleKey.D1:
						// Get all phones
						var phones = await GetPhonesAsync(baseUri + "api/phones");
						foreach (Phone p in phones)
						{
							Console.WriteLine(p);
						}

						Console.WriteLine(new string('#', 50));
						break;
					case ConsoleKey.D2:
						// Get phone by Id
						phone = await GetPhoneByIdAsync();
						Console.WriteLine(phone);

						Console.WriteLine(new string('#', 50));
						break;
					case ConsoleKey.D3:
						// Create a new phone
						phone = InputNewPhone();
						Uri url = await CreatePhoneAsync(phone);
						Console.WriteLine($"Created at {url}");

						Console.WriteLine(new string('#', 50));
						break;
					case ConsoleKey.D4:
						// Update the phone
						phone = await GetPhoneByIdAsync();
						Console.WriteLine("Please input new price");
						if (decimal.TryParse(Console.ReadLine(), out decimal price))
						{
							Console.WriteLine("Updating price...");
							phone.Price = price;
							await UpdatePhoneAsync(phone);
							Console.WriteLine(phone);
						}

						Console.WriteLine(new string('#', 50));
						break;
					case ConsoleKey.D5:
						// Delete the phone
						phone = await GetPhoneByIdAsync();
						HttpStatusCode statusCode = await DeletePhoneAsync(phone.Id);
						Console.WriteLine($"Deleted (HTTP Status = {(int) statusCode})");

						Console.WriteLine(new string('#', 50));
						break;
				}
			}
		}

		public async Task RunAsync()
		{
			try
			{
				// Get phone by Id
				Phone phone = await GetPhoneAsync(baseUri + "api/phones/1");
				Console.WriteLine(phone);

				Console.WriteLine(new string('#', 50));

				// Get all phones
				IEnumerable<Phone> phones = await GetPhonesAsync(baseUri + "api/phones");
				foreach (Phone p in phones)
				{
					Console.WriteLine(p);
				}

				Console.WriteLine(new string('#', 50));

				// Create a new phone
				Phone phone2 = new Phone
				{
					Manufacturer = "Meizu",
					Model = "m3 note",
					Price = 4400.99m
				};

				var url = await CreatePhoneAsync(phone2);
				Console.WriteLine($"Created at {url}");

				Console.WriteLine(new string('#', 50));

				// Get created phone
				phone2 = await GetPhoneAsync(url.PathAndQuery);
				Console.WriteLine(phone2);

				// Update the phone
				Console.WriteLine("Updating price...");
				phone2.Price = 4340.99m;
				await UpdatePhoneAsync(phone2);
				Console.WriteLine(phone2);

				Console.WriteLine(new string('#', 50));

				// Delete the phone
				var statusCode = await DeletePhoneAsync(phone2.Id);
				Console.WriteLine($"Deleted (HTTP Status = {(int)statusCode})");
			}
			catch (Exception e)
			{
				Console.WriteLine(e.Message);
			}
		}

		private async Task<Phone> GetPhoneByIdAsync()
		{
			Console.WriteLine("\rPlease input phone's Id");
			if (int.TryParse(Console.ReadLine(), out int id))
			{
				return await GetPhoneAsync(baseUri + "api/phones/" + id);
			}

			return null;
		}

		private async Task<Phone> GetPhoneAsync(string path)
		{
			Phone phone = null;
			// HTTP GET request
			HttpResponseMessage response = await _client.GetAsync(path);

			if (response.IsSuccessStatusCode)
			{
				// deserialize JSON to Phone
				phone = await response.Content.ReadAsAsync<Phone>();
			}

			return phone;
		}

		private async Task<IEnumerable<Phone>> GetPhonesAsync(string path)
		{
			IEnumerable<Phone> phones = null;
			// HTTP GET request
			HttpResponseMessage response = await _client.GetAsync(path);

			if (response.IsSuccessStatusCode)
			{
				// deserialize JSON to Phone
				phones = await response.Content.ReadAsAsync<IEnumerable<Phone>>();
			}

			return phones;
		}

		private async Task<Uri> CreatePhoneAsync(Phone phone)
		{
			// HTTP POST request
			HttpResponseMessage response = await _client.PostAsJsonAsync(
				"api/phones", phone);
			// throws an exception if the status code falls outside the range 200–299
			response.EnsureSuccessStatusCode();

			// return URI of the created resource.
			return response.Headers.Location;
		}

		private async Task<Phone> UpdatePhoneAsync(Phone phone)
		{
			// HTTP PUT request
			HttpResponseMessage response = await _client.PutAsJsonAsync(
				$"api/phones/{phone.Id}", phone);
			response.EnsureSuccessStatusCode();

			// Deserialize the updated phone from the response body.
			phone = await response.Content.ReadAsAsync<Phone>();

			return phone;
		}

		private async Task<HttpStatusCode> DeletePhoneAsync(int id)
		{
			// HTTP DELETE request
			HttpResponseMessage response = await _client.DeleteAsync(
				$"api/phones/{id}");

			return response.StatusCode;
		}

		private Phone InputNewPhone()
		{
			try
			{
				Console.Write("\rManufacturer: ");
				string manufacturer = Console.ReadLine();
				Console.Write("Model: ");
				string model = Console.ReadLine();
				Console.Write("Price: ");
				decimal price = decimal.Parse(Console.ReadLine());

				var phone = new Phone
				{
					Manufacturer = manufacturer,
					Model = model,
					Price = price
				};

				return phone;
			}
			catch (FormatException)
			{
				Console.WriteLine("Wrong price format");
			}

			return null;
		}
	}
}