package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Usage{

	@JsonProperty("times")
	private int times;

	@JsonProperty("type")
	private String type;

	public int getTimes(){
		return times;
	}

	public String getType(){
		return type;
	}
}