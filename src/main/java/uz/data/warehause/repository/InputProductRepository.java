package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.InputProduct;

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
}
