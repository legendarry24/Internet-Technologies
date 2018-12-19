using System.Collections.Generic;

namespace Domain.Contracts
{
	public interface IRepository<T>
	{
		IEnumerable<T> GetAll();

		T GetById(int id);

		void Add(T entity);

		void Remove(int Id);
	}
}