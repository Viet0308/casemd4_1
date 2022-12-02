package codegym.repository;

import codegym.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepo extends PagingAndSortingRepository<Student, Long> {
    @Query(nativeQuery = true, value = "SELECT * from student where name like concat('%',:name,'%')")
    List<Student> findByName(@Param("name") String name);
}
