package ru.eugen.spring.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

public class People {

    private int id;

    @NotEmpty(message = "Name should be not empty")
    private String name;
    @NotEmpty(message = "Surname should be not empty")
    private String surname;
    @Min(value = 0, message = "Age should be more then 0")
    private int age;
    @NotEmpty(message = "Email should be not empty")
    @Email(message = "Email is not valid")
    private String email;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public People(int id, String name, String surname, int age, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.email = email;
    }

    public People() {
    }

    public People(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
