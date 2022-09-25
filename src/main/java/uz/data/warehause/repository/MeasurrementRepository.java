package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Measurement;

public interface MeasurrementRepository extends JpaRepository<Measurement,Integer> {
}
