package intership.project.ecomerce.repository.user;

import intership.project.ecomerce.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> searchUserByNamee(String namee);
    Optional<User> searchUserById(Long id);
}
