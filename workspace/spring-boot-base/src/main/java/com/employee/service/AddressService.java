package com.employee.service;

import com.employee.entity.Address;
import com.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by rsma on 04/08/2017.
 */
@Service
public class AddressService {

    @Autowired
    EmployeeService employeeService;

    private boolean addAddressToEmployee(Employee employee, Address address) {
        if(employee.getAddressList() != null) {
            Map<String, Address> addressMap = employee.getAddressList()
                    .stream()
                    .collect(Collectors.toMap(Address::getAddressName, account -> account));
            if (addressMap.get(address.getAddressName()) == null) {
                addressMap.put(address.getAddressName(), address);
                employee.setAddressList(new ArrayList<>(addressMap.values()));
                return true;
            } else {
                return false;
            }
        }else{
            employee.setAddressList(asList(address));
            return true;
        }
    }

    public boolean addAddressesByEmployeeId(String employeeId, List<Address> addresses) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            if(employee.getAddressList() != null){
                for (Address address : addresses) {
                    addAddressToEmployee(employee, address);
                }
            }else{
                employee.setAddressList(addresses);
            }
            return true;
        } else {
            return false;
        }
    }

    public List<Address> getAddressesByEmployeeId(String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        return employee.getAddressList();
    }

    public boolean modifyAddressesByEmployeeId(String employeeId, List<Address> addresses) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            employee.setAddressList(addresses);
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteAddressesByEmployeeId(String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            employee.setAddressList(new ArrayList<>());
            return true;
        } else {
            return false;
        }
    }

    public boolean addAddressByEmployeeId(String employeeId, Address address) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            return addAddressToEmployee(employee,address);
        } else {
            return false;
        }
    }

    public Address getEmployeeAddressByAddressName(String employeeId, String addressName) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            Map<String, Address> addressMap = employee.getAddressList()
                    .stream()
                    .collect(Collectors.toMap(Address::getAddressName, account -> account));
            return addressMap.get(addressName);
        }else {
            return null;
        }
    }

    public boolean modifyEmployeeAddressByAddressName(String employeeId, Address address, String addressName) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            Map<String, Address> addressMap = employee.getAddressList()
                    .stream()
                    .collect(Collectors.toMap(Address::getAddressName, account -> account));
            addressMap.put(addressName,address);
            employee.setAddressList(new ArrayList<>(addressMap.values()));
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteEmployeeAddressByAddressName(String employeeId, String addressName) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            Map<String, Address> addressMap = employee.getAddressList()
                    .stream()
                    .collect(Collectors.toMap(Address::getAddressName, account -> account));
            addressMap.remove(addressName);
            employee.setAddressList(new ArrayList<>(addressMap.values()));
            return true;
        }else {
            return false;
        }
    }
}

