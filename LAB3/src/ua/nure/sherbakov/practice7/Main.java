package ua.nure.sherbakov.practice7;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.TransformerException;

import org.xml.sax.SAXException;

import ua.nure.sherbakov.practice7.constants.Constants;
import ua.nure.sherbakov.practice7.controller.DOMController;
import ua.nure.sherbakov.practice7.controller.SAXController;
import ua.nure.sherbakov.practice7.controller.STAXController;
import ua.nure.sherbakov.practice7.entity.Flowers;
import ua.nure.sherbakov.practice7.util.Sorter;

public class Main {

	public static void usage() {
		System.out.println("java ua.nure.sherbakov.practice7 input.xml");
	}

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException, TransformerException {
		if (args.length != 1) {
			usage();
			System.out.println(args[0]);
			return;
		}
		String xmlFileName = args[0];
		System.out.println("Input ==> " + xmlFileName);

		////////////////////////////////////////////////////////
		// DOM
		////////////////////////////////////////////////////////

		// get
		DOMController domController = new DOMController(xmlFileName);
		domController.parse(true);
		Flowers flowers = domController.getFlowers();

		// sort (case 1)
		Sorter.sortFlowersByMultipling(flowers);

		// save
		DOMController.saveXML(flowers, Constants.OUTPUT_DOM_XML_FILE);
		System.out.println("Output ==> " + Constants.OUTPUT_DOM_XML_FILE);

		////////////////////////////////////////////////////////
		// SAX
		////////////////////////////////////////////////////////

		// get
		SAXController saxController = new SAXController(xmlFileName);
		saxController.parse(true);
		flowers = saxController.getFlowers();


		// save

		// other way:
		DOMController.saveXML(flowers, Constants.OUTPUT_SAX_XML_FILE);
		System.out.println("Output ==> " + Constants.OUTPUT_SAX_XML_FILE);

		////////////////////////////////////////////////////////
		// STAX
		////////////////////////////////////////////////////////

		// get
		STAXController staxController = new STAXController(xmlFileName);
		staxController.parse();
		flowers = staxController.getFlowers();

		// sort (case 3)
		Sorter.sortFlowersByGrovingTipsTemperature(flowers);

		// save
		DOMController.saveXML(flowers, Constants.OUTPUT_STAX_XML_FILE);
		System.out.println("Output ==> " + Constants.OUTPUT_STAX_XML_FILE);

	}

}
