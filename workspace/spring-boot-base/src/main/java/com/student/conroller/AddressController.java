package com.student.conroller;

import com.employee.entity.Address;
import com.employee.entity.Employee;
import com.student.service.AddressService;
import com.student.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by rsma on 04/08/2017.
 */
@RestController
public class AddressController {

    @Autowired
    AddressService addressService;

    @RequestMapping(value = "/employees/{id}/addresses", method = RequestMethod.POST)
    public ResponseEntity addEmployeeAddress(@RequestBody Address address,@PathVariable("id") String id) {
        return new ResponseEntity<>(addressService.addAddress(id,address), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employees/{id}/addresses", method = RequestMethod.GET)
    public List<Address> getEmployeeAddress(@PathVariable("id") String id) {
        return addressService.getAddress(id);
    }

    @RequestMapping(value = "/employees/{id}/addresses", method = RequestMethod.PUT)
    public ResponseEntity modificationEmployeeById(@PathVariable("id") String id, @RequestBody List<Address> addresses) {
        if (addressService.modificationAddress(id, addresses)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/employees/{id}/addresses", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployeeById(@PathVariable("id") String id) {
        if (addressService.deleteAddress(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
