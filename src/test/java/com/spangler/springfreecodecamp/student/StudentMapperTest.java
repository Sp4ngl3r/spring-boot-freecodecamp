package com.spangler.springfreecodecamp.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void should_convert_StudentRequestDto_to_Student() {

        StudentRequestDto studentRequestDto = new StudentRequestDto(
                "Jennifer",
                "Law",
                "jennylaw@email.com",
                1L
        );

        Student student = studentMapper.studentRequestDtoToStudent(studentRequestDto);

        assertEquals("Jennifer", student.getFirstName());
        assertEquals("Law", student.getLastName());
        assertEquals("jennylaw@email.com", student.getEmail());

        assertNotNull(student.getSchool());

        assertEquals(1, student.getSchool().getId());
    }

    @Test
    public void should_throwNullPointerException_when_studentRequestDtoIsNull() {
        Exception exception = assertThrows(NullPointerException.class, () -> studentMapper.studentRequestDtoToStudent(null));
        assertEquals("Student Dto cannot be null.", exception.getMessage());
    }

    @Test
    public void should_convert_Student_to_StudentResponseDto() {

        Student student = new Student(
                "Peter",
                "Griffin",
                "peter@emial.com",
                23
        );

        StudentResponseDto studentResponseDto = studentMapper.studentToStudentResponseDto(student);

        assertEquals("Peter", studentResponseDto.firstName());
        assertEquals("Griffin", studentResponseDto.lastName());
        assertEquals("peter@emial.com", studentResponseDto.email());
    }
}