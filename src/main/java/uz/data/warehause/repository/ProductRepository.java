package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
