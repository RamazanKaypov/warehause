package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Output;

public interface OutputRepository extends JpaRepository<Output,Integer> {
}
