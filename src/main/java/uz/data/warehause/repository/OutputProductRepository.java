package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.OutputProduc;

import java.util.List;

public interface OutputProductRepository extends JpaRepository<OutputProduc,Integer> {

    List<OutputProduc> getOutputProducsByOutput_Id(Integer output_id);
}
