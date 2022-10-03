package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.InputProduct;

import java.util.List;

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {

    List<InputProduct> getInputProductsByInput_Id(Integer input_id);
}
