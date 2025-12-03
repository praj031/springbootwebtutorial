package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.controllers;



import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.dto.DepartmentDTO;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.services.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;

@RestController
@RequestMapping(path="/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    //Controller 1
    @GetMapping(path = "/alldepart")
    public List<DepartmentDTO> getDepartmentAll (){
        return departmentService.getDepartmentAll();
    }
    //Controller 2
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable Long id) {
        return departmentService.findById(id)          // type: Optional<DepartmentDTO>
                .map(ResponseEntity::ok)               // OK if present
                .orElseGet(() -> ResponseEntity.notFound().build()); // 404 if not
    }
    //Controller 3
    @PostMapping(path  = "/Post")
    public DepartmentDTO createDepartment(@RequestBody @Valid  DepartmentDTO departmentDTO){
        return departmentService.createDepartment(departmentDTO);
    }
    //Controller 4
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartmentById(id);
        return ResponseEntity.noContent().build();
    }
    //Controller 5
    @PutMapping(path = "/{id}")
    public DepartmentDTO updateDepartment(@RequestBody DepartmentDTO departmentDTO, @PathVariable Long id){
        return departmentService.updateDepartmentByID(id,departmentDTO);
    }


}
