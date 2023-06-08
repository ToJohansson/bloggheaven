package tobiasjohansson.bloggheaven.model;

import javax.persistence.*;

@Entity
@Table(name = "Adresses")
public class Adress {

    /**
     *Address ska innehålla id, street, postalCode, city, country
     *
     * En användare kan endast ha en adress, men en adress kan kopplas till flera användare
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adressId;
    private String street;
    private String postaCode;
    private String City;
    private String country;
//    private User user;

    public Adress(){}

    public Adress(String street, String postaCode, String city, String country) {
        this.street = street;
        this.postaCode = postaCode;
        City = city;
        this.country = country;
    }

    public long getId() {
        return adressId;
    }

//    public void setId(long id) {
//        this.adressId = adressId;
//    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostaCode() {
        return postaCode;
    }

    public void setPostaCode(String postaCode) {
        this.postaCode = postaCode;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
