package ua.nure.sherbakov.practice7.constants;

public enum XML {
	// these are tags
	FLOWERS("Flowers"), FLOWER("Flower"), NAME("Name"), SOIL("Soil"), ORIGIN("Origin"),
	VISUAL_PARAMETERS("VisualParameters"), STALK_COLOR("StalkColor"), COLOR_OF_LEAVES("ColorOfLeaves"),
	AVERAGE_PLANT_SIZE("AveragePlantSize"), GROVING_TIPS("GrovingTips"), TEMPERATURE("Temperature"),
	LIGHTING("Lighting"), WATERING("Watering"), MULTIPLING("Multipling");

	public static final String NAME_SPACE = "http://sherbakov.nure.ua/practice7/input";

	private String value;

	public String value() {
		return value;
	}

	XML(String value) {
		this.value = value.intern();
	}
}
