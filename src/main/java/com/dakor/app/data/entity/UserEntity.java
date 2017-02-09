package com.dakor.app.data.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * .
 *
 * @author dkor
 */
@Entity
@Table(name = "USERS")
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(name = "ID", nullable = false, length = 16, unique = true)
    private String id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
