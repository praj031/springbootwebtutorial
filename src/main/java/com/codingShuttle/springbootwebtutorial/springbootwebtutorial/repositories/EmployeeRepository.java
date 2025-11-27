package com.codingShuttle.springbootwebtutorial.springbootwebtutorial.repositories;

import com.codingShuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

    //Custom query class
    //List<EmployeeEntity> findbyname ();
    //So, the spring JPA already has some complex query defined already, so we don't need to define it, we can just mention the requirement, and it will be autoconfigured.


}
