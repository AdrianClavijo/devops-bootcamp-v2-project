package Services;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Models.Student;
import Models.Teacher;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;


public class ReadDataService {
    public ReadDataService() {}

    public List<Student> readStudentsDataFromJson() {
        List<Student> students = null;
        try {
            
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("SchoolProject/src/main/Resources/DBSchool.json"));
            students = gson.fromJson(reader, new TypeToken<List<Student>>() {}.getType());
            students = students.stream().filter(s -> s.getCode().startsWith("S")).collect(Collectors.toList());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
    
    public List<Teacher> readTeachersDataFromJson() {
        List<Teacher> teachers = null;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("SchoolProject/src/main/Resources/DBSchool.json"));
            teachers = gson.fromJson(reader, new TypeToken<List<Teacher>>() {}.getType());
            teachers = teachers.stream().filter(s -> s.getCode().startsWith("T")).collect(Collectors.toList());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return teachers;
    }

    public List<Student> readAllDataFromJson() {
        List<Student> students = null;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("SchoolProject/src/main/Resources/DBSchool.json"));
            students = gson.fromJson(reader, new TypeToken<List<Student>>() {}.getType());
            students = students.stream().collect(Collectors.toList());
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }
}
