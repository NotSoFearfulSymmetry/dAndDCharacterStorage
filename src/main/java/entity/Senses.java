package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Senses{

	@JsonProperty("truesight")
	private String truesight;

	@JsonProperty("passive_perception")
	private int passivePerception;

	public String getTruesight(){
		return truesight;
	}

	public int getPassivePerception(){
		return passivePerception;
	}
}