package Models;

import java.util.ArrayList;

public class Student {
    private String code;
    private String name;
    private int age;
    private String education_level;
    private ArrayList<Subject> subjects;

    public Student(String name, int age, String education_level,ArrayList<Subject> subjects) {
        this.code = "ST" + (int)(Math.random() * 100 + 1) + name;
        this.name = name;
        this.age = age;
        this.education_level = education_level;
        this.subjects = subjects;
    }

    public String getCode() {
        return code;
    }

    // public String getGrade() {
    //     subject = getSubject();
    //     return subject.values();
    // }
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEducationLevel() {
        return this.education_level;
    }

    public ArrayList<Subject> getSubject() {
        return this.subjects;
    }

    public void setSubject(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }
    
}
