package pl.mariuszg95.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mariuszg95.spring.data.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
