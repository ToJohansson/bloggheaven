package tobiasjohansson.bloggheaven.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    /**
     * Användarna ska ha följande attribut:
     * id, firstName, LastName, address, email, phone och memberType.
     * De olika typerna är standard, enhanced och premium.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String memberType;

    // private Adress adress;

    public User() {
    }

    public User(String firstName, String lastName, String email, String phone, String memberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.memberType = memberType;
    }

    public long getUserId() {
        return userId;
    }

//    public void setUserId(long userId) {
//        this.userId = userId;
//    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
}
