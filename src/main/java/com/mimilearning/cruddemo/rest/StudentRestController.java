package com.mimilearning.cruddemo.rest;

import com.mimilearning.cruddemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private
    //define  an endpoint for "/students" to return a list of students
    List<Student> theStudents ;
    // load rhe students list with some data using the @PostConstruct that is called only once , when the bean is constructed
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Lolitta", "Doe"));
        theStudents.add(new Student("Hannah", "Montana"));
        theStudents.add(new Student("Cherry", "Rossi"));
    }
    @GetMapping("/students")
    public List<Student> getStudents(){
        return  theStudents ;
    }
    // define enpoint for retrieving a single student by id
    @GetMapping("/students/{studentId}") // {} is used for path variable
    public Student getStudents(@PathVariable int studentId){ // by default variables should match up
        // just index into the list
        // check te studentId against the list size
        if (studentId>= theStudents.size()||studentId<0 ){
            throw new StudentNotFoundException("Student id not found - "+studentId);
        }
        return  theStudents.get(studentId) ;
    }

    // Add an exception handler using @ExceptionHandler



    }
