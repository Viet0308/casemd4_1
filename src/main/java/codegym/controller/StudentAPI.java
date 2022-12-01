package codegym.controller;

import codegym.model.Student;
import codegym.service.impl.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("students")
public class StudentAPI {
    @Autowired
    IStudentService iStudentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAll(){
        return new ResponseEntity<>(iStudentService.getAll(), HttpStatus.OK);
    }
}
