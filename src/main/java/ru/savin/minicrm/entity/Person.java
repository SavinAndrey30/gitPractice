package ru.savin.minicrm.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "first name cant be empty")
    @Size(min = 2, max = 30, message = "the field must be between 2-30 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "last name cant be empty")
    @Size(min = 2, max = 30, message = "the field must be between 2-30 characters")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Email cant be empty")
    @Email(message = "email must be valid")
    @Column(name = "email")
    private String email;

    @Column(name = "photo")
    private String photo;

    public Person() {

    }

    public Person(String firstName, String lastName, String email, String photo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photo = photo;
    }

    public Person(Long id, String firstName, String lastName, String email, String photo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.photo = photo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}