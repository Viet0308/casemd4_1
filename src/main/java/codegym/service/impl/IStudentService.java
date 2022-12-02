package codegym.service.impl;

import codegym.model.Student;
import codegym.service.ICRUD_Service;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentService extends ICRUD_Service<Student> {
    List<Student> findByName(String name);

}
