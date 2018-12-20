using Domain.Contracts;
using Domain.Models;
using Microsoft.AspNetCore.Mvc;

namespace WebService.RESTful.ApiControllers
{
	[Produces("application/json")]
	[Route("api/[controller]")]
	[ApiController]
	public class PhonesController : ControllerBase
	{
		private readonly IUnitOfWork _unitOfWork;

		public PhonesController(IUnitOfWork unitOfWork)
		{
			_unitOfWork = unitOfWork;
		}

		// GET api/phones
		[HttpGet]
		public IActionResult GetPhones()
		{
			var phones = _unitOfWork.PhoneRepository.GetAll();

			return Ok(phones);
		}

		// GET api/phones/cheapest
		[HttpGet("Cheapest")]
		public IActionResult GetTheCheapestPhones()
		{
			var phones = _unitOfWork.PhoneRepository.GetTheCheapestPhones();

			return Ok(phones);
		}

		// GET api/phones/5
		[HttpGet("{id}")]
		public IActionResult GetPhone(int id)
		{
			var phone = _unitOfWork.PhoneRepository.GetById(id);

			if (phone == null)
			{
				return NotFound();
			}

			return Ok(phone);
		}

		// POST api/phones
		[HttpPost]
		public IActionResult CreatePhone([FromBody] Phone phone)
		{
			if (phone == null)
			{
				return BadRequest();
			}

			_unitOfWork.PhoneRepository.Add(phone);
			_unitOfWork.Save();

			return CreatedAtAction(nameof(GetPhone), new {id = phone.Id}, phone);
		}

		// PUT api/phones/5
		[HttpPut("{id}")]
		public IActionResult UpdatePhone(int id, [FromBody] Phone phone)
		{
			if (phone == null)
			{
				return BadRequest();
			}

			var phoneEntity = _unitOfWork.PhoneRepository.GetById(id);
			if (phoneEntity == null)
			{
				return NotFound();
			}

			phoneEntity.Manufacturer = phone.Manufacturer;
			phoneEntity.Model = phone.Model;
			phoneEntity.Price = phone.Price;

			_unitOfWork.Save();

			return NoContent();
		}

		// DELETE api/phones/5
		[HttpDelete("{id}")]
		public IActionResult DeletePhone(int id)
		{
			var phoneEntity = _unitOfWork.PhoneRepository.GetById(id);
			if (phoneEntity == null)
			{
				return NotFound();
			}

			_unitOfWork.PhoneRepository.Remove(id);
			_unitOfWork.Save();

			return NoContent();
		}
	}
}
