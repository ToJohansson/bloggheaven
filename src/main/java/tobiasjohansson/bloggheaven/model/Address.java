package tobiasjohansson.bloggheaven.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adressId;
    private String street;
    private String postalCode;
    private String City;
    private String country;

    public Address(){}

    public Address(String street, String postaCode, String city, String country) {
        this.street = street;
        this.postalCode = postaCode;
        City = city;
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostaCode() {
        return postalCode;
    }

    public void setPostaCode(String postaCode) {
        this.postalCode = postaCode;
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
