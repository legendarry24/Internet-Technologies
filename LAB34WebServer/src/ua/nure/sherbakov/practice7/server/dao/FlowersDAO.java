package ua.nure.sherbakov.practice7.server.dao;

import java.math.BigDecimal;
import java.util.Collection;

import ua.nure.sherbakov.practice7.entity.Flower;

public interface FlowersDAO {
	/**
	 * Add a Flowers to order
	 * 
	 * @param Flowers
	 * @return
	 * @throws DAOException
	 */
	public int addFlower(Flower item) throws DAOException;

	/**
	 * Add a Flowers to order
	 * 
	 * @param Flowers
	 * @return
	 * @throws DAOException
	 */
	public Flower deleteFlower(int id) throws DAOException;

	/**
	 * Add a Flowers to order
	 * 
	 * @param Flower
	 * @return
	 * @throws DAOException
	 */
	public boolean updateFlowerPrice(int id, BigDecimal price) throws DAOException;

	/**
	 * Find Flower with patter in the order
	 * 
	 * @param name
	 * @return
	 */
	public Collection<Flower> findByName(String pattern);

	/**
	 * Find Flowers with pattern author in the order
	 * 
	 * @param name
	 * @return
	 */
	public Collection<Flower> findByOrigin(String pattern);

	/**
	 * 
	 * @return All Flowers in order
	 */
	public Collection<Flower> listFlowers();

	public Flower findById(Integer id) throws DAOException;

}
