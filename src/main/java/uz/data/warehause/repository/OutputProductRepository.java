package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.OutputProduc;

public interface OutputProductRepository extends JpaRepository<OutputProduc,Integer> {
}
