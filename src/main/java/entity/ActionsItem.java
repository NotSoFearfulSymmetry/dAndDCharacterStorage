package entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionsItem{

	@JsonProperty("damage")
	private List<Object> damage;

	@JsonProperty("usage")
	private Usage usage;

	@JsonProperty("name")
	private String name;

	@JsonProperty("desc")
	private String desc;

	@JsonProperty("attack_bonus")
	private int attackBonus;

	@JsonProperty("options")
	private Options options;

	public List<Object> getDamage(){
		return damage;
	}

	public Usage getUsage(){
		return usage;
	}

	public String getName(){
		return name;
	}

	public String getDesc(){
		return desc;
	}

	public int getAttackBonus(){
		return attackBonus;
	}

	public Options getOptions(){
		return options;
	}
}