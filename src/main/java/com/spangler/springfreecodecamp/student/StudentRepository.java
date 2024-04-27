package com.spangler.springfreecodecamp.student;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByFirstNameAndLastName(String firstName, String lastName);
}
