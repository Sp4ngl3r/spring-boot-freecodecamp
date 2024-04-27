package com.spangler.springfreecodecamp.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    @InjectMocks
    private StudentService studentService;

    @Mock
    private StudentRepository studentRepository;

    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateStudent() {
        // Arrange
        Student student = new Student(
                "John",
                "Wick",
                "johnwick@email.com",
                14
        );

        Student savedStudent = new Student(
                "John",
                "Wick",
                "johnwick@email.com",
                14
        );

        StudentRequestDto studentRequestDto = new StudentRequestDto(
                "John",
                "Wick",
                "johnwick@email.com",
                1L
        );

        // Mocking the services
        when(studentMapper.studentRequestDtoToStudent(studentRequestDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(savedStudent);
        when(studentMapper.studentToStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto("John", "Wick", "johnwick@email.com"));

        // Act
        StudentResponseDto studentResponseDto = studentService.createStudent(studentRequestDto);

        // Assert
        assertEquals("John", studentResponseDto.firstName());
        assertEquals("Wick", studentResponseDto.lastName());
        assertEquals("johnwick@email.com", studentResponseDto.email());
        verify(studentMapper, times(1)).studentRequestDtoToStudent(studentRequestDto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper, times(1)).studentToStudentResponseDto(savedStudent);
    }

    @Test
    public void testGetAllStudents() {
        // Arrange
        List<Student> students = new ArrayList<>();
        students.add(new Student("John", "Wick", "johnwick@email.com", 14));
        students.add(new Student("Sam", "Smith", "samsmith@email.com", 12));
        students.add(new Student("Jake", "Tran", "jaketran@email.com", 13));

        when(studentRepository.findAll()).thenReturn(students);
        when(studentMapper.studentToStudentResponseDto(any(Student.class))).thenReturn(
                new StudentResponseDto("John", "Wick", "johnwick@email.com"),
                new StudentResponseDto("Sam", "Smith", "samsmith@email.com"),
                new StudentResponseDto("Jake", "Tran", "jaketran@email.com")
        );

        // Act
        List<StudentResponseDto> studentResponseDtoList = studentService.getAllStudents();

        // Assert
        assertEquals(3, studentResponseDtoList.size());
        verify(studentRepository, times(1)).findAll();
    }

    @Test
    public void testGetStudentById() {
        // Arrange
        Long studentId = 1L;
        Student student = new Student("John", "Wick", "johnwick@email.com", 14);

        when(studentRepository.findById(studentId)).thenReturn(Optional.of(student));
        when(studentMapper.studentToStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto("John", "Wick", "johnwick@email.com"));

        // Act
        Optional<StudentResponseDto> studentResponseDto = studentService.getStudentById(studentId);

        // Assert
        assertThat(studentResponseDto).isPresent().isNotEmpty();
        assertEquals("John", studentResponseDto.get().firstName());
        assertEquals("Wick", studentResponseDto.get().lastName());
        assertEquals("johnwick@email.com", studentResponseDto.get().email());
        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    public void testGetStudentByName() {
        // Arrange
        String firstName = "Sam";
        String lastName = "Smith";

        List<Student> students = new ArrayList<>();
        students.add(new Student("Sam", "Smith", "samsmith@email.com", 12));

        when(studentRepository.findAllByFirstNameAndLastName(firstName, lastName)).thenReturn(students);
        when(studentMapper.studentToStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto("Sam", "Smith", "samsmith@email.com"));

        // Act
        List<StudentResponseDto> studentResponseDto = studentService.getStudentsByName(firstName, lastName);

        // Assert
        assertEquals(1, studentResponseDto.size());
        verify(studentRepository, times(1)).findAllByFirstNameAndLastName(firstName, lastName);
    }

    @Test
    public void testUpdateStudentById() {
        // Arrange
        Long studentId = 1L;
        Student student = new Student("John", "Wick", "johnwick@email.com", 14);

        // Act
        studentService.updateStudentById(studentId, student);

        // Assert
        verify(studentRepository, times(1)).findById(studentId);
    }

    @Test
    public void testRemoveStudentById() {
        // Arrange
        Long studentId = 2L;

        // Act
        studentService.removeStudentById(studentId);

        // Assert
        verify(studentRepository, times(1)).deleteById(studentId);
    }
}