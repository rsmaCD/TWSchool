package com.student.conroller;

import com.employee.entity.Address;
import com.student.service.AddressService;
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
    public ResponseEntity addEmployeeAddresses(@RequestBody List<Address> addresses, @PathVariable("id") String id) {
        if(addressService.addAddressesByEmployeeId(id,addresses)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/employees/{id}/addresses", method = RequestMethod.GET)
    public List<Address> getEmployeeAddresses(@PathVariable("id") String id) {
        return addressService.getAddressesByEmployeeId(id);
    }

    @RequestMapping(value = "/employees/{id}/addresses", method = RequestMethod.PUT)
    public ResponseEntity modifyAddresses(@PathVariable("id") String id, @RequestBody List<Address> addresses) {
        if (addressService.modifyAddressesByEmployeeId(id, addresses)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/employees/{id}/addresses", method = RequestMethod.DELETE)
    public ResponseEntity deleteAddresses(@PathVariable("id") String id) {
        if (addressService.deleteAddressesByEmployeeId(id)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/employees/{id}/addresses/{addressName}", method = RequestMethod.POST)
    public ResponseEntity addEmployeeAddress(@RequestBody Address address,@PathVariable("id") String id,@PathVariable("addressName") String addressName) {
        if(addressService.addAddressByEmployeeId(id,address)){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/employees/{id}/addresses/{addressName}", method = RequestMethod.GET)
    public Address getEmployeeAddressByAddressName(@PathVariable("id") String id,@PathVariable("addressName") String addressName) {
        return addressService.getEmployeeAddressByAddressName(id,addressName);
    }

    @RequestMapping(value = "/employees/{id}/addresses/{addressName}", method = RequestMethod.PUT)
    public ResponseEntity modifyAddress(@PathVariable("id") String id, @RequestBody Address address,@PathVariable("addressName") String addressName) {
        if (addressService.modifyEmployeeAddressByAddressName(id, address,addressName)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(value = "/employees/{id}/addresses/{addressName}", method = RequestMethod.DELETE)
    public ResponseEntity deleteAddress(@PathVariable("id") String id,@PathVariable("addressName") String addressName) {
        if (addressService.deleteEmployeeAddressByAddressName(id,addressName)) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
