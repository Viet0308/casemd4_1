package codegym.repository;

import codegym.model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepo extends PagingAndSortingRepository<Student, Long> {
    @Query(nativeQuery = true, value = "SELECT * from student where name like concat('%',:name,'%')")
    List<Student> findByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "SELECT * FROM student where fee_status = false and datediff(expire_date,curdate()) <=3")
    List<Student> findStudentExpireFee();

    @Query(nativeQuery = true, value = "SELECT * from student left join classroom on classRoom_id = classroom.id where classRoom.id in (1,2,3,4)")
    List<Student> studentAvgScore();
}
