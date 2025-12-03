package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.controllers;


import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.exception.ResourceNotFoundException;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


//To define it as a controller we give annotation as @RestController, so that compiler will know that it's a rest controller.
@RestController
@RequestMapping(path = "/employees") //This is basically the parent path definition, as we are sure always that since this is a employees related things only and every link will be started via /employees only.
public class EmployeeController {



    //We are using the service layer here, and calling the service layer here.
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO
                .map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: "+id));
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(@RequestParam(required = false, name = "inputAge") Integer age,
                                                             @RequestParam(required = false) String sortBy) {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

//    @ExceptionHandler(NoSuchElementException.class)
//    public ResponseEntity<String> handleExceptionNotFound (NoSuchElementException noSuchElementException){
//        return new ResponseEntity<>("Employee not found ",HttpStatus.NOT_FOUND);
//    }

    @PostMapping(path = "/post")
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee) {
        EmployeeDTO savedEmployee = employeeService.createNewEmployee(inputEmployee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }


    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody @Valid EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeId, employeeDTO));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable @Valid Long employeeId) {
        boolean gotDeleted = employeeService.deleteEmployeeById(employeeId);
        if (gotDeleted) return ResponseEntity.ok(true);
        return ResponseEntity.notFound().build();
    }

    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                                                 @PathVariable Long employeeId) {
        EmployeeDTO employeeDTO = employeeService.updatePartialEmployeeById(employeeId, updates);
        if (employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeDTO);
    }


}


    /*
    Notes
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
