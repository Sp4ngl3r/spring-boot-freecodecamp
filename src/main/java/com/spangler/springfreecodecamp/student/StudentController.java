package com.spangler.springfreecodecamp.student;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("students")
    List<StudentResponseDto> getAllStudents() {
        return studentService.getAllStudents();
    }

//    The following method is for saving Student Entity directly
//    @PostMapping("students")
//    Student createStudent(
//            @RequestBody Student student
//    ) {
//        return studentRepository.save(student);
//    }

//    The following method accepts StudentRequestDto and saves the necessary data into Student model
//    @PostMapping("students")
//    Student createStudent(
//            @RequestBody StudentRequestDto studentRequestDto
//    ) {
//        Student student = this.studentDtoToStudent(studentDto);
//
//        return studentRepository.save(student);
//    }

    //    The following method accepts StudentRequestDto and provides StudentResponseDto as the response
    @PostMapping("students")
    StudentResponseDto createStudent(
            @Valid @RequestBody StudentRequestDto studentRequestDto
    ) {
        return studentService.createStudent(studentRequestDto);
    }

    @GetMapping("students/{student-id}")
    Optional<StudentResponseDto> getStudentById(
            @PathVariable("student-id") Long studentId
    ) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping("students/name")
    List<StudentResponseDto> getStudentsByName(
            @RequestParam("first-name") String firstName,
            @RequestParam("last-name") String lastName

    ) {
        return studentService.getStudentsByName(firstName, lastName);
    }

    @PostMapping("students/edit/{student-id}")
    void updateStudentById(
            @PathVariable("student-id") Long studentId,
            @RequestBody Student student
    ) {
        studentService.updateStudentById(studentId, student);
    }

    @DeleteMapping("students/{student-id}")
    void removeStudentById(
            @PathVariable("student-id") Long studentId
    ) {
        studentService.removeStudentById(studentId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {
        Map<String, String> errors = new HashMap<>();

        exception.getBindingResult()
                .getAllErrors()
                .forEach(error -> {
                    String fieldWithError = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();

                    errors.put(fieldWithError, errorMessage);
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
