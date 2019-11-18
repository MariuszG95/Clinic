package pl.mariuszg95.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mariuszg95.spring.data.model.User;

import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Query(value = "INSERT INTO users_roles (login, role) VALUES (?1, 'ROLE_USER')", nativeQuery = true)
    void setUserRole(String login);

    @Query(value = "select role from users_roles where login = ?", nativeQuery = true)
    String getUserRole(String login);

    User getByLogin(String login);

    User getById(Long id);

    Set<User> getUserByFirstNameContains(String value);

    Set<User> getUserByLastNameContains(String value);
}
