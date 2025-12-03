package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.services;

import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.dto.DepartmentDTO;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.entities.DepartmentEntities;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.exception.ResourceNotFoundException;
import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.repositories.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {


    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    public void isDepartmentIdExist(Long id) {
        boolean exists = departmentRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Department not found with id: "+id);
    }

    public List<DepartmentDTO> getDepartmentAll() {

        List<DepartmentEntities> departmentEntity = departmentRepository.findAll();
        return departmentEntity
                .stream()
                .map(departmentEntities -> modelMapper.map(departmentEntities, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public Optional<DepartmentDTO> findById(Long id) {
        return departmentRepository.findById(id)
                .map(departmentEntities ->
                        modelMapper.map(departmentEntities, DepartmentDTO.class));
    }


    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntities toSaveEntity = modelMapper.map(departmentDTO, DepartmentEntities.class);
        DepartmentEntities savedDepartmentEntity = departmentRepository.save(toSaveEntity);
        return modelMapper.map(savedDepartmentEntity, DepartmentDTO.class);
    }

    public boolean deleteDepartmentById(Long id){
        isDepartmentIdExist(id);
        departmentRepository.deleteById(id);
        return true;
    }

    public DepartmentDTO updateDepartmentByID(Long id, DepartmentDTO departmentDTO){
        isDepartmentIdExist(id);
        DepartmentEntities existing = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        modelMapper.map(departmentDTO, existing);
        existing.setId(id);
        DepartmentEntities saved = departmentRepository.save(existing);
        return modelMapper.map(saved, DepartmentDTO.class);
    }


}
