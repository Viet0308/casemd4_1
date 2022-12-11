package codegym.service.impl;

import codegym.model.Student;
import codegym.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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

    @Override
    public List<Student> findByName(String name) {
        return iStudentRepo.findByName(name);
    }

    @Override
    public  List<Student> findStudentExpireFee() {
//        List<Student> data = iStudentRepo.findStudentExpireFee();
//        List<Student> newData;
//        for (int i = 0; i < data.size(); i++) {
//            Date expireDate = data.get(i).getExpire_date();
//            Date now = new Date;
//            // so sanh date nho hon 3 thi push data vao 1 mang moi
//            if () {
//                newData.add(data.get(i));
//            }
//        }
//        // return mang moi
        return iStudentRepo.findStudentExpireFee();
    }
    @Override
    public List<Student> getClassAvgScores() { return iStudentRepo.studentAvgScore(); }
}
