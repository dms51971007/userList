package com.javarush.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name="USER")
public class User {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private boolean isadmin;

    private Date createdDate;

    private String name;

    private int age;

    public boolean getisadmin() {
        return isadmin;
    }

    public void setis_admin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public Date getCreated_Date() {
        return createdDate;
    }



    public Date getCreatedDate() {
        return createdDate;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", admin=" + isadmin +
                '}';
    }
}