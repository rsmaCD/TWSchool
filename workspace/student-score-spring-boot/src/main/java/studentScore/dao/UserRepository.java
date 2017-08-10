package studentScore.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentScore.entity.User;

/**
 * Created by rsma on 10/08/2017.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
    User findByNameAndAge(String name, Integer age);
}
