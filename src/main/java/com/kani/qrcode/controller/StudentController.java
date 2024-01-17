package com.kani.qrcode.controller;


import com.google.zxing.WriterException;
import com.kani.qrcode.entity.Student;
import com.kani.qrcode.service.IStudentService;
import com.kani.qrcode.utils.QRCodeGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/students")
public class StudentController {
    private final IStudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudentList() throws IOException, WriterException {
        List<Student> students = studentService.getAllStudents();
        if(students.size() != 0){
            for(Student student : students){
                QRCodeGenerator.generateQRCode(student);
            }
        }
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/create")
    public Student saveStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable("id") Long studentId){
        return studentService.findStudentById(studentId);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudentById(studentId);
    }
}
