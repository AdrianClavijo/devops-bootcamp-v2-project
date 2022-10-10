package Models;

import java.util.List;


public class Teacher {
    private String code;
    private String name;
    private int age;
    private String educationLevel;
    private List<Subject> subjects;

    public Teacher(String name, int age, String educationLevel,List<Subject> subjects) {
        this.code = "TE" + (int)(Math.random() * 100 + 1) + name;
        this.name = name;
        this.age = age;
        this.educationLevel = educationLevel;
        this.subjects = subjects;
    }

    public String getCode() {
        return code;
    }

    public void addSubject(Subject subject) {
        if (subject == null) {
            
        }
        this.subjects.add(subject);
    }
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
        return this.educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public List<Subject> getSubjects() {
        return this.subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

}
