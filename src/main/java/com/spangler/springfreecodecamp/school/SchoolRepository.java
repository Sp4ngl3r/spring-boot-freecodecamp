package com.spangler.springfreecodecamp.school;

import org.springframework.data.jpa.repository.JpaRepository;

interface SchoolRepository extends JpaRepository<School, Long> {

}
