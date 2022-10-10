package Services;

import java.util.List;

import Models.Student;
import Models.Teacher;
import Repositories.StudentRepository;
import Repositories.TeacherRepository;

public class AccessValidator {
    private StudentRepository studentRepository;
    private TeacherRepository teacherRepository;

    public AccessValidator() {
        this.studentRepository = new StudentRepository();
        this.teacherRepository = new TeacherRepository();
    }

    public Boolean verifyStudentAccess(String code) {
        List<Student> students = studentRepository.getAllStudents();
        for(Student student:students){
            if(student.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }

    public Boolean verifyTeacherAccess(String code) {
        List<Teacher> teachers = teacherRepository.getAllTeachers();
        for(Teacher teacher:teachers){
            if(teacher.getCode().equals(code)){
                return true;
            }
        }
        return false;
    }
}
