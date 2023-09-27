package pl.coderslab.visitsplanner.model;

import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank(message = "Nazwa szpitala nie może być pusta")
    private String name;

    @NotNull
    @NotBlank(message = "Nazwa ulicy nie może być pusta")
    private String street;
    @NotNull(message = "Błędna wartość numeru domu")
    private Integer streetNumber;
    private Integer flatNumber;
    @NotNull
    @NotBlank
    @Pattern(regexp = "(\\p{L}+[- ])*\\p{L}+", message = "Błędna nazwa miasta")
    private String city;
    @NotNull
    @NotBlank
    @Pattern(regexp = "[0-9][0-9]-[0-9][0-9][0-9]", message = "Kod pocztowy ma być w formacie xx-xxx")
    private String postCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(Integer streetNumber) {
        this.streetNumber = streetNumber;
    }

    public Integer getFlatNumber() {
        return flatNumber;
    }

    public void setFlatNumber(Integer flatNumber) {
        this.flatNumber = flatNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getFullAddress() {
        String number = flatNumber == null ? String.valueOf(streetNumber) : street + "/" + flatNumber;
        return String.format("ul. %s %s, %s %s", street, number, postCode, city);
    }
}
