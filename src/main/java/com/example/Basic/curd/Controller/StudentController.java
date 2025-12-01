package com.example.Basic.curd.Controller;

import com.example.Basic.curd.Service.StudentService;
import com.example.Basic.curd.model.StudentEntity;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
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
    @ApiResponses(value={
            @ApiResponse(responseCode = "200", description = "Student Create Sucessfully")
    })
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
    public Page<StudentEntity> getall(@RequestParam int page, @RequestParam int size){
      return studentService.getall(page,size);
    }

    @DeleteMapping("/delete/{id}")
    void  delete(@PathVariable Long id){
    studentService.delete(id);


    }

}
