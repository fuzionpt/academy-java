package com.example.javaacademy.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String userName;
    private String pwd;
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedDate;


    public User (){
        //empty constructor
    }

    public User(Long id, String userName, String pwd, String name) {
        this.id = id;
        this.userName = userName;
        this.pwd = pwd;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
}
