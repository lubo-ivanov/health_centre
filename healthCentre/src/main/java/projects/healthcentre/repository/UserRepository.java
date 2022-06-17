package projects.healthcentre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projects.healthcentre.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
