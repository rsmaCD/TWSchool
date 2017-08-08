package studentScore.service;

import org.springframework.stereotype.Service;
import studentScore.entity.Course;
import studentScore.entity.Student;

import java.util.*;

/**
 * Created by rsma on 26/07/2017.
 */
@Service
public class StudentManager {

    private StudentManager() {}
    private static final StudentManager management = new StudentManager();
    private Map<String,Student> studentMap = new HashMap<>();

    public static StudentManager getInstance() {
        return management;
    }

    public Student postStudent(Student student){
        if(student.getId() == null) {
            String id = UUID.randomUUID().toString().replace("-", "");
            student.setId(id);
        }
        if(studentMap.get(student.getId()) != null){
            return null;
        }
        studentMap.put(student.getId(), student);
        return studentMap.get(student.getId());
    }


    public Student getStudentById(String id){
        return studentMap.get(id);
    }

//    public Student createStudent(String id, String name, List<Course> courseList) {
//        if(getStudentById(id) == null) {
//            Student student = new Student(id, name, courseList);
//            studentMap.put(id,student);
//            return student;
//        }
//        return null;
//    }

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

    public List<Student> getAllStudents(){
        return new ArrayList<>(this.studentMap.values());
    }


    public void cleanList(){
        studentMap = new HashMap<>();
    }
}
