package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Speed{

	@JsonProperty("fly")
	private String fly;

	@JsonProperty("walk")
	private String walk;

	public String getFly(){
		return fly;
	}

	public String getWalk(){
		return walk;
	}
}