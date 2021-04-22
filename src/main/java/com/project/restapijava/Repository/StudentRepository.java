package com.project.restapijava.Repository;

import com.project.restapijava.Model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "others") // specify path rather than use data rest nonsense automation
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // this gives you basic crud automatically.
    // since the name of model is "Student" it will expose endpoint with base /students
    // several endpoint that is given to you are
    // 1. GET /students: get all students
    // 2. GET /students/{id}: get by id
    // 3. POST /students: save
    // 4. PUT /students/{id}: update by id
    // 4. DELETE /students/{id}: delete by id
}
