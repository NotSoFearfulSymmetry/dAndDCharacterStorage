package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The user's role.
 */
@Entity(name = "Role")
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO, generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToOne
    @JoinColumn(name="userName", referencedColumnName = "username", nullable = false)
    private User user;

    /**
     * No-arg constructor.
     */
    public Role() {

    }

    /**
     * Constructor with arguments.
     * @param roleName the role name
     * @param user the user
     */
    public Role(String roleName, User user) {
        this.roleName = roleName;
        this.user = user;
    }

    /**
     * Get the ID.
     * @return the ID
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID.
     * @param id the ID
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get role name.
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Set role name.
     * @param roleName the role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Get the user.
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the user.
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }
}