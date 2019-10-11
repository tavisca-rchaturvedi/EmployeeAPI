package com.tavisca.UsersApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PasswordRepository passwordRepository;

    @Autowired
    EntityManager entityManager;



    @GetMapping("/demo")
    @Query("select * from employee;")
    public String demo(){
        System.out.println(employeeRepository.findById(1L));
        return "Hello";
    }


    @GetMapping("/employees")
    public List<Employee> index(){
        long id = 1;

        System.out.println(employeeRepository.findById(id));
        return employeeRepository.findAll();
    }


    @GetMapping("/employees/{id}")
    public Optional<Employee> singleEmployee(@PathVariable long id){
        Optional<Employee> emp =  employeeRepository.findById(id);
        return emp;
    }

    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee){
        String response = "Employee Added";
        Date date = new Date();
        employee.createdBy = "Rishabh";
        employee.createdOn = new Timestamp(date.getTime());
        employeeRepository.save(employee);

        return response;
    }

    @PatchMapping("/update")
    public String updateEmployee(@RequestBody Employee employee){
        Optional<Employee> oldData = employeeRepository.findById(employee.id);

        if(oldData.isPresent()){
            if(!oldData.get().role.equals("admin") && (oldData.get().createdBy != employee.createdBy || oldData.get().role != employee.role)){
                return "You do not have previleges to change Created By or Role Field";
            }
            else{
                employee.createdOn = oldData.get().createdOn;
                employee.role = oldData.get().role;
                employee.createdBy = oldData.get().createdBy;
                if(employee.firstName.equals(null)){
                   employee.firstName = oldData.get().firstName;
                }
                if(employee.lastName.equals(null)){
                    employee.lastName = oldData.get().lastName;
                }
                employeeRepository.save(employee);
                return "Employee Data Updated";
            }
        }
        else{
            return "No previous data for this employee";
        }
    }


    @GetMapping("/password/{id}")
    public PasswordResponse passwordForEmployee(@PathVariable long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        Optional<Password> password = passwordRepository.findById(id);

        if(!employee.isPresent()){
            return null;
        }
        if(!password.isPresent()){
            return null;
        }

        return new PasswordResponse(employee.get().id, employee.get().firstName, employee.get().lastName, password.get().password);

    }


    @PostMapping("/password")
    public String passwordMaking(@RequestBody Password password){
        passwordRepository.save(password);
        return "Successfully updated password";
    }

    @PutMapping("/employee")
    public List<Employee> whereClause(@RequestParam String column, @RequestParam String value){
        
        if(column.toLowerCase().equals("firstname"))
            return employeeRepository.findByFirstName(value);
        else if(column.toLowerCase().equals("lastname"))
            return employeeRepository.findByLastName(value);
        else if(column.toLowerCase().equals("createdby"))
            return employeeRepository.findByCreatedy(value);
        else if(column.toLowerCase().equals("role"))
            return employeeRepository.findByRole(value);
        else
            return null;
    }
}
