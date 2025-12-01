package com.example.Basic.curd.Controller;

import com.example.Basic.curd.Service.StudentService;
import com.example.Basic.curd.model.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<StudentEntity>create(@RequestBody StudentEntity studentEntity){
        StudentEntity createstudent=studentService.createstudent(studentEntity);
        return new ResponseEntity(createstudent,HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
     ResponseEntity<StudentEntity>getbyid(@PathVariable Long id){
        Optional<StudentEntity> getbyid=studentService.getbyId(id);
        return new ResponseEntity(getbyid,HttpStatus.OK);
    }



    @PutMapping("/update")
    public ResponseEntity<StudentEntity>updte(@RequestBody StudentEntity studentEntity){
        StudentEntity createstudent=studentService.update(studentEntity);
        return new ResponseEntity(createstudent,HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<StudentEntity>>getall(){
      List<StudentEntity> student=studentService.getall();
      return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    void  delete(@PathVariable Long id){
    studentService.delete(id);


    }

}
