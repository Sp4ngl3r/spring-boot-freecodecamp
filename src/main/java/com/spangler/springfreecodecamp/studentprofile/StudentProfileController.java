package com.spangler.springfreecodecamp.studentprofile;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
class StudentProfileController {

    private final StudentProfileRepository studentProfileRepository;

    StudentProfileController(StudentProfileRepository studentProfileRepository) {
        this.studentProfileRepository = studentProfileRepository;
    }

    @PostMapping("student-profile")
    public StudentProfile createStudentProfile(
            @RequestBody StudentProfile studentProfile
    ) {
        return studentProfileRepository.save(studentProfile);
    }

    @GetMapping("student-profile")
    public List<StudentProfile> getAllStudentProfiles() {
        return studentProfileRepository.findAll();
    }
}
