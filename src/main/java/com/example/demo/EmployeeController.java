// package com.example.demo;

// import org.springframework.web.bind.annotation.RestController;

// import java.util.ArrayList;
// import java.util.List;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;


// @RestController
// public class Controller {

//     List<Employee> employees = new ArrayList<>();
    
//     EmployeeService employeeService;
//     @GetMapping("employees")//This is an endpoint
//     public List<Employee> getEmployees(){
//         // List<Employee> employee = new ArrayList<>();
//         // employee.add(null);
//         // Employee emp = new Employee();
//         // emp.setName("Shiva");
//         // employee.add(emp);

//         return employees;
//     } 

//     @PostMapping("employees")
//     public String createEmployee(@RequestBody Employee employee) {
//         //TODO: process POST request
//         // employees.add(employee);
//         EmployeeService.createEmployee(employee);
//         return "Saved Successfully";
//     }
    
// }

package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller //This class is capable of handeling http requests and returning a 
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/")
    public String showForm() {
        return "index"; // This will load index.html from /templates
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestParam String name,
                              @RequestParam String email,
                              @RequestParam String phone) {
        Employee emp = new Employee();
        emp.setName(name);
        emp.setEmail(email);
        emp.setPhone(phone);
        repository.save(emp);
        return "redirect:/view";
    }

    @GetMapping("/view")
    public String viewEmployees(Model model) {
        model.addAttribute("employees", repository.findAll());
        return "view";
    }
}
