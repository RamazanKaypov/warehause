package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer> {
}
