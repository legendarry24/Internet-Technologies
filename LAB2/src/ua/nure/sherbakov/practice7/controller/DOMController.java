package ua.nure.sherbakov.practice7.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import ua.nure.sherbakov.practice7.constants.Constants;
import ua.nure.sherbakov.practice7.constants.XML;
import ua.nure.sherbakov.practice7.entity.Flowers;
import ua.nure.sherbakov.practice7.entity.Flower;
import ua.nure.sherbakov.practice7.entity.GrovingTips;
import ua.nure.sherbakov.practice7.entity.Multipling;
import ua.nure.sherbakov.practice7.entity.VisualParameters;
import ua.nure.sherbakov.practice7.util.Transformer;

public class DOMController {

	private String xmlFileName;

	private Flowers flowers; // <-- container

	public DOMController(String xmlFileName) {
		this.xmlFileName = xmlFileName;
	}

	public Flowers getFlowers() {
		return flowers;
	}

	/**
	 * Parses XML document.
	 * 
	 * @param validate If true validate XML document against its XML schema.
	 */
	public void parse(boolean validate) throws ParserConfigurationException, SAXException, IOException {

		// obtain DOM parser

		// get document builder factory
		// this way you obtain DOM analyzer based on internal implementation
		// of the XERCES library bundled with jdk
		//
		// if you place xercesImpl.jar to application classpath the following
		// invocation:
		// DocumentBuilderFactory.newInstance()
		// returns factory based on the external XERCES library.
		// (see
		// xercesImpl.jar/META-INF/services/javax.xml.parsers.DocumentBuilderFactory)
		//
		// if there is no xercesImpl.jar in classpath then
		// internal implementation of XERCES will be used automatically
		// i.e. in this case you may use the following code:
		// DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilderFactory dbf = DocumentBuilderFactory
				.newInstance(Constants.CLASS__DOCUMENT_BUILDER_FACTORY_INTERNAL, this.getClass().getClassLoader());

		// set properties for Factory
		dbf.setNamespaceAware(true); // <-- XML document has namespace
		if (validate) { // <-- make parser validating
			dbf.setFeature(Constants.FEATURE__TURN_VALIDATION_ON, true);
			dbf.setFeature(Constants.FEATURE__TURN_SCHEMA_VALIDATION_ON, true);
		}

		DocumentBuilder db = dbf.newDocumentBuilder();

		db.setErrorHandler(new DefaultHandler() {
			@Override
			public void error(SAXParseException e) throws SAXException {
				throw e; // <-- throw exception if XML document is NOT valid
			}
		});

		Document document = db.parse(xmlFileName); // <-- parse XML document
		Element root = document.getDocumentElement(); // <-- get root element

		// create container
		flowers = new Flowers();

		NodeList flowerNodes = root.getElementsByTagName(XML.FLOWER.value());

		for (int j = 0; j < flowerNodes.getLength(); j++) {
			Flower flower = getFlower(flowerNodes.item(j));
			flowers.getFlowers().add(flower); // <-- add question to container
		}
	}

	/**
	 * Extracts question object from the question XML node.
	 * 
	 * @param fNode Question node.
	 * @return Question object.
	 */

	private Flower getFlower(Node fNode) {
		Flower flower = new Flower();
		Element fElement = (Element) fNode;

		String id = fElement.getAttribute(XML.ID.value());
		flower.setId(Integer.parseInt(id)); // <-- set correct

		String soil = fElement.getAttribute(XML.SOIL.value());
		flower.setSoil(soil); // <-- set correct

		// process question text
		Node nNode = fElement.getElementsByTagName(XML.NAME.value()).item(0);

		// set question text
		flower.setName(nNode.getTextContent());

		Node oNode = fElement.getElementsByTagName(XML.ORIGIN.value()).item(0);

		flower.setOrigin(oNode.getTextContent());

		flower.setVisualParameters(
				getVisualParameters(fElement.getElementsByTagName(XML.VISUAL_PARAMETERS.value()).item(0)));

		flower.setGrovingTips(getGrovingTips(fElement.getElementsByTagName(XML.GROVING_TIPS.value()).item(0)));

		Node mNode = fElement.getElementsByTagName(XML.MULTIPLING.value()).item(0);

		flower.setMultipling(Multipling.fromValue(mNode.getTextContent()));

		Node pNode = fElement.getElementsByTagName(XML.PRICE.value()).item(0);

		double price = Double.parseDouble(pNode.getTextContent());

		flower.setPrice(BigDecimal.valueOf(price));

		return flower;
	}

	/**
	 * Saves Flowers object in XML file (through DOM).
	 * 
	 * @param flower      Flowers object to be saved.
	 * @param xmlFileName Output xml file name.
	 */

	public static void saveXML(Flowers flower, String xmlFileName)
			throws ParserConfigurationException, TransformerException {

		// obtain DOM parser

		// get document builder factory
		// this way you obtain DOM analyzer based on internal implementaion
		// of the XERCES library bundled with jdk
		//
		// if you place xercesImpl.jar to application classpath the following
		// invocation:
		// DocumentBuilderFactory.newInstance()
		// returns factory based on the external XERCES library.
		// (see
		// xercesImpl.jar/META-INF/services/javax.xml.parsers.DocumentBuilderFactory)
		//
		// if there is no xercesImpl.jar in classpath then
		// internal implementation of XERCES will be used automatically
		// i.e. in this case you may use the following code:
		// DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		DocumentBuilderFactory dbf = DocumentBuilderFactory
				.newInstance(Constants.CLASS__DOCUMENT_BUILDER_FACTORY_INTERNAL, DOMController.class.getClassLoader());

		// set properties for Factory
		dbf.setNamespaceAware(true); // <-- XML document has namespace

		DocumentBuilder db = dbf.newDocumentBuilder();
		Document document = db.newDocument();

		// this is the root element
		Element fsElement = document.createElementNS(Constants.MY_NS__URI,
				Constants.MY_NS__PREFIX + ":" + XML.FLOWERS.value());

		// set schema location
		fsElement.setAttributeNS(XMLConstants.W3C_XML_SCHEMA_INSTANCE_NS_URI, Constants.SCHEMA_LOCATION__ATTR_FQN,
				Constants.SCHEMA_LOCATION__URI);

		document.appendChild(fsElement);

		// add flowers elements
		for (Flower flowers : flower.getFlowers()) {

			// add flower
			Element fElement = document.createElement(XML.FLOWER.value());
			fsElement.appendChild(fElement);

			// add name
			Element nElement = document.createElement(XML.NAME.value());
			nElement.setTextContent(flowers.getName());
			fElement.appendChild(nElement);

			// add origin
			Element oElement = document.createElement(XML.ORIGIN.value());
			oElement.setTextContent(flowers.getOrigin());
			fElement.appendChild(oElement);

			// add visual parameter
			Element vpElement = document.createElement(XML.VISUAL_PARAMETERS.value());
			{
				if (document.getElementsByTagName(XML.STALK_COLOR.value()) != null) {
					Element scolorElement = document.createElement(XML.STALK_COLOR.value());
					scolorElement.setTextContent(flowers.getVisualParameters().getStalkColor());
					vpElement.appendChild(scolorElement);
				} else if (document.getElementsByTagName(XML.COLOR_OF_LEAVES.value()) != null) {
					Element coleavesElement = document.createElement(XML.COLOR_OF_LEAVES.value());
					coleavesElement.setTextContent(flowers.getVisualParameters().getColorOfLeaves());
					vpElement.appendChild(coleavesElement);
				} else if (document.getElementsByTagName(XML.AVERAGE_PLANT_SIZE.value()) != null) {
					Element apsizeElement = document.createElement(XML.AVERAGE_PLANT_SIZE.value());
					apsizeElement.setTextContent("" + flowers.getVisualParameters().getAveragePlantSize());
					vpElement.appendChild(apsizeElement);
				}
			}
			fElement.appendChild(vpElement);

			// add groving tips
			Element gtElement = document.createElement(XML.GROVING_TIPS.value());
			{

				Element temElement = document.createElement(XML.TEMPERATURE.value());
				temElement.setTextContent("" + flowers.getGrovingTips().getTemperature());
				gtElement.appendChild(temElement);
				fElement.appendChild(gtElement);

				Element liElement = document.createElement(XML.LIGHTING.value());
				liElement.setTextContent("" + flowers.getGrovingTips().isLighting());
				gtElement.appendChild(liElement);
				fElement.appendChild(gtElement);

				Element watElement = document.createElement(XML.WATERING.value());
				watElement.setTextContent("" + flowers.getGrovingTips().getWatering());
				gtElement.appendChild(watElement);
				fElement.appendChild(gtElement);
			}
			fElement.appendChild(gtElement);

			// add multiplying
			Element mElement = document.createElement(XML.MULTIPLING.value());
			mElement.setTextContent("" + flowers.getMultipling());
			fElement.appendChild(mElement);

			// add price
			Element pElement = document.createElement(XML.PRICE.value());
			pElement.setTextContent("" + flowers.getPrice());
			fElement.appendChild(pElement);
		}
		Transformer.saveToXML(document, xmlFileName); // DOM -> XML
	}

	/**
	 * Extracts flower object from the flower XML node.
	 * 
	 * @param vpNode Flower node.
	 * @return Flower object.
	 */

	private VisualParameters getVisualParameters(Node vpNode) {
		VisualParameters visualParameter = new VisualParameters();
		Element fElement = (Element) vpNode;

		// process correct
		if (fElement.getElementsByTagName(XML.STALK_COLOR.value()).item(0) != null) {
			Node scNode = fElement.getElementsByTagName(XML.STALK_COLOR.value()).item(0);
			visualParameter.setStalkColor(scNode.getTextContent()); // <-- set correct
			return visualParameter;
		} else if (fElement.getElementsByTagName(XML.COLOR_OF_LEAVES.value()).item(0) != null) {
			// process correct
			Node colNode = fElement.getElementsByTagName(XML.COLOR_OF_LEAVES.value()).item(0);
			visualParameter.setColorOfLeaves(colNode.getTextContent()); // <-- set correct
			return visualParameter;
		} else if (fElement.getElementsByTagName(XML.AVERAGE_PLANT_SIZE.value()).item(0) != null) {
			// process correct
			Node apsNode = fElement.getElementsByTagName(XML.AVERAGE_PLANT_SIZE.value()).item(0);
			visualParameter.setAveragePlantSize(Integer.parseInt(apsNode.getTextContent())); // <-- set correct
			return visualParameter;
		}
		return null;
	}

	private GrovingTips getGrovingTips(Node gtNode) {
		GrovingTips grovingTips = new GrovingTips();
		Element fElement = (Element) gtNode;

		// process correct
		Node tNode = fElement.getElementsByTagName(XML.TEMPERATURE.value()).item(0);
		grovingTips.setTemperature(Integer.parseInt(tNode.getTextContent())); // <-- set correct

		// process correct
		Node lNode = fElement.getElementsByTagName(XML.LIGHTING.value()).item(0);
		grovingTips.setLighting(Boolean.valueOf(lNode.getTextContent())); // <-- set correct

		// process correct
		Node wNode = fElement.getElementsByTagName(XML.WATERING.value()).item(0);
		grovingTips.setWatering(Integer.parseInt(wNode.getTextContent())); // <-- set correct

		return grovingTips;
	}

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, TransformerException {

		// try to parse NOT valid XML document with validation on (failed)
		DOMController domContr = new DOMController(Constants.VALID_XML_FILE);
		try {
			domContr.parse(false); // <-- parse with validation (failed)
		} catch (SAXException ex) {
			System.err.println("====================================");
			System.err.println("XML not valid");
			System.err.println("Flowers object --> " + domContr.getFlowers());
			System.err.println("====================================");
		}

		// try to parse NOT valid XML document with validation off (success)
		domContr.parse(false); // <-- parse with validation off (success)

		// we have Flowers object at this point:
		System.out.println("====================================");
		System.out.print("Here is the test: \n" + domContr.getFlowers());
		System.out.println("====================================");
	}
}
