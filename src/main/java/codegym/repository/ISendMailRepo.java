package codegym.repository;

import codegym.model.Student;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ISendMailRepo extends PagingAndSortingRepository<Student,Long> {
}
