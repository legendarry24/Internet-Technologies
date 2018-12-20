using System;
using System.Collections.Generic;
using System.Globalization;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using WebClient.Models;
using WebClient.Services;

namespace WebClient.Controllers
{
	public class PhonesController : Controller
	{
		private readonly ISearchService _searchService;
		private readonly AddService _addService;
		private readonly EditService _editService;
		private readonly DeleteService _deleteService;

		public PhonesController(ISearchService searchService,
			AddService addService,
			EditService editService,
			DeleteService deleteService)
		{
			_searchService = searchService;
			_addService = addService;
			_editService = editService;
			_deleteService = deleteService;
		}

		// GET: Phones
		public async Task<ActionResult> Index()
		{
			var phones = await _searchService.GetPhonesAsync();

			return View(phones);
		}

		[HttpPost]
		public async Task<ActionResult> Index(IFormCollection collection)
		{
			var filter = collection["filter"];

			if (string.IsNullOrWhiteSpace(filter))
			{
				return RedirectToAction(nameof(Index));
			}

			if (!int.TryParse(filter, out int id))
			{
				return BadRequest();
			}

			var phone = await _searchService.GetPhoneByIdAsync(id);
			if (phone == null)
			{
				return NotFound();
			}

			var phones = new [] { phone };

			return View(phones);
		}

		// GET: Phones/Create
		public ActionResult Create()
		{
			//return View();
			return NotFound();
		}

		// POST: Phones/Create
		[HttpPost]
		[ValidateAntiForgeryToken]
		public ActionResult Create(IFormCollection collection)
		{
			return NotFound();
			//try
			//{
			//	string type = collection["Type"];
			//	Animal animal;

			//	if (type == "Parrot")
			//	{
			//		animal = new Parrot
			//		{
			//			DurationOfLife = int.Parse(collection["DurationOfLife"]),
			//			Color = collection["Color"],
			//			Weight = double.Parse(collection["Weight"], CultureInfo.InvariantCulture),
			//			ColorOfWings = collection["ColorOfWings"],
			//			SizeOfBeak = int.Parse(collection["SizeOfBeak"]),
			//			Wingspan = int.Parse(collection["Wingspan"])
			//		};
			//	}
			//	else if (type == "Turtle")
			//	{
			//		animal = new Turtle
			//		{
			//			DurationOfLife = int.Parse(collection["DurationOfLife"]),
			//			Color = collection["Color"],
			//			Weight = double.Parse(collection["Weight"], CultureInfo.InvariantCulture),
			//			ColorOfShell = collection["ColorOfShell"],
			//			IsToxic = bool.Parse(collection["IsToxic"])
			//		};
			//	}
			//	else if (type == "Cat")
			//	{
			//		animal = new Cat
			//		{
			//			DurationOfLife = int.Parse(collection["DurationOfLife"]),
			//			Color = collection["Color"],
			//			Weight = double.Parse(collection["Weight"], CultureInfo.InvariantCulture),
			//			Voice = collection["Voice"],
			//			IsCatchesMice = bool.Parse(collection["IsCatchesMice"])
			//		};
			//	}
			//	else
			//	{
			//		animal = new Dog
			//		{
			//			DurationOfLife = int.Parse(collection["DurationOfLife"]),
			//			Color = collection["Color"],
			//			Weight = double.Parse(collection["Weight"], CultureInfo.InvariantCulture),
			//			Voice = collection["Voice"],
			//			CanBeTrained = bool.Parse(collection["CanBeTrained"])
			//		};
			//	}

			//	_addService.AddNewAnimal(animal);

			//	return RedirectToAction(nameof(Index));
			//}
			//catch
			//{
			//	return BadRequest();
			//}
		}

		// GET: Phones/Edit/5
		public ActionResult Edit(int id)
		{
			return NotFound();
			//var animal = _searchService.GetAnimals()
			//	.FirstOrDefault(a => a.DurationOfLife == id);

			//if (animal == null)
			//{
			//	return NotFound();
			//}

			//return View(animal);
		}

		// POST: Phones/Edit/5
		[HttpPost]
		[ValidateAntiForgeryToken]
		public ActionResult Edit(int id, IFormCollection collection)
		{
			return NotFound();
			//try
			//{
			//	double weight = double.Parse(collection["Weight"], CultureInfo.InvariantCulture);
			//	string color = collection["Color"];

			//	_editService.EditAnimal(id, weight, color);

			//	return RedirectToAction(nameof(Index));
			//}
			//catch
			//{
			//	return View();
			//}
		}

		// GET: Phones/Delete/5
		public ActionResult Delete(int id)
		{
			return NotFound();
			//var animal = _searchService.GetAnimals()
			//	.FirstOrDefault(a => a.DurationOfLife == id);

			//if (animal == null)
			//{
			//	return NotFound();
			//}

			//return View(animal);
		}

		// POST: Phones/Delete/5
		[HttpPost]
		[ValidateAntiForgeryToken]
		public ActionResult Delete(int id, IFormCollection collection)
		{
			return NotFound();
			//try
			//{
			//	_deleteService.DeleteAnimal(id);

			//	return RedirectToAction(nameof(Index));
			//}
			//catch
			//{
			//	return BadRequest();
			//}
		}
	}
}