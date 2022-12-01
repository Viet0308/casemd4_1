package codegym.service.impl;

import codegym.model.ClassRoom;
import codegym.repository.IClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassRoomService implements IClassRoomService {
    @Autowired
    IClassRoomRepo iClassRoomRepo;

    @Override
    public List<ClassRoom> getAll() {
        return (List<ClassRoom>) iClassRoomRepo.findAll();
    }

    @Override
    public void save(ClassRoom classRoom) {
        iClassRoomRepo.save(classRoom);
    }

    @Override
    public void delete(long id) {
        iClassRoomRepo.deleteById(id);
    }

    @Override
    public ClassRoom findById(long id) {
        return iClassRoomRepo.findById(id).get();
    }
}
