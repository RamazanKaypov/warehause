package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Input;

public interface InputRepository extends JpaRepository<Input,Integer> {
}
