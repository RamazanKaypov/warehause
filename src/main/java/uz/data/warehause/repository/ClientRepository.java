package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Client;

public interface ClientRepository extends JpaRepository<Client,Integer> {

    boolean existsClientByPhoneNumber(String phoneNumber);
}
