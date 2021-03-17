package com.example.javaacademy.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    //@Column(insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    //@Temporal(TemporalType.DATE)
    @Column (nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime createTimeStamp;
    //@Column(insertable = false, updatable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    //@Temporal(TemporalType.DATE)
    @Column (nullable = false, updatable = false)
    @CreationTimestamp
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

//    public Date getCreateTimeStamp() {
//        return createTimeStamp;
//    }
//
//    public void setCreateTimeStamp(Date createTimeStamp) {
//        this.createTimeStamp = createTimeStamp;
//    }
//
//    public Date getUpdateTimeStamp() {
//        return updateTimeStamp;
//    }
//
//    public void setUpdateTimeStamp(Date updateTimeStamp) {
//        this.updateTimeStamp = updateTimeStamp;
//    }
}
