package codegym.repository;

import codegym.model.ClassRoom;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IClassRoomRepo extends PagingAndSortingRepository<ClassRoom,Long> {
}
