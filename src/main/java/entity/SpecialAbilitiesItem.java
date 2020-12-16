package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SpecialAbilitiesItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("desc")
	private String desc;

	@JsonProperty("damage")
	private List<DamageItem> damage;

	@JsonProperty("dc")
	private Dc dc;

	public String getName(){
		return name;
	}

	public String getDesc(){
		return desc;
	}

	public List<DamageItem> getDamage(){
		return damage;
	}

	public Dc getDc(){
		return dc;
	}
}