package ua.nure.sherbakov.practice7.server.dao;

import java.math.BigDecimal;

import java.sql.SQLException;

import java.util.Collection;

import ua.nure.sherbakov.practice7.dbtable.DBTable;
import ua.nure.sherbakov.practice7.dbtable.DBTableFabrique;
import ua.nure.sherbakov.practice7.dbtable.Filter;
import ua.nure.sherbakov.practice7.entity.Flower;
import ua.nure.sherbakov.practice7.entity.GrovingTips;
import ua.nure.sherbakov.practice7.entity.Multipling;
import ua.nure.sherbakov.practice7.entity.VisualParameters;

public class FlowerDAOInMemoryImpl implements FlowersDAO {

	DBTable<Flower> flower = DBTableFabrique.instance();

	private static FlowerDAOInMemoryImpl instance;

	private FlowerDAOInMemoryImpl() {
		initFlowers();
	}

	public static synchronized FlowerDAOInMemoryImpl instance() {
		if (instance == null) {
			instance = new FlowerDAOInMemoryImpl();
		}
		return instance;
	}

	@Override
	public synchronized int addFlower(Flower item) {
		int id = flower.insert(item);
		item.setId(id);
		try {
			flower.update(id, item);
		} catch (SQLException e) {
			// do nothing, always exist
		}
		return id;
	}

	@Override
	public synchronized Flower deleteFlower(int id) throws DAOException {
		try {
			return flower.delete(id);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	@Override
	public synchronized boolean updateFlowerPrice(int id, BigDecimal price) throws DAOException {
		Flower f;
		try {
			f = flower.get(id);
		} catch (SQLException e) {
			throw new DAOException("Not enouth flowers");
		}
		BigDecimal z = new BigDecimal("0");
		BigDecimal p = (f.getPrice()).subtract(price);
		if ((p.compareTo(z)) < 0)
			throw new DAOException("Not enouth flowers");
		f.setPrice(p);
		try {
			return flower.update(id, f);
		} catch (SQLException e) {
			throw new DAOException("Not enouth flowers");
		}
	}

	Filter titleFilter = new Filter() {
		@Override
		public boolean accept(Object pattern, Object item) {
			String p = (String) pattern;
			Flower it = (Flower) item;
			return it.getName().toUpperCase().contains(p.toUpperCase());
		}
	};

	Filter authorFilter = new Filter() {
		@Override
		public boolean accept(Object pattern, Object item) {
			String p = (String) pattern;
			Flower it = (Flower) item;
			return it.getName().toUpperCase().contains(p.toUpperCase());
		}
	};

	@Override
	public Collection<Flower> findByName(String pattern) {
		return flower.filter(pattern, titleFilter);
	}

	@Override
	public Collection<Flower> findByOrigin(String pattern) {
		return flower.filter(pattern, authorFilter);
	}

	@Override
	public Collection<Flower> listFlowers() {
		return flower.selectAll();
	}

	@Override
	public Flower findById(Integer id) throws DAOException {
		try {
			return flower.get(id);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	private Flower newFlower(String name, String origin, String soil, Multipling multipling, BigDecimal price) {
		Flower flower = new Flower();
		VisualParameters vp = new VisualParameters();
		GrovingTips gt = new GrovingTips();
		flower.setName(name);
		flower.setOrigin(origin);
		flower.setSoil(soil);
		/*
		 * vp.setStalkColor(stalkColor); flower.setVisualParameters(vp);
		 * vp.setColorOfLeaves(colorOfLeaves); flower.setVisualParameters(vp);
		 * vp.setAveragePlantSize(averagePlantSize); flower.setVisualParameters(vp);
		 * gt.setTemperature(temperature); flower.setGrovingTips(gt);
		 * gt.setWatering(watering); flower.setGrovingTips(gt);
		 * gt.setLighting(lighting); flower.setGrovingTips(gt);
		 */
		flower.setMultipling(multipling);
		flower.setPrice(price);
		return flower;
	}

	private void initFlowers() {
		Flower[] flowers = new Flower[] {
				newFlower("Rose", "Holland", "podzolic", Multipling.FECES, new BigDecimal("15.59")),
				newFlower("Hedychium", "South Asia", "wood-podzolic", Multipling.FECES, new BigDecimal("12.79")),
				newFlower("Thoren", "Asia", "unpaved", Multipling.SEEDS, new BigDecimal("16.49")),
				newFlower("Kermek", "Asia", "unpaved", Multipling.SEEDS, new BigDecimal("20.99")),
				newFlower("Abelia", "Japan", "unpaved", Multipling.FECES, new BigDecimal("17.59")) };
		for (int i = 0; i < flowers.length; i++) {
			addFlower(flowers[i]);
		}
	}
}