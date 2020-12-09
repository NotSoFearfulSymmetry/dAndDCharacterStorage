package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A class to represent a user.
 *
 * @author Simon Powers-Schaub
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int user_id;

    @Column(name = "username")
    private String userName;

    //TODO: Ask about having this as a String.
    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    /**
     * Bidirectional @OneToMany
     */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Character> characters = new HashSet<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userName the user name
     * @param password the password
     * @param email  the user's email
     */
    public User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    /**
     * Gets user name
     * @return the user name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets user name
     * @param userName the user name
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets password
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email
     * @param email the email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets ID
     * @return the ID
     */
    public int getId() {
        return user_id;
    }

    /**
     * Sets ID
     * @param user_id the ID
     */
    public void setId(int user_id) {
        this.user_id = user_id;
    }

    /**
     * Gets a set of Characters.
     * @return the Character set
     */
    public Set<Character> getCharacters() { return characters; }

    /**
     * Sets a set of Charcters.
     * @param characters the set of Characters
     */
    public void setCharacters(Set<Character> characters) { this.characters = characters; }

    /**
     * Add a character.
     *
     * @param character the character to add
     */
    public void addCharacter(Character character) {
        characters.add( character );
        character.setUser( this );
    }

    /**
     * Remove a character.
     *
     * @param character the character to remove
     */
    public void removeCharacter(Character character) {
        characters.remove( character );
        character.setUser( null );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return user_id == user.user_id &&
                userName.equals(user.userName) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id, userName, email);
    }
}
