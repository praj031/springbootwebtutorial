package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.repositories;

import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.entities.DepartmentEntities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntities, Long> {

    //This is just and layer to interact to the DB and to store the value in the DB

}
