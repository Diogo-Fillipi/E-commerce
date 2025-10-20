package intership.project.ecomerce.repository.user;

import intership.project.ecomerce.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
