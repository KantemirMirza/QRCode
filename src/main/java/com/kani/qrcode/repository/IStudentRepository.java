package com.kani.qrcode.repository;

import com.kani.qrcode.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {

}
