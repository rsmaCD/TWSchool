package studentScore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentScore.entity.Course;
import studentScore.entity.Student;
import studentScore.service.StudentManager;
import studentScore.service.StudentServiceInterface;

import java.util.List;

/**
 * Created by rsma on 07/08/2017.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentServiceInterface studentService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody Student student){
        return new ResponseEntity<>(studentService.postStudent(student), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get() {
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) {
        Student student = studentService.getStudentById(id);
        if(student != null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}/courses",method = RequestMethod.POST)
    public ResponseEntity postCourse(@PathVariable("id") String id, @RequestBody List<Course> listCourse) {
        Student student = studentService.postStudentCourse(id,listCourse);
        if(student != null){
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
