package com.spangler.springfreecodecamp.student;

import com.spangler.springfreecodecamp.school.School;
import org.springframework.stereotype.Component;

@Component
class StudentMapper {

    Student studentRequestDtoToStudent(StudentRequestDto studentRequestDto) {

        if (studentRequestDto == null) {
            throw new NullPointerException("Student Dto cannot be null.");
        }

        Student student = new Student();
        student.setFirstName(studentRequestDto.firstName());
        student.setLastName(studentRequestDto.lastName());
        student.setEmail(studentRequestDto.email());

        School school = new School();
        school.setId(studentRequestDto.schoolId());

        student.setSchool(school);

        return student;
    }

    StudentResponseDto studentToStudentResponseDto(Student student) {

        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }
}
