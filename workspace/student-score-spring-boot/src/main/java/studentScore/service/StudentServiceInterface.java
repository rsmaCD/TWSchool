package studentScore.service;

import org.springframework.stereotype.Service;
import studentScore.entity.Course;
import studentScore.entity.Student;

import java.util.List;

/**
 * Created by rsma on 10/08/2017.
 */
@Service
public interface StudentServiceInterface {

    Student postStudentCourse(String id, List<Course> courseList);
    Student getStudentById(String id);
    List<Student> getAllStudents();
    Student postStudent(Student student);

}
