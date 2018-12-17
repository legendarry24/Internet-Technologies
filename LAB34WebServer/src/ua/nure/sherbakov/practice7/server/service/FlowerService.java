package ua.nure.sherbakov.practice7.server.service;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import ua.nure.sherbakov.practice7.entity.Flower;
import ua.nure.sherbakov.practice7.entity.Flowers;
import ua.nure.sherbakov.practice7.server.dao.DAOException;

@WebService(targetNamespace = "http://practice7.sherbakov.nure.ua/server/service")
public interface FlowerService {

	@WebMethod()
	@WebResult(targetNamespace = "http://practice7.sherbakov.nure.ua/entity")
	public abstract Flower getFlower(@WebParam(name = "id") int id) throws DAOException;

	@WebMethod()
	public abstract int addFlower(
			@WebParam(name = "Flowers", targetNamespace = "http://practice7.sherbakov.nure.ua/entity") Flower Flower)
			throws DAOException;

	@WebMethod()
	@WebResult(targetNamespace = "http://practice7.sherbakov.nure.ua/entity")
	public abstract Flower deleteFlower(@WebParam(name = "id") int id) throws DAOException;

	@WebMethod()
	@WebResult(targetNamespace = "http://practice7.sherbakov.nure.ua/entity")
	public abstract Collection<Flower> listFlowers();

	@WebMethod()
	@WebResult(targetNamespace = "http://practice7.sherbakov.nure.ua/entity")
	public abstract Collection<Flower> findByName(@WebParam(name = "pattern") String pattern);

	@WebMethod()
	@WebResult(targetNamespace = "http://practice7.sherbakov.nure.ua/entity")
	public abstract Collection<Flower> findByOrigin(@WebParam(name = "pattern") String pattern);

}