package com.kani.qrcode.service;

import com.kani.qrcode.entity.Student;
import com.kani.qrcode.repository.IStudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService{
    private final IStudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Student findStudentById(Long studentId){
        return studentRepository.findById(studentId)
                .orElseThrow(()-> new UsernameNotFoundException("Student not found"));
    }

    @Override
    public void deleteStudentById(Long studentId) {
        studentRepository.deleteById(studentId);
    }
}
