package com.example.Basic.curd.Service;

import com.example.Basic.curd.Repository.StudentRepository;
import com.example.Basic.curd.model.StudentEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;


    public StudentEntity createstudent(StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }


    public Optional <StudentEntity> getbyId(Long id){
        return studentRepository.findById(id);
    }


    public StudentEntity update(StudentEntity studentEntity){
        return studentRepository.save(studentEntity);
    }

    public Page<StudentEntity> getall(int page, int size){
        Pageable pageable =getpagable(page, size);
        return studentRepository.findAll(pageable);
    }


    public void delete(Long id){
         studentRepository.deleteById(id);
    }


    public Pageable getpagable(int page, int size) {
        return PageRequest.of(page,size);
    }
}
