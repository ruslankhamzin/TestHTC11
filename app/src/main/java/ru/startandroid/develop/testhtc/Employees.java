package ru.startandroid.develop.testhtc;


public class Employees {
    public String name;
    public String phone_number;
    public String skills;

    public Employees(String name, String phone_number, String skills) {
        this.name = name;
        this.phone_number = phone_number;
        this.skills = skills;
    }

    public Employees() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
