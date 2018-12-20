using System.Globalization;
using System.Threading.Tasks;
using Domain.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using WebClient.Services;

namespace WebClient.MvcControllers
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
			var filter = collection["id"];

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
			return View();
		}

		// POST: Phones/Create
		[HttpPost]
		[ValidateAntiForgeryToken]
		public async Task<ActionResult> Create(IFormCollection collection)
		{
			if (!decimal.TryParse(collection["Price"], NumberStyles.Currency, CultureInfo.InvariantCulture, out decimal price))
			{
				return BadRequest();
			}

			if (!ModelState.IsValid)
			{
				return BadRequest(ModelState);
			}

			var phone = new Phone
			{
				Manufacturer = collection["Manufacturer"],
				Model = collection["Model"],
				Price = price
			};

			await _addService.CreatePhoneAsync(phone);

			return RedirectToAction(nameof(Index));
		}

		// GET: Phones/Edit/5
		public async Task<ActionResult> Edit(int id)
		{
			var phone = await _searchService.GetPhoneByIdAsync(id);

			if (phone == null)
			{
				return NotFound();
			}

			return View(phone);
		}

		// POST: Phones/Edit/5
		[HttpPost]
		[ValidateAntiForgeryToken]
		public async Task<ActionResult> Edit(int id, IFormCollection collection)
		{
			var phone = await _searchService.GetPhoneByIdAsync(id);

			if (phone == null)
			{
				return NotFound();
			}

			if (!ModelState.IsValid)
			{
				return BadRequest(ModelState);
			}

			if (!decimal.TryParse(collection["Price"], NumberStyles.Currency, CultureInfo.InvariantCulture, out decimal price))
			{
				return View();
			}

			phone.Manufacturer = collection["Manufacturer"];
			phone.Model = collection["Model"];
			phone.Price = price;

			await _editService.UpdatePhoneAsync(phone);

			return RedirectToAction(nameof(Index));
		}

		// GET: Phones/Delete/5
		public async Task<ActionResult> Delete(int id)
		{
			var phone = await _searchService.GetPhoneByIdAsync(id);

			if (phone == null)
			{
				return NotFound();
			}

			return View(phone);
		}

		// POST: Phones/Delete/5
		[HttpPost]
		[ValidateAntiForgeryToken]
		public async Task<ActionResult> Delete(int id, IFormCollection collection)
		{
			var phone = await _searchService.GetPhoneByIdAsync(id);

			if (phone == null)
			{
				return NotFound();
			}

			await _deleteService.DeletePhoneAsync(id);

			return RedirectToAction(nameof(Index));
		}
	}
}