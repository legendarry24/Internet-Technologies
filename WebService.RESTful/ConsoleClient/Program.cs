namespace ConsoleClient
{
	class Program
	{
		static void Main(string[] args)
		{
			ConsoleHttpClient client = ConsoleHttpClient.GetInstance;

			client.RunMenuAsync().Wait();

			//client.RunAsync().Wait();
			//client.RunAsync().GetAwaiter().GetResult();
		}
	}
}
