package org.tburke.javavideogamebackendexample.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "motd")
public class Motd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    @Column(name = "message_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date messageDate;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(Date messageDate) {
        this.messageDate = messageDate;
    }
}