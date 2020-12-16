package entity;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class that represents a monster.
 */
public class Monster {

	@JsonProperty("hit_points")
	private int hitPoints;

	@JsonProperty("constitution")
	private int constitution;

	@JsonProperty("strength")
	private int strength;

	@JsonProperty("condition_immunities")
	private List<ConditionImmunitiesItem> conditionImmunities;

	@JsonProperty("senses")
	private Senses senses;

	@JsonProperty("challenge_rating")
	private int challengeRating;

	@JsonProperty("type")
	private String type;

	@JsonProperty("speed")
	private Speed speed;

	@JsonProperty("charisma")
	private int charisma;

	@JsonProperty("wisdom")
	private int wisdom;

	@JsonProperty("damage_resistances")
	private List<String> damageResistances;

	@JsonProperty("armor_class")
	private int armorClass;

	@JsonProperty("subtype")
	private String subtype;

	@JsonProperty("proficiencies")
	private List<ProficienciesItem> proficiencies;

	@JsonProperty("hit_dice")
	private String hitDice;

	@JsonProperty("special_abilities")
	private List<SpecialAbilitiesItem> specialAbilities;

	@JsonProperty("languages")
	private String languages;

	@JsonProperty("index")
	private String index;

	@JsonProperty("damage_immunities")
	private List<String> damageImmunities;

	@JsonProperty("damage_vulnerabilities")
	private List<Object> damageVulnerabilities;

	@JsonProperty("url")
	private String url;

	@JsonProperty("intelligence")
	private int intelligence;

	@JsonProperty("dexterity")
	private int dexterity;

	@JsonProperty("size")
	private String size;

	@JsonProperty("name")
	private String name;

	@JsonProperty("xp")
	private int xp;

	@JsonProperty("alignment")
	private String alignment;

	@JsonProperty("actions")
	private List<ActionsItem> actions;

	public int getHitPoints(){
		return hitPoints;
	}

	public int getConstitution(){
		return constitution;
	}

	public int getStrength(){
		return strength;
	}

	public List<ConditionImmunitiesItem> getConditionImmunities(){
		return conditionImmunities;
	}

	public Senses getSenses(){
		return senses;
	}

	public int getChallengeRating(){
		return challengeRating;
	}

	public String getType(){
		return type;
	}

	public Speed getSpeed(){
		return speed;
	}

	public int getCharisma(){
		return charisma;
	}

	public int getWisdom(){
		return wisdom;
	}

	public List<String> getDamageResistances(){
		return damageResistances;
	}

	public int getArmorClass(){
		return armorClass;
	}

	public String getSubtype(){
		return subtype;
	}

	public List<ProficienciesItem> getProficiencies(){
		return proficiencies;
	}

	public String getHitDice(){
		return hitDice;
	}

	public List<SpecialAbilitiesItem> getSpecialAbilities(){
		return specialAbilities;
	}

	public String getLanguages(){
		return languages;
	}

	public String getIndex(){
		return index;
	}

	public List<String> getDamageImmunities(){
		return damageImmunities;
	}

	public List<Object> getDamageVulnerabilities(){
		return damageVulnerabilities;
	}

	public String getUrl(){
		return url;
	}

	public int getIntelligence(){
		return intelligence;
	}

	public int getDexterity(){
		return dexterity;
	}

	public String getSize(){
		return size;
	}

	public String getName(){
		return name;
	}

	public int getXp(){
		return xp;
	}

	public String getAlignment(){
		return alignment;
	}

	public List<ActionsItem> getActions(){
		return actions;
	}
}