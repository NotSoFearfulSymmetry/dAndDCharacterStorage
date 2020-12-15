package entity;

/**
 * A cless representing a D&D monster.
 */
public class Monster {

    private String index;
    private String name;
    private String url;

    /**
     * Empty constructor.
     */
    public Monster() {

    }

    /**
     * Constructs a monster with parameters.
     * @param index the index
     * @param name the name
     * @param url the URL
     */
    public Monster(String index, String name, String url) {
        this.index = index;
        this.name = name;
        this.url = url;
    }

    /**
     * Gets the index
     * @return the index
     */
    public String getIndex() {
        return index;
    }

    /**
     * Sets the index
     * @param index the index
     */
    public void setIndex(String index) {
        this.index = index;
    }

    /**
     * Gets the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the URL
     * @return the URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the URL
     * @param url the URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}