package Repositories;

import java.util.List;

import Models.Teacher;
import Services.ReadDataService;

public class TeacherRepository {
    private List<Teacher> teachers;

    public TeacherRepository() {
        this.teachers = new ReadDataService().readTeachersDataFromJson();
    }

    public List<Teacher> getAllTeachers() {
        return this.teachers;
    }

    public Teacher getTeacherByCode(String code) {
        return teachers.stream().filter(teacher -> teacher.getCode().equals(code)).findAny().orElse(null);
    }

    public void addTeacher(Teacher t) {
        this.teachers.add(t);
    }
}
