package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Warehause;

public interface WarehauseRepository extends JpaRepository<Warehause, Integer> {
    boolean existsWarehauseByName(String name);
}
