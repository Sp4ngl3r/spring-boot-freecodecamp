package com.spangler.springfreecodecamp.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    private List<StudentResponseDto> convertStudentListToStudentResponseDtoList(List<Student> studentList) {
        return studentList
                .stream()
                .map(studentMapper::studentToStudentResponseDto)
                .collect(Collectors.toList());
    }

    List<StudentResponseDto> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return convertStudentListToStudentResponseDtoList(studentList);
    }

    StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {
        Student student = studentMapper.studentRequestDtoToStudent(studentRequestDto);
        Student savedStudent = studentRepository.save(student);

        return studentMapper.studentToStudentResponseDto(savedStudent);
    }

    Optional<StudentResponseDto> getStudentById(Long studentId) {
        return studentRepository.findById(studentId)
                .map(studentMapper::studentToStudentResponseDto);
    }

    List<StudentResponseDto> getStudentsByName(String firstName, String lastName) {
        List<Student> studentList = studentRepository.findAllByFirstNameAndLastName(firstName, lastName);

        return convertStudentListToStudentResponseDtoList(studentList);
    }

    void updateStudentById(Long studentId, Student student) {
        Student studentToBeUpdated = studentRepository.findById(studentId).orElse(null);

        if (studentToBeUpdated == null) {
            return;
        }
        
        studentToBeUpdated.setFirstName(student.getFirstName());
        studentToBeUpdated.setLastName(student.getLastName());
        studentToBeUpdated.setEmail(student.getEmail());
        studentToBeUpdated.setAge(student.getAge());

        studentRepository.save(studentToBeUpdated);
    }

    void removeStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
