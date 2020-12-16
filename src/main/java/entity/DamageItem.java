package entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DamageItem{

	@JsonProperty("damage_type")
	private DamageType damageType;

	@JsonProperty("damage_dice")
	private String damageDice;

	public DamageType getDamageType(){
		return damageType;
	}

	public String getDamageDice(){
		return damageDice;
	}
}