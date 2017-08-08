package studentScore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import studentScore.entity.Student;
import studentScore.service.StudentManager;

/**
 * Created by rsma on 07/08/2017.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentManager manager;

    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody Student student) {
        return new ResponseEntity<>(manager.postStudent(student), HttpStatus.CREATED);
    }

}
