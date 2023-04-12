package com.example.myapplicationlab4week5;

public class StudentMod {
    private String name;
    private int id;
    private int age;



    public StudentMod(String name ,int id, int age ) {
        this.name = name;
        this.id = id;
        this.age = age;

    }

    @Override
    public String toString() {
        return "StudentMod{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setAge(int age) {
        this.age = age;
    }



}
