package dev.smirnov.crudspringproject.model;

import javax.persistence.*;
import java.io.File;
import java.util.Date;

/**
 * @author pavelsmirnov
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    //@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "birthDate")
    private String birthDate;

    @Column(name = "telNumber")
    private Long telNumber;

    @Column(name = "file")
    private File file;

    @Column(name = "test")
    private TestBD testBD;

    public TestBD getTestBD() {
        return testBD;
    }

    public void setTestBD(TestBD testBD) {
        this.testBD = testBD;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public User() {}

    public User(Long id, String firstName, String lastName, String birthDate, Long telNumber) {
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Long getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(Long telNumber) {
        this.telNumber = telNumber;
    }
}
