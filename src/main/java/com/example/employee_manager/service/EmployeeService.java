package com.example.employee_manager.service;

import com.example.employee_manager.model.Employee;
import com.example.employee_manager.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepo;
    
    @Autowired 
    public EmployeeService(EmployeeRepository employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee getEmployeeById(long id){
        return employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }

    public void deleteEmployeeById(long id){
        employeeRepo.deleteById(id);
    }

    

}
