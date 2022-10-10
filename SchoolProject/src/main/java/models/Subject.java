package Models;

public class Subject {
    private String Name;
    private String Grade;


    public Subject(String Name, String Grade) {
        this.Name = Name;
        this.Grade = Grade;
    }

    public String getsubject() {
        return this.Name;
    }

    public void setSubjeect(String Name) {
        this.Name = Name;
    }

    public String getGrade() {
        return this.Grade;
    }

    public void setGrade(String Grade) {
        this.Grade = Grade;
    }

}
