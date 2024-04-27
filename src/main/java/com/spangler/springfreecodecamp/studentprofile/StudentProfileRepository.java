package com.spangler.springfreecodecamp.studentprofile;

import org.springframework.data.jpa.repository.JpaRepository;

interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {

}
