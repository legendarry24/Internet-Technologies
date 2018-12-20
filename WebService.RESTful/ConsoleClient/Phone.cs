namespace ConsoleClient
{
	public class Phone
	{
		public int Id { get; set; }

		public string Manufacturer { get; set; }

		public string Model { get; set; }

		public decimal Price { get; set; }

		public override string ToString()
		{
			return $"\r{nameof(Id)}: {Id}\n{nameof(Manufacturer)}: {Manufacturer}\n" +
			       $"{nameof(Model)}: {Model}\n{nameof(Price)}: {Price}";
		}
	}
}