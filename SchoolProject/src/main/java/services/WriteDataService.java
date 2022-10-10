package Services;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import Models.Student;
import Repositories.StudentRepository;

public class WriteDataService {
    private StudentRepository studentRepository;

    public WriteDataService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void writeStudentsDataToRepository(List<Student> Json) {
        // students.forEach(student -> this.studentRepository.addStudent(student));
        try{
            Gson gson = new Gson();
            FileWriter writer = new FileWriter("D:/Devops/DEV Fundamentals/devops-bootcamp-v2/devops-bootcamp-v2-project-main/SchoolProject/src/main/resources/output.json");
            String file_json = gson.toJson(Json);
            gson.toJson(Json,writer);
            writer.flush();
            writer.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}
