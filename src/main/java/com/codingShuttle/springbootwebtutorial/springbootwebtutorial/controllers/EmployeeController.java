package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.controllers;


import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//To define it as a controller we give annotation as @RestController, so that compiler will know that it's a rest controller.
@RestController
@RequestMapping(path = "/employees") //This is basically the parent path definition, as we are sure always that since this is a employees related things only and every link will be started via /employees only.
public class EmployeeController {

    /*
    From lecture 2.3 Commenting out as now we will be using service (EmployeeService) layer to handle the things and implement the business logic.
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    FROM LECTURE 2.2
    Here we are using @PathVariable when parameter is essential part of the URL that identifies the resource
    @GetMapping(path = "{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable long employeeId){
        return new EmployeeDTO(employeeId,"Pritish","pritish@gmail.com",28, LocalDate.ofYearDay(2024,05),true);
    }

    //Here we are using @RequestParam query parameter when the parameter when it is optional and used for filtering, sorting or other modifications to the request.
    @GetMapping()
    public String getAllEmployees(@RequestParam(required = true) Integer age,
                                  @RequestParam(required = false) String email){
        return age+" "+email;
    }

    //Just to show how to implement the post method
    @PostMapping(path = "/post")
    public String createEmployee(){
        return "HI post method done !!";
    }
    */

    //We are using the service layer here, and calling the service layer here.
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //From Lecture 2.3
    @GetMapping(path = "{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable long employeeId){
        //return employeeRepository.findById(employeeId).orElse(null);
        return employeeService.findById(employeeId);
    }
    @GetMapping()
    public List<EmployeeDTO> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping(path = "/post")
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employeeID){
        return employeeService.createEmployee(employeeID);
    }




}
