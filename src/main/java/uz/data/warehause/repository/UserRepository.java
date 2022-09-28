package uz.data.warehause.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.data.warehause.entity.Users;

import java.util.List;

public interface UserRepository extends JpaRepository<Users,Integer> {

    boolean existsUsersByCode(String code);

    boolean existsUsersByPassword(String password);

    boolean existsUsersByPhoneNumber(String phoneNumber);

    boolean existsUsersByWarehauses(Integer warehauses);

    List<Users> getUsersByWarehausesId(Integer warehause_id);
}
