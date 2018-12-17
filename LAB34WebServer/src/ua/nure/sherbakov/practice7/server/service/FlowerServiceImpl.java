package ua.nure.sherbakov.practice7.server.service;

import java.util.Collection;

import javax.jws.WebService;

import ua.nure.sherbakov.practice7.entity.Flower;
import ua.nure.sherbakov.practice7.server.dao.DAOException;
import ua.nure.sherbakov.practice7.server.dao.FlowerDAOInMemoryImpl;
import ua.nure.sherbakov.practice7.server.dao.FlowersDAO;

@WebService(serviceName = "Flowers", portName = "FlowerPort", endpointInterface = "ua.nure.sherbakov.practice7.server.service.FlowerService", targetNamespace = "http://practice7.sherbakov.nure.ua/server/service")
public class FlowerServiceImpl implements FlowerService {
	private static FlowersDAO flowerDao = FlowerDAOInMemoryImpl.instance();

	@Override
	public Collection<Flower> findByName(String pattern) {
		return flowerDao.findByName(pattern);
	}

	@Override
	public Collection<Flower> findByOrigin(String pattern) {
		return flowerDao.findByOrigin(pattern);
	}

	@Override
	public Flower getFlower(int id) throws DAOException {
		return flowerDao.findById(id);
	}

	@Override
	public Collection<Flower> listFlowers() {
		return flowerDao.listFlowers();
	}

	@Override
	public int addFlower(Flower flower) throws DAOException {
		return flowerDao.addFlower(flower);
	}

	@Override
	public Flower deleteFlower(int id) throws DAOException {
		return flowerDao.deleteFlower(id);
	}

}
