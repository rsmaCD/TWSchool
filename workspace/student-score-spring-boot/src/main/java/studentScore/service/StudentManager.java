package studentScore.service;

import org.springframework.stereotype.Service;
import studentScore.entity.Course;
import studentScore.entity.Student;

import java.util.*;

/**
 * Created by rsma on 26/07/2017.
 */
public class StudentManager implements StudentServiceInterface{

    private StudentManager() {}
    private static final StudentManager management = new StudentManager();
    private Map<String,Student> studentMap = new HashMap<>();

    public static StudentManager getInstance() {
        return management;
    }
    @Override
    public Student postStudent(Student student) {
        if(student.getId() == null) {
            String id = UUID.randomUUID().toString().replace("-", "");
            student.setId(id);
        }
        if(studentMap.get(student.getId()) != null){
            return null;
        }
        studentMap.put(student.getId(), student);
        try {
            return studentMap.get(student.getId()).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Student postStudentCourse(String id,List<Course> courseList){
        Student studentById = studentMap.get(id);
        if(studentById != null){
            studentById.setCourseList(courseList);
            return studentById;
        }else {
            return null;
        }
    }
    @Override
    public Student getStudentById(String id) {
        Student student = studentMap.get(id);
        if(student != null) {
            try {
                return student.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

//    public Student createStudent(String id, String name, List<Course> courseList) {
//        if(getStudentById(id) == null) {
//            Student student = new Student(id, name, courseList);
//            studentMap.put(id,student);
//            return student;
//        }
//        return null;
//    }

    public List<Student> getStudentsByIdList(List<String> idList) {

        List<Student> studentList = new ArrayList<>();
        for (String id:idList) {
            Student student = this.management.getStudentById(id);
            if(student != null){
                studentList.add(new Student(student.getId(),student.getName(),student.getCourseList()));
            }
        }
        return studentList;
    }
    @Override
    public List<Student> getAllStudents(){
        return new ArrayList<>(this.studentMap.values());
    }


    public void cleanList(){
        studentMap = new HashMap<>();
    }
}
