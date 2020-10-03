package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class that represents a Dungeons & Dragons character
 *
 * @author Simon Powers-Schaub
 */
@Entity(name = "Character")
@Table(name = "character")
public class Character {

    @Column(name = "name")
    private String name;

    @Column(name = "race")
    private String race;

    @Column(name = "gender")
    private String gender;

    @Column(name = "class_and_level")
    private String classAndLevel;

    @Column(name = "strength")
    private int strength;

    @Column(name = "dexterity")
    private int dexterity;

    @Column(name = "constitution")
    private int constitution;

    @Column(name = "intelligence")
    private int intelligence;

    @Column(name = "wisdom")
    private int wisdom;

    @Column(name = "charisma")
    private int charisma;

    @Column(name = "hit_points")
    private int hitPoints;

    @Column(name = "skills")
    private String skills;

    @Column(name = "feats")
    private String feats;

    @Column(name = "class_features")
    private String classFeatures;

    @Column(name = "equipment")
    private String equipment;

    @Column(name = "description")
    private String description;

    @Column(name = "background")
    private String background;

    @Column(name = "second_user_access")
    private boolean secondUserAccess;

    @Column(name = "second_user_name")
    private String secondUserName;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    /**
     * Gets name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets race
     * @return the race
     */
    public String getRace() {
        return race;
    }

    /**
     * Sets race
     * @param race the race
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     * Gets gender
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets class and level
     * @return the class and level
     */
    public String getClassAndLevel() {
        return classAndLevel;
    }

    /**
     * Sets class and level
     * @param classAndLevel the class and level
     */
    public void setClassAndLevel(String classAndLevel) {
        this.classAndLevel = classAndLevel;
    }

    /**
     * Gets strength
     * @return the strength
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets strength
     * @param strength the strength
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Gets dexterity
     * @return the dexterity
     */
    public int getDexterity() {
        return dexterity;
    }

    /**
     * Sets dexterity
     * @param dexterity the dexterity
     */
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    /**
     * Gets constitution
     * @return the constitution
     */
    public int getConstitution() {
        return constitution;
    }

    /**
     * Sets constitution
     * @param constitution the constitution
     */
    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    /**
     * Gets intelligence
     * @return the intelligence
     */
    public int getIntelligence() {
        return intelligence;
    }

    /**
     * Sets intelligence
     * @param intelligence the intelligence
     */
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    /**
     * Gets wisdom
     * @return the wisdom
     */
    public int getWisdom() {
        return wisdom;
    }

    /**
     * Sets wisdom
     * @param wisdom the wisdom
     */
    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }

    /**
     * Gets charisma
     * @return the charisma
     */
    public int getCharisma() {
        return charisma;
    }

    /**
     * Sets charisma
     * @param charisma the charisma
     */
    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    /**
     * Gets hit points
     * @return the hit points
     */
    public int getHitPoints() {
        return hitPoints;
    }

    /**
     * Sets hit points
     * @param hitPoints the hit points
     */
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /**
     * Gets skills
     * @return the skills
     */
    public String getSkills() {
        return skills;
    }

    /**
     * Sets skills
     * @param skills the skills
     */
    public void setSkills(String skills) {
        this.skills = skills;
    }

    /**
     * Gets feats
     * @return the feats
     */
    public String getFeats() {
        return feats;
    }

    /**
     * Sets feats
     * @param feats the feats
     */
    public void setFeats(String feats) {
        this.feats = feats;
    }

    /**
     * Gets class features
     * @return the class features
     */
    public String getClassFeatures() {
        return classFeatures;
    }

    /**
     * Sets class features
     * @param classFeatures the class features
     */
    public void setClassFeatures(String classFeatures) {
        this.classFeatures = classFeatures;
    }

    /**
     * Gets equipment
     * @return the equipment
     */
    public String getEquipment() {
        return equipment;
    }

    /**
     * Sets equipment
     * @param equipment the equipment
     */
    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    /**
     * Gets description
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets background
     * @return the background
     */
    public String getBackground() {
        return background;
    }

    /**
     * Sets background
     * @param background the background
     */
    public void setBackground(String background) {
        this.background = background;
    }

    /**
     * Gets second account permission status
     * @return the second account permission status
     */
    public boolean isSecondUserAccess() {
        return secondUserAccess;
    }

    /**
     * Sets second account permission status
     * @param secondUserAccess the second account permission status
     */
    public void setSecondUserAccess(boolean secondUserAccess) {
        this.secondUserAccess = secondUserAccess;
    }

    /**
     * Gets second account name, if applicable
     * @return the second account name
     */
    public String getSecondUserName() {
        return secondUserName;
    }

    /**
     * Sets second account name, if applicable
     * @param secondUserName the second account name
     */
    public void setSecondUserName(String secondUserName) {
        this.secondUserName = secondUserName;
    }

    /**
     * Gets ID
     * @return the ID
     */
    public int getId() {
        return id;
    }

    /**
     * Sets ID
     * @param id the ID
     */
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", classAndLevel='" + classAndLevel + '\'' +
                ", strength='" + strength + '\'' +
                ", dexterity='" + dexterity + '\'' +
                ", constitution='" + constitution + '\'' +
                ", intelligence='" + intelligence + '\'' +
                ", wisdom='" + wisdom + '\'' +
                ", charisma='" + charisma + '\'' +
                ", hitPoints='" + hitPoints + '\'' +
                ", skills='" + skills + '\'' +
                ", feats='" + feats + '\'' +
                ", classFeatures='" + classFeatures + '\'' +
                ", equipment='" + equipment + '\'' +
                ", description='" + description + '\'' +
                ", background='" + background + '\'' +
                ", secondUserAccess='" + secondUserAccess + '\'' +
                ", secondUserName='" + secondUserName + '\'' +
                ", id=" + id +
                '}';
    }
}