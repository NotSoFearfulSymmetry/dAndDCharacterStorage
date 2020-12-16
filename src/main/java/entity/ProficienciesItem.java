package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProficienciesItem{

	@JsonProperty("value")
	private int value;

	@JsonProperty("proficiency")
	private Proficiency proficiency;

	public int getValue(){
		return value;
	}

	public Proficiency getProficiency(){
		return proficiency;
	}
}