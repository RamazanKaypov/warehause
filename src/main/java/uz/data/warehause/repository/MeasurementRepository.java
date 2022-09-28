package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Measurement;

public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {

    boolean existsMeasurementByName(String name);
}
