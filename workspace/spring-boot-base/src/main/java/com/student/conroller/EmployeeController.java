package com.student.conroller;

import com.employee.entity.Employee;
import com.student.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by rsma on 04/08/2017.
 */

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    Map<String, Employee> employees = new HashMap<>();

    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") String id) {
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.PUT)
    public ResponseEntity modificationEmployeeById(@PathVariable("id") String id, @RequestBody Employee employee) {
        if (employeeService.modificationEmployeeById(id, employee)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployeeById(@PathVariable("id") String id) {
        if (employeeService.deleteEmployeeById(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
