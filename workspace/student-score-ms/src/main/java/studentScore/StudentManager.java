package studentScore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentManager {

    private StudentManager() {}
    private static final StudentManager management = new StudentManager();
    private List<Student> studentList = new ArrayList<>();

    public static StudentManager getInstance() {
        return management;
    }


    public Student createStudent(String id, String name, Score score) {

        if(getStudentById(id) == null) {
            Student student = new Student(id, name, score);
            studentList.add(student);
            return student;
        }
        return null;
    }

    public Student getStudentById(String id){
        for (Student stu: studentList) {
            if(stu.getId().equals(id)){
                return stu;
            }
        }
        return null;
    }

    public void cleanList(){
        studentList = new ArrayList<>();
    }
}
