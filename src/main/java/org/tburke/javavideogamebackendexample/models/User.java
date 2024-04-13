package org.tburke.javavideogamebackendexample.models;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "[User]")  // Escaping the table name
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String password;

    // New fields
    private String imageId; // Assuming IMAGE_ID is stored as a string
    @Column(length = 1000) // Optional: Customize the column definition
    private String biography;
    @Temporal(TemporalType.DATE) // Only the date part is stored
    private Date birthday;

    // Getters and Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getters and setters for new fields
    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
