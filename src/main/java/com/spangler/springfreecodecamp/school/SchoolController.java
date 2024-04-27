package com.spangler.springfreecodecamp.school;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class SchoolController {

    private final SchoolService schoolService;

    SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


//    @PostMapping("schools")
//    public School createSchool(
//            @RequestBody School school
//    ) {
//        return schoolRepository.save(school);
//    }

    @PostMapping("schools")
    public SchoolDto createSchool(
            @RequestBody SchoolDto schoolDto
    ) {
        return schoolService.createSchool(schoolDto);
    }

    @GetMapping("schools")
    public List<SchoolDto> getAllSchools() {
        return schoolService.getAllSchools();
    }
}
