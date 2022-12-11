package codegym.repository;

import codegym.model.ClassRoom;
import codegym.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IClassRoomRepo extends PagingAndSortingRepository<ClassRoom,Long> {
}
