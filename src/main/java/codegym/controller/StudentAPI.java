package codegym.controller;

import codegym.model.Student;
import codegym.service.impl.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity save(@RequestBody Student student){
        iStudentService.save(student);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Student>> findByName(@PathVariable String name){
        return new ResponseEntity<>(iStudentService.findByName(name), HttpStatus.OK);
    }
}
