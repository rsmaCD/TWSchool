package studentScore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentScore.entity.Student;

/**
 * Created by rsma on 10/08/2017.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
    Student findByName(String name);
    Student findById(String id);

}
