package intership.project.ecomerce.repository.admin;

import intership.project.ecomerce.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<User, Integer> {
}
