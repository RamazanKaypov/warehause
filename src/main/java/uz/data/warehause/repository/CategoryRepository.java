package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Category;

public interface CategoryRepository  extends JpaRepository<Category,Integer> {
}
