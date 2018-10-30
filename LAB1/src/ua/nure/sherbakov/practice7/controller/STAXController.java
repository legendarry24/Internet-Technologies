package ua.nure.sherbakov.practice7.controller;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stream.StreamSource;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.sherbakov.practice7.constants.Constants;
import ua.nure.sherbakov.practice7.constants.XML;
import ua.nure.sherbakov.practice7.entity.Flowers;
import ua.nure.sherbakov.practice7.entity.Flower;
import ua.nure.sherbakov.practice7.entity.GrovingTips;
import ua.nure.sherbakov.practice7.entity.VisualParameters;

public class STAXController extends DefaultHandler {
	private String xmlFileName;

	private Flowers flowers; // <-- main container

	public Flowers getFlowers() {
		return flowers;
	}

	public STAXController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	/**
	 * Parses XML document with StAX API. There is no validation during the parsing.
	 */
	public void parse() throws ParserConfigurationException, SAXException, IOException, XMLStreamException {
		Flower flower = null;
		GrovingTips grovingTips = null;
		VisualParameters visualParameters = null;
		String currentElement = null; // <-- current element name holder

		XMLInputFactory factory = XMLInputFactory.newInstance();

		factory.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, true);

		XMLEventReader reader = factory.createXMLEventReader(new StreamSource(xmlFileName));

		while (reader.hasNext()) {
			XMLEvent event = reader.nextEvent();

			// skip any empty content
			if (event.isCharacters() && event.asCharacters().isWhiteSpace())
				continue;

			// handler for start tags
			if (event.isStartElement()) {
				StartElement startElement = event.asStartElement();
				currentElement = startElement.getName().getLocalPart();

				// WARNING!!!
				// here and below we use '==' operation to compare two INTERNED STRINGS
				if (currentElement == XML.FLOWERS.value()) {
					flowers = new Flowers();
					continue;
				}

				if (currentElement == XML.FLOWER.value()) {
					flower = new Flower();
					continue;
				}

				if (currentElement == XML.GROVING_TIPS.value()) {
					grovingTips = new GrovingTips();
					continue;
				}

				if (currentElement == XML.VISUAL_PARAMETERS.value()) {
					visualParameters = new VisualParameters();
					continue;
				}

			}

			// handler for contents
			if (event.isCharacters()) {
				Characters characters = event.asCharacters();
				String elementText = characters.getData();

				if (currentElement == XML.NAME.value()) {
					flower.setName(elementText);
					continue;
				}

				if (currentElement == XML.SOIL.value()) {
					flower.setSoil(elementText);
					continue;
				}

				if (currentElement == XML.ORIGIN.value()) {
					flower.setOrigin(elementText);
					continue;
				}

				if (currentElement == XML.STALK_COLOR.value()) {
					visualParameters.setStalkColor(elementText);
					continue;
				}

				if (currentElement == XML.COLOR_OF_LEAVES.value()) {
					visualParameters.setColorOfLeaves(elementText);
					continue;
				}

				if (currentElement == XML.AVERAGE_PLANT_SIZE.value()) {
					visualParameters.setAveragePlantSize(Integer.parseInt(elementText));
					continue;
				}

				if (currentElement == XML.TEMPERATURE.value()) {
					grovingTips.setTemperature(Integer.parseInt(elementText));
					continue;
				}

				if (currentElement == XML.LIGHTING.value()) {
					grovingTips.setLighting(Boolean.parseBoolean(elementText));
					continue;
				}

				if (currentElement == XML.WATERING.value()) {
					grovingTips.setWatering(Integer.parseInt(elementText));
					continue;
				}

				if (currentElement == XML.MULTIPLING.value()) {
					flower.setMultipling(elementText);
					continue;
				}

			}

			// handler for end tags
			if (event.isEndElement()) {
				EndElement endElement = event.asEndElement();
				String localName = endElement.getName().getLocalPart();

				if (localName == XML.FLOWER.value()) {
					// just add question to container
					flowers.getFlowers().add(flower);
				}

				if (localName == XML.VISUAL_PARAMETERS.value()) {
					// just add question to container
					flower.setVisualParameters(visualParameters);
				}

				if (localName == XML.GROVING_TIPS.value()) {
					// just add question to container
					flower.setGrovingTips(grovingTips);
				}
			}
		}
		reader.close();
	}

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XMLStreamException {

		// try to parse (valid) XML file (success)
		STAXController staxContr = new STAXController(Constants.VALID_XML_FILE);
		staxContr.parse(); // <-- do parse (success)

		Flowers flowers = staxContr.getFlowers(); // <-- obtain container

		// we have Test object at this point:
		System.out.println("====================================");
		System.out.print("Here is the flowers: \n" + flowers);
		System.out.println("====================================");
	}
}
