package com.student.service;

import com.employee.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by rsma on 04/08/2017.
 */
@Service
public class EmployeeService {

    Map<String, Employee> employees = new HashMap<>();

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees.values());
    }

    public Employee getEmployeeById(String id){
        return employees.get(id);
    }

    public Employee addEmployee(Employee employee){
        String id = UUID.randomUUID().toString().replace("-", "");
        employee.setId(id);
        employees.put(id, employee);
        return employee;
    }

    public boolean modificationEmployeeById(String id,Employee employee){
        if (employees.get(id) != null) {
            employee.setId(id);
            employees.put(id, employee);
            if (employees.get(id).myEquals(employee)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean deleteEmployeeById(String id){
        Employee remove = employees.remove(id);
        if (remove != null) {
            return true;
        } else {
            return false;
        }
    }
}
