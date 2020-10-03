package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * A class to represent a user.
 *
 * @author Simon Powers-Schaub
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param userName the user name
     * @param password  the user's password
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
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }
}
