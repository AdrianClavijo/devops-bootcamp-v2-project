package Menus;

import Models.Student;
import Models.Subject;
import Repositories.StudentRepository;

public class StudentMenu implements IMenuCommand{

    private StudentRepository student;
    private String studentCode;
    

    public StudentMenu(String studentCode) {
        this.studentCode = studentCode;
    }

    @Override
    public void execute() {
        System.out.println("Loading Report of Subjects and Grades.....");
        System.out.println("=================== REPORT ===================");
        student = new StudentRepository();
        Student Students = student.getStudentByCode(this.studentCode);  
        int count=1;
        for(Subject subject : Students.getSubject()){
            System.out.println(count+". Subject: "+subject.getsubject()+" - Grade: "+subject.getGrade());
            count+=1;
        }
    }
    
}
