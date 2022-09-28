package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Currency;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {

    boolean existsCurrencyByName(String name);
}
