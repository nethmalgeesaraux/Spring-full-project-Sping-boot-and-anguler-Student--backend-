package net.school.student_backend.service.impl;

import lombok.AllArgsConstructor;
import net.school.student_backend.dto.StudentDto;
import net.school.student_backend.entity.Student;
import net.school.student_backend.mapper.StudentMapper;
import net.school.student_backend.repository.StudentRepository;
import net.school.student_backend.service.StudentService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentImpl implements StudentService {

    private StudentRepository studentRepository;

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + studentId));
        return StudentMapper.mapToStudentDto(student);

    }


}
