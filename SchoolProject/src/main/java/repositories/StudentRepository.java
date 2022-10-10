package Repositories;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Models.Student;
import Models.Subject;
import Services.ReadDataService;
import Services.WriteDataService;

public class StudentRepository {
    private List<Student> students;
    private StudentRepository student;

    public StudentRepository() {
        this.students = new ReadDataService().readStudentsDataFromJson();
    }

    public List<Student> getAllStudents() {
        return this.students;
    }

    public Student getStudentByCode(String code) {
        return students.stream().filter(student -> student.getCode().equals(code)).findAny().orElse(null);
    }

    public void addStudent(Student s) {
        this.students.add(s);
    }

    public void addStudentSubject(Subject s,String code) {
        List<Student> Json = new ReadDataService().readAllDataFromJson();
        for(Student student: Json){
            if(student.getCode().equals(code)){
                student.getSubject().add(s);
                break;
            }
        }
        WriteDataService save = new WriteDataService(this.student);
        save.writeStudentsDataToRepository(Json);
    }

    public List<Student> getStudentByEducationLevel(String edu) {
        return students.stream().filter(student -> student.getEducationLevel().equals(edu)).collect(Collectors.toList());
    }
}
