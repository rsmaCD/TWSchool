package studentScore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentScore.entity.Student;
import studentScore.service.StudentManager;

/**
 * Created by rsma on 07/08/2017.
 */
@RestController
@RequestMapping("/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private StudentManager manager;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody Student student){
        return new ResponseEntity<>(manager.postStudent(student), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get() {
        return new ResponseEntity<>(manager.getAllStudents(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity getById(@PathVariable("id") String id) {
        Student student = manager.getStudentById(id);
        if(student != null){
            return new ResponseEntity<>(student, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
