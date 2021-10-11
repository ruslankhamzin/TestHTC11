package ru.startandroid.develop.testhtc;

import java.util.ArrayList;

public class Company {
    private String name;
    private String age;
    private String competences;
    public static ArrayList<Company> company = new ArrayList<>();

    public Company(String name, String age, String competences) {
        this.name = name;
        this.age = age;
        this.competences = competences;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCompetences() {
        return competences;
    }

    public void setCompetences(String competences) {
        this.competences = competences;
    }
}
