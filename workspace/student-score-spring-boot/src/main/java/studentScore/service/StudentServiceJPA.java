package studentScore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentScore.dao.StudentRepository;
import studentScore.entity.Course;
import studentScore.entity.Student;

import java.util.List;

/**
 * Created by rsma on 10/08/2017.
 */
@Service
public class StudentServiceJPA implements StudentServiceInterface {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student postStudentCourse(String id, List<Course> courseList) {
        Student student = studentRepository.findById(id);
        if (student != null) {
            courseList.forEach(course -> course.setStudent(student));
            student.setCourseList(courseList);
            return studentRepository.save(student);
        }
        return student;
    }

    @Override
    public Student getStudentById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student postStudent(Student student) {
        return studentRepository.save(student);
    }
}
