package uz.data.warehause.service;

import org.springframework.stereotype.Service;
import uz.data.warehause.DTO.UsersDto;
import uz.data.warehause.entity.Users;
import uz.data.warehause.entity.Warehause;
import uz.data.warehause.repository.UserRepository;
import uz.data.warehause.repository.WarehauseRepository;

import java.util.*;

@Service
public class UserService {
    final UserRepository userRepository;
    final WarehauseRepository warehauseRepository;

    public UserService(UserRepository userRepository, WarehauseRepository warehauseRepository) {
        this.userRepository = userRepository;
        this.warehauseRepository = warehauseRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public List<Users> getUsersByWarehauseId(Integer id){
        Optional<Warehause> byId = warehauseRepository.findById(id);
        if (byId.isPresent()) {
            return userRepository.getUsersByWarehausesId(id);
        } else {
            return null;
        }
    }

    public Users getUsersById(Integer id) {
        Optional<Users> byId = userRepository.findById(id);
        return byId.orElse(null);
    }

    public Result createUseres(UsersDto dto) {
        Set<Warehause> set=new LinkedHashSet<>();
        String code=UUID.randomUUID().toString();
        if (userRepository.existsUsersByCode(code) && userRepository.existsUsersByPassword(dto.getPassword())
                && userRepository.existsUsersByPhoneNumber(dto.getPhoneNumber())) {
            return new Result("This Code, Phone Number or Password already exists!", false);
        } else {
            for (Warehause warehause : warehauseRepository.findAllById(dto.getWarehauseIds())) {
                if (warehauseRepository.existsWarehauseById(warehause.getId())){
                    set.add(warehause);
                }else {
                    return new Result("Warehause not found!", false);
                }
            }
            Users users=new Users(null,dto.getFirstname(), dto.getLastname(), dto.getPhoneNumber(),code, dto.getPassword(),set,dto.getStatus() );
            userRepository.save(users);
            return new Result("Successfuly added!",true);
        }
    }

    public Result updateUsers(UsersDto dto,Integer id){
        Optional<Users> byId = userRepository.findById(id);
        Set<Warehause> set=new LinkedHashSet<>();
        if (byId.isEmpty()) return new Result("User not found!",false);
        else {
            if ( userRepository.existsUsersByPassword(dto.getPassword())
                    && userRepository.existsUsersByPhoneNumber(dto.getPhoneNumber())) {
                return new Result("This  Phone Number or Password already exists!", false);
            } else {
                for (Warehause warehause : warehauseRepository.findAllById(dto.getWarehauseIds())) {
                    if (warehauseRepository.existsWarehauseById(warehause.getId())) {
                        set.add(warehause);
                    } else {
                        return new Result("Warehause not found!", false);
                    }
                }
                Users users=byId.get();
                users.setFirstname(dto.getFirstname());
                users.setLastname(dto.getLastname());
                users.setPhoneNumber(dto.getPhoneNumber());
                users.setPassword(dto.getPassword());
                users.setStatus(dto.getStatus());
                users.setWarehauses(set);
                userRepository.save(users);
                return new Result("Successfuly added!", true);
            }
        }
    }

    public Result deleteUsers(Integer id){
        Optional<Users> byId = userRepository.findById(id);
        if (byId.isEmpty()) return new Result("User not found!",false);
        else{
            userRepository.deleteById(id);
            return new Result("Successfuly deleted!",true);
        }
    }


}
