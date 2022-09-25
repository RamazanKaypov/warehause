package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier,Integer> {
}
