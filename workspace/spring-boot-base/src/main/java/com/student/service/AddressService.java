package com.student.service;

import com.employee.entity.Address;
import com.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rsma on 04/08/2017.
 */
@Service
public class AddressService {

    @Autowired
    EmployeeService employeeService;

    public boolean addAddress(String employId, Address address) {
        Employee employee = employeeService.getEmployeeById(employId);
        if (employee != null) {
            if(employee.getAddressList() == null){
                employee.setAddressList(new ArrayList<>());
            }
            employee.getAddressList().add(address);
            return true;
        } else {
            return false;
        }
    }

    public List<Address> getAddress(String employId) {
        Employee employee = employeeService.getEmployeeById(employId);
        return employee.getAddressList();
    }

    public boolean modificationAddress(String employId, List<Address> addresses) {
        Employee employee = employeeService.getEmployeeById(employId);
        if (employee != null) {
            employee.setAddressList(addresses);
            return true;
        }else{
            return false;
        }
    }

    public boolean deleteAddress(String employId) {
        Employee employee = employeeService.getEmployeeById(employId);
        if (employee != null) {
            employee.setAddressList(new ArrayList<>());
            return true;
        }else{
            return false;
        }
    }
}

