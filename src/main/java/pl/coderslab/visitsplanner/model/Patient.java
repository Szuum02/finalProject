package pl.coderslab.visitsplanner.model;

import org.hibernate.validator.constraints.UniqueElements;
import org.hibernate.validator.constraints.pl.PESEL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(unique = true)
    @PESEL(message = "Niepoprawny pesel")
    private String pesel;
    @NotNull
    @NotBlank
    @Pattern(regexp = "(\\p{L}*[- ])*\\p{L}+", message = "Błędne imię")
    private String firstName;
    @NotNull
    @NotBlank
    @Pattern(regexp = "(\\p{L}*[- ])*\\p{L}+", message = "Błędne nazwisko")
    private String lastName;
    @NotNull
    @Column(unique = true)
    @NotBlank
    @Pattern(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,}){1}", message = "Niepoprawny mail")
    private String mail;
    @NotNull
    @Pattern(regexp = "\\d{9}", message = "Nr telefonu musi się składać z 9 cyfr")
    private String telephone;

    private String street;

    private Integer streetNumber;

    private Integer flatNumber;
    @Pattern(regexp = "(\\p{L}+[- ])*\\p{L}+", message = "Niepoprawna nazwa miasta")
    private String city;
    @Pattern(regexp = "([0-9][0-9]-[0-9][0-9][0-9])?", message = "Kod pocztowy musi być w formaci xx-xxx")
    private String postCode;

    @ManyToMany(mappedBy = "patients")
    private List<Doctor> doctors;

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
