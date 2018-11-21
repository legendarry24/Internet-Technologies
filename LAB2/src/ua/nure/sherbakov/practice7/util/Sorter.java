package ua.nure.sherbakov.practice7.util;

import java.util.Collections;
import java.util.Comparator;

import ua.nure.sherbakov.practice7.constants.Constants;
import ua.nure.sherbakov.practice7.controller.DOMController;
import ua.nure.sherbakov.practice7.entity.Flowers;
import ua.nure.sherbakov.practice7.entity.Flower;

public class Sorter {
	////////////////////////////////////////////////////////////
	// these are comparators
	////////////////////////////////////////////////////////////

	public static final Comparator<Flower> sortFlowersByGrovingTipsTemperature = new Comparator<Flower>() {
		@Override
		public int compare(Flower o1, Flower o2) {
			return o1.getGrovingTips().getTemperature() - o2.getGrovingTips().getTemperature();
		}
	};

	public static final Comparator<Flower> sortFlowersByMultipling = new Comparator<Flower>() {
		@Override
		public int compare(Flower o1, Flower o2) {
			return o1.getMultipling().compareTo(o2.getMultipling());
		}
	};

	////////////////////////////////////////////////////////////
	// these methods take Test object and sort it
	// with according comparator
	////////////////////////////////////////////////////////////

	public static final void sortFlowersByGrovingTipsTemperature(Flowers flower) {
		Collections.sort(flower.getFlowers(), sortFlowersByGrovingTipsTemperature);
	}

	public static final void sortFlowersByMultipling(Flowers flower) {
		Collections.sort(flower.getFlowers(), sortFlowersByMultipling);
	}

	public static void main(String[] args) throws Exception {
		// Test.xml --> Test object
		DOMController domController = new DOMController(Constants.VALID_XML_FILE);
		domController.parse(false);
		Flowers flowers = domController.getFlowers();

		System.out.println("====================================");
		System.out.println(flowers);
		System.out.println("====================================");

		System.out.println("====================================");
		Sorter.sortFlowersByGrovingTipsTemperature(flowers);
		System.out.println(flowers);
		System.out.println("====================================");

		System.out.println("====================================");
		Sorter.sortFlowersByMultipling(flowers);
		System.out.println(flowers);
	}
}