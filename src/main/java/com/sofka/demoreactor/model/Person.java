package com.sofka.demoreactor.model;

public class Person {
    private Integer personId;
    private String name;
    private Integer edad;


    public Person() {
    }

    public Person(Integer personId, String name, Integer edad) {
        this.personId = personId;
        this.name = name;
        this.edad = edad;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", edad=" + edad +
                '}';
    }
}
