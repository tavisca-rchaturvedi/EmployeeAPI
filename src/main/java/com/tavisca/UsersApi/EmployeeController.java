package com.tavisca.UsersApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class EmployeeController {

//    @Autowired
//    EmployeeRepository employeeRepository;


    @GetMapping("/employees")
    public List<Employee> index(){
        List<Employee> abc = new ArrayList<Employee>();
        abc.add( new Employee(1,"Rishabh", "Chaturvedi", "Gaming"));
        return abc;
    }
}
