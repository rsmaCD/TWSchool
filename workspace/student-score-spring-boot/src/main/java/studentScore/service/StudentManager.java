package studentScore.service;

import org.springframework.stereotype.Service;
import studentScore.entity.Course;
import studentScore.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by rsma on 26/07/2017.
 */
@Service
public class StudentManager {

    private StudentManager() {}
    private static final StudentManager management = new StudentManager();
    private List<Student> studentList = new ArrayList<>();

    public static StudentManager getInstance() {
        return management;
    }

    public Student postStudent(Student student){
        String id = UUID.randomUUID().toString().replace("-", "");
        student.setId(id);
        studentList.add(student);
        return getStudentById(student.getId());
    }

    public boolean putStudent(Student student,String id){
        Student studentById = getStudentById(id);
return true;
    }

    public Student getStudentById(String id){
        for (Student stu: studentList) {
            if(stu.getId().equals(id)){
                return stu;
            }
        }
        return null;
    }

    public Student createStudent(String id, String name, List<Course> courseList) {
        if(getStudentById(id) == null) {
            Student student = new Student(id, name, courseList);
            studentList.add(student);
            return student;
        }
        return null;
    }

    public List<Student> getStudentsByIdList(List<String> idList){

        List<Student> studentList = new ArrayList<>();
        for (String id:idList) {
            Student student = this.management.getStudentById(id);
            if(student != null){
                studentList.add(new Student(student.getId(),student.getName(),student.getCourseList()));
            }
        }
        return studentList;
    }


    public void cleanList(){
        studentList = new ArrayList<>();
    }
}
