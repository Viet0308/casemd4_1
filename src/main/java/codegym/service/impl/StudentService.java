package codegym.service.impl;

import codegym.model.Student;
import codegym.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    IStudentRepo iStudentRepo;

    @Override
    public List<Student> getAll() {
        return (List<Student>) iStudentRepo.findAll();
    }

    @Override
    public void save(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public void delete(long id) {
        iStudentRepo.deleteById(id);
    }

    @Override
    public Student findById(long id) {
        return iStudentRepo.findById(id).get();
    }
}
