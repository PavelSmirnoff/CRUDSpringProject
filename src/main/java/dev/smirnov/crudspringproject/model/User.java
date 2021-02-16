package dev.smirnov.crudspringproject.model;

import javax.persistence.*;
import java.util.Date;

/**
 * @author pavelsmirnov
 */
@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthDate")
    private Date birthDate;

    @Column(name = "telNumber")
    private Long telNumber;

    public User() {}

    public User(Long id, String firstName, String lastName, Date birthDate, Long telNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.telNumber = telNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Long telNumber) {
        this.telNumber = telNumber;
    }
}
