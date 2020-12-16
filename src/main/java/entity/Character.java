package entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * A class that represents a Dungeons & Dragons character
 *
 * @author Simon Powers-Schaub
 */
@Entity(name = "Character")
@Table(name = "dnd_character")
public class Character {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

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

    @Column(name = "second_username")
    private String secondUsername;

    /**
     * Bidirectional @OneToMany
     */
    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    /**
     * Constructor without arguments
     */
    public Character() {

    }

    /**
     * Constructor with arguments
     * @param name the name
     * @param race the race
     * @param gender the gender
     * @param classAndLevel the class and level
     * @param strength the strength
     * @param dexterity the dexterity
     * @param constitution the constitution
     * @param intelligence the intelligence
     * @param wisdom the wisdom
     * @param charisma the charisma
     * @param hitPoints the hit points
     * @param skills the skills
     * @param feats the feats
     * @param classFeatures the class features
     * @param equipment the equipment
     * @param description the description
     * @param background the background
     * @param secondUserAccess whether a second user has access
     * @param secondUsername the secondary user, if any
     * @param user the main user
     */
    public Character(String name, String race, String gender, String classAndLevel, int strength, int dexterity, int constitution, int intelligence, int wisdom, int charisma, int hitPoints, String skills, String feats, String classFeatures, String equipment, String description, String background, boolean secondUserAccess, String secondUsername, User user) {
        this.name = name;
        this.race = race;
        this.gender = gender;
        this.classAndLevel = classAndLevel;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.hitPoints = hitPoints;
        this.skills = skills;
        this.feats = feats;
        this.classFeatures = classFeatures;
        this.equipment = equipment;
        this.description = description;
        this.background = background;
        this.secondUserAccess = secondUserAccess;
        this.secondUsername = secondUsername;
        this.user = user;
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
    public String getSecondUsername() {
        return secondUsername;
    }

    /**
     * Sets second account name, if applicable
     * @param secondUsername the second account name
     */
    public void setSecondUsername(String secondUsername) {
        this.secondUsername = secondUsername;
    }

    /**
     * Gets a User
     * @return the User
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets a User
     * @param user the User
     */
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", race='" + race + '\'' +
                ", gender='" + gender + '\'' +
                ", classAndLevel='" + classAndLevel + '\'' +
                ", strength=" + strength +
                ", dexterity=" + dexterity +
                ", constitution=" + constitution +
                ", intelligence=" + intelligence +
                ", wisdom=" + wisdom +
                ", charisma=" + charisma +
                ", hitPoints=" + hitPoints +
                ", skills='" + skills + '\'' +
                ", feats='" + feats + '\'' +
                ", classFeatures='" + classFeatures + '\'' +
                ", equipment='" + equipment + '\'' +
                ", description='" + description + '\'' +
                ", background='" + background + '\'' +
                ", secondUserAccess=" + secondUserAccess +
                ", secondUsername='" + secondUsername + '\'' +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return id == character.id &&
                strength == character.strength &&
                dexterity == character.dexterity &&
                constitution == character.constitution &&
                intelligence == character.intelligence &&
                wisdom == character.wisdom &&
                charisma == character.charisma &&
                hitPoints == character.hitPoints &&
                secondUserAccess == character.secondUserAccess &&
                Objects.equals(name, character.name) &&
                Objects.equals(race, character.race) &&
                Objects.equals(gender, character.gender) &&
                Objects.equals(classAndLevel, character.classAndLevel) &&
                Objects.equals(skills, character.skills) &&
                Objects.equals(feats, character.feats) &&
                Objects.equals(classFeatures, character.classFeatures) &&
                Objects.equals(equipment, character.equipment) &&
                Objects.equals(description, character.description) &&
                Objects.equals(background, character.background) &&
                Objects.equals(secondUsername, character.secondUsername) &&
                Objects.equals(user, character.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, race, gender, classAndLevel, strength, dexterity, constitution, intelligence, wisdom, charisma, hitPoints, skills, feats, classFeatures, equipment, description, background, secondUserAccess, secondUsername, user);
    }
}