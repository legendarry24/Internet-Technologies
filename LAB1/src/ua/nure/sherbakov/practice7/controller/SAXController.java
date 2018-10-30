package ua.nure.sherbakov.practice7.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import ua.nure.sherbakov.practice7.constants.Constants;
import ua.nure.sherbakov.practice7.constants.XML;
import ua.nure.sherbakov.practice7.entity.Flowers;
import ua.nure.sherbakov.practice7.entity.Flower;
import ua.nure.sherbakov.practice7.entity.GrovingTips;
import ua.nure.sherbakov.practice7.entity.VisualParameters;


public class SAXController extends DefaultHandler {
	private String xmlFileName;

	public SAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	/**
	 * Parses XML document.
	 * 
	 * @param validate If true validate XML document against its XML schema. With
	 *                 this parameter it is possible make parser validating.
	 */
	public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {

		// get sax parser factory
		// this way you obtain SAX parser factory based on internal implementation
		// of the XERCES library bundled with jdk
		//
		// if you place xercesImpl.jar to application classpath the following
		// invocation:
		// SAXParserFactory.newInstance()
		// returns factory based on the external XERCES librry
		// (see xercesImpl.jar/META-INF/services/javax.xml.parsers.SAXParserFactory)
		//
		// If there is no xercesImpl.jar in classpath then
		// internal implementation of XERCES will be used automatically
		// i.e. in this case you may use the following code:
		// SAXParserFactory factory = SAXParserFactory.newInstance();

		SAXParserFactory factory = SAXParserFactory.newInstance(Constants.CLASS__SAX_PARSER_FACTORY_INTERNAL,
				this.getClass().getClassLoader());

		factory.setNamespaceAware(true);
		if (validate) {
			factory.setFeature(Constants.FEATURE__TURN_VALIDATION_ON, true);
			factory.setFeature(Constants.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);
		}

		SAXParser parser = factory.newSAXParser();
		parser.parse(xmlFileName, this);
	}

	// ///////////////////////////////////////////////////////////
	// ERROR HANDLER IMPLEMENTATION
	// ///////////////////////////////////////////////////////////

	@Override
	public void error(org.xml.sax.SAXParseException e) throws SAXException {
		throw e; // <-- if XML document not valid just throw exception
	};

	// ///////////////////////////////////////////////////////////
	// CONTENT HANDLER IMPLEMENTATION
	// ///////////////////////////////////////////////////////////

	private String currentElement; // <-- current element name holder

	private Flowers flowers; // <-- main container
	private Flower flower;
	private GrovingTips grovingTips;
	private VisualParameters visualParameters;
	
	public Flowers getFlowers() {
		return flowers;
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		currentElement = localName;

		// WARNING!!!
		// here and below we use '==' operation to compare two INTERNED STRINGS
		if (currentElement == XML.FLOWERS.value()) {
			flowers = new Flowers();
			return;
		}

		if (currentElement == XML.FLOWER.value()) {
			flower = new Flower();
			return;
		}
		
		if (currentElement == XML.VISUAL_PARAMETERS.value()) {
			visualParameters = new VisualParameters();
			return;
		}
		
		if (currentElement == XML.GROVING_TIPS.value()) {
			grovingTips = new GrovingTips();
			return;
		}

	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {

		String elementText = new String(ch, start, length).trim();

		if (elementText.isEmpty()) // <-- return if content is empty
			return;

		if (currentElement == XML.NAME.value()) {
			flower.setName(elementText);
			return;
		}
		
		if (currentElement == XML.SOIL.value()) {
			flower.setSoil(elementText);
			return;
		}
		
		if (currentElement == XML.ORIGIN.value()) {
			flower.setOrigin(elementText);
			return;
		}
		
		if (currentElement == XML.STALK_COLOR.value()) {
			visualParameters.setStalkColor(elementText);
			return;
		}
		
		if (currentElement == XML.COLOR_OF_LEAVES.value()) {
			visualParameters.setColorOfLeaves(elementText);
			return;
		}
		
		if (currentElement == XML.AVERAGE_PLANT_SIZE.value()) {
			visualParameters.setAveragePlantSize(Integer.parseInt(elementText));
			return;
		}
		
		if (currentElement == XML.TEMPERATURE.value()) {
			grovingTips.setTemperature(Integer.parseInt(elementText));
			return;
		}
		
		if (currentElement == XML.LIGHTING.value()) {
			grovingTips.setLighting(Boolean.parseBoolean(elementText));
			return;
		}
		
		if (currentElement == XML.WATERING.value()) {
			grovingTips.setWatering(Integer.parseInt(elementText));
			return;
		}
		
		if (currentElement == XML.MULTIPLING.value()) {
			flower.setMultipling(elementText);
			return;
		}
		
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (localName == XML.FLOWER.value()) {
			// just add question to container
			flowers.getFlowers().add(flower);
			return;
		}
		
		if (localName == XML.VISUAL_PARAMETERS.value()) {
			// just add question to container
			flower.setVisualParameters(visualParameters);
			return;
		}
		
		if (localName == XML.GROVING_TIPS.value()) {
			// just add question to container
			flower.setGrovingTips(grovingTips);
			return;
		}
	}

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		// try to parse valid XML file (success)
		SAXController saxContr = new SAXController(Constants.VALID_XML_FILE);
		saxContr.parse(true); // <-- do parse with validation on (success)
		Flowers flowers = saxContr.getFlowers(); // <-- obtain container

		// we have Test object at this point:
		System.out.println("====================================");
		System.out.print("Here is the flowers: \n" + flowers);
		System.out.println("====================================");

		// now try to parse NOT valid XML (failed)
		/*saxContr = new SAXController(Constants.INVALID_XML_FILE);
		try {
			saxContr.parse(true); // <-- do parse with validation on (failed)
		} catch (Exception ex) {
			System.err.println("====================================");
			System.err.println("Validation is failed:\n" + ex.getMessage());
			System.err.println("Try to print test object:" + saxContr.getFlowers());
			System.err.println("====================================");
		}

		// and now try to parse NOT valid XML with validation off (success)
		saxContr.parse(false); // <-- do parse with validation off (success)

		// we have Test object at this point:
		System.out.println("====================================");
		System.out.print("Here is the flowers: \n" + saxContr.getFlowers());
		System.out.println("====================================");*/
	}
}
