package codegym.controller;

import codegym.model.ClassRoom;
import codegym.service.impl.IClassRoomService;
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
@RequestMapping("classrooms")
public class ClassRoomAPI {
    @Autowired
    IClassRoomService iClassRoomService;

    @GetMapping
    public ResponseEntity<List<ClassRoom>> getALl(){
        return new ResponseEntity<>(iClassRoomService.getAll(), HttpStatus.OK);
    }
}
