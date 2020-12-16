package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FromItemItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("count")
	private int count;

	@JsonProperty("type")
	private String type;

	public String getName(){
		return name;
	}

	public int getCount(){
		return count;
	}

	public String getType(){
		return type;
	}
}