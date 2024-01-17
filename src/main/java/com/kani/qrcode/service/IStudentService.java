package com.kani.qrcode.service;

import com.kani.qrcode.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> getAllStudents();
    Student createStudent(Student student);
    Student findStudentById(Long studentId);
    void deleteStudentById(Long studentId);
}
