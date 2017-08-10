package studentScore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentScore.entity.Course;

/**
 * Created by rsma on 10/08/2017.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseName(String courseName);
}
