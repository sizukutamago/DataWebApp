package com.sample.sample;

import javax.persistence.*;

@Entity
@Table(name = "mypersondata")
public class MyPersonData {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = true)
    private String mail;

    @Column(nullable = true)
    private int age;

    public MyPersonData() {}

    public MyPersonData(String name, String mail, int age) {
        this.name = name;
        this.mail = mail;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MyPersonData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", age=" + age +
                '}';
    }
}
