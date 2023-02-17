package org.example;

import java.util.UUID;

public class Person {
     private String identifier;
     private String fullName;
     private int age;

    public Person(String identifier, String fullName, int age) {
        this.identifier = identifier;
        this.fullName = fullName;
        this.age = age;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getFullname() {
        return fullName;
    }

    public void setFullname(String fullname) {
        this.fullName = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Customer Name: ")
                .append(fullName)
                .append(" Age: ")
                .append(age)
                .toString();
    }
}
