package com.example.javaacademy.entity;

import com.sun.istack.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @Column (unique = true, nullable = false, updatable = false)
    private String userName;
    @NotNull
    @Column (nullable = false, updatable = true)
    private String pwd;
    @NotNull
    @Column (nullable = false, updatable = true)
    private String name;
    @Column (nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createTimeStamp;
    @Column (nullable = false, updatable = true)
    @UpdateTimestamp
    private LocalDateTime updateTimeStamp;


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

    public LocalDateTime getCreateTimeStamp() {
        return createTimeStamp;
    }

    public void setCreateTimeStamp(LocalDateTime createTimeStamp) {
        this.createTimeStamp = createTimeStamp;
    }

    public LocalDateTime getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(LocalDateTime updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }

    public boolean hasUserName (String userName){
        return this.userName.equals(userName);
    }
}
