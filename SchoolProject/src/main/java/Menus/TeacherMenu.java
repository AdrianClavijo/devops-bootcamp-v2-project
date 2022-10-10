package Menus;

import java.util.List;
import java.util.Scanner;

import Helpers.EducationLevel;
import Helpers.Grade;
import Models.Student;
import Models.Subject;
import Models.Teacher;
import Repositories.StudentRepository;
import Repositories.TeacherRepository;
import Services.AccessValidator;

public class TeacherMenu implements IMenuCommand{

    private TeacherRepository teachers;
    private StudentRepository students;
    private String studentCode;

    public TeacherMenu(String studentCode) {
        this.studentCode = studentCode;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        teachers = new TeacherRepository();
        Teacher teacher = teachers.getTeacherByCode(studentCode);
        System.out.println("=============================");
        System.out.println("Welcome " + teacher.getName());
        System.out.println("=============================");
        System.out.println("Select your option please: ");
        System.out.println("1. List all students by Education Level");
        System.out.println("2. Enter a grade for a student");
        System.out.println("3. Exit");
        String option = scanner.nextLine();
        boolean access = false;
        while (!access) {
            switch (option) {
                case "1":
                    menuOption1();
                    access=true;
                    break;
                case "2":
                    menuOption2();
                    access=true;
                    break;
                case "3":
                System.out.println(" Closed........");
                    access=true;
                    break;
            }
        }
        scanner.close();
    }

    void menuOption1(){
        Scanner scanner = new Scanner(System.in);
        boolean acc=false;
        students = new StudentRepository();
        List<Student> student = null;
        String edu="";
        while (!acc){
            System.out.println("Please Select an Education Level");
            for(EducationLevel Edu:EducationLevel.values()){
                System.out.println("  - "+Edu);
            }
            edu = scanner.nextLine().toUpperCase();
            if(EducationLevel.HIGH_SCHOOL.exists(edu)){
                student = students.getStudentByEducationLevel(edu);
                acc=true;
            }
        }
        System.out.println("=================== List of Students by "+edu+" ===================");
        int count =1;
        if(student.size()>0){
            for(Student st : student){
                System.out.println(count+". Name: "+st.getName());
                System.out.println("   Age: "+st.getAge());
                System.out.println("   Education Level: "+st.getEducationLevel());
                System.out.println("   Subjects: ");
                for(Subject sub : st.getSubject()){
                    System.out.println("     - Name: "+sub.getsubject()+" - Grade: "+sub.getGrade());
                }
                System.out.println("-------------------------------------------------------------------");
                count+=1;
            }
        }else{
            System.out.println("There are no Students on: "+edu);
        }
        scanner.close();
    }
    
    void menuOption2(){
        Scanner scanner = new Scanner(System.in);
        students = new StudentRepository();
        boolean acce=false;
        boolean acc=false;
        boolean ac=false;
        String edu="";
        String grade="";
        while(!acce){
            System.out.println("Please enter the student code");
            String code = scanner.nextLine();
            AccessValidator accessValidator = new AccessValidator();
            if(!accessValidator.verifyStudentAccess(code)){
            }else{
            Student student =students.getStudentByCode(code);
            String el=student.getEducationLevel();
            System.out.println("=============================== STUDENT ===============================");
            System.out.println("Name: "+student.getName());
            System.out.println("Age: "+student.getAge());
            System.out.println("Education Level: "+student.getEducationLevel());
            System.out.println("   Subjects: ");
            for(Subject sub : student.getSubject()){
                System.out.println("     - Name: "+sub.getsubject()+" - Grade: "+sub.getGrade());
            }
            System.out.println("-------------------------------------------------------------------");
            while (!acc){
                System.out.println("Please Select a Subject to Add");
                switch(el){
                    case "ELEMENTARY_SCHOOL":
                        EducationLevel.ELEMENTARY_SCHOOL.ESchoolSubjects();
                        break;
                    case "MIDDLE_SCHOOL":
                        EducationLevel.MIDDLE_SCHOOL.MSchoolSubjects();
                        break;
                    case "HIGH_SCHOOL":
                        EducationLevel.HIGH_SCHOOL.HSchoolSubjects();
                        break;
                }
                edu = scanner.nextLine().toUpperCase();
                if(EducationLevel.HIGH_SCHOOL.existsAll(edu)){
                    while (!ac){
                        System.out.println("Please Select a grade to Add");
                        for(Grade G: Grade.values()){
                            System.out.println("  - "+G.getName());
                        }
                        grade = scanner.nextLine().toUpperCase();
                        if (Grade.A.exists(grade)){
                            System.out.println(edu+" - "+grade);
                            students.addStudentSubject(new Subject(edu, grade),code);
                            ac=true;
                            acc=true;
                            acce=true;
                            }
                        }
                    }
                }
            }
        }
        scanner.close();
    }
}
