package com.mugalli;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "BookAuthor")
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "AuthorFirstName", length = 50)
    private String firstName;
    private String lastName;
    @Column(length = 500)
    private String bio;
    @Temporal(TemporalType.DATE)
    private Date dateBirthDay;
    @Transient
    private Integer age;



    public Author() {
    }


    public Author(Long id, String firstName, String lastName, String bio, Date dateBirthDay, Integer age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.bio = bio;
        this.dateBirthDay = dateBirthDay;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setIs(Long is) {
        this.id = is;
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Date getDateBirthDay() {
        return dateBirthDay;
    }

    public void setDateBirthDay(Date dateBirthDay) {
        this.dateBirthDay = dateBirthDay;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
