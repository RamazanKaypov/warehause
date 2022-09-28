package uz.data.warehause.service;

import org.springframework.stereotype.Service;
import uz.data.warehause.entity.Warehause;
import uz.data.warehause.repository.UserRepository;
import uz.data.warehause.repository.WarehauseRepository;

import java.util.List;
import java.util.Optional;
@Service
public class WarehauseService {
    final WarehauseRepository warehauseRepository;
    final UserRepository userRepository;

    public WarehauseService(WarehauseRepository warehauseRepository, UserRepository userRepository) {
        this.warehauseRepository = warehauseRepository;
        this.userRepository = userRepository;
    }

    public List<Warehause> getAllWarehause() {
        return warehauseRepository.findAll();
    }

    public Warehause getWarehauseById(Integer id) {
        Optional<Warehause> byId = warehauseRepository.findById(id);
        return byId.orElse(null);
    }

    public Result createWarehause(Warehause warehause) {
        if (warehauseRepository.existsWarehauseByName(warehause.getName())) {
            return new Result("This Warehause already exists!",false);
        } else {
            warehauseRepository.save(warehause);
            return new Result("Successfuly added!",true);
        }
    }

    public Result updateWarehause(Integer id, Warehause dto) {
        Optional<Warehause> byId = warehauseRepository.findById(id);
        if (byId.isEmpty()) return new Result("Warehause not found!",false);
        else {
            if (warehauseRepository.existsWarehauseByName(dto.getName())) {
                return new Result("This Warehause already exists!",false);
            } else {
                Warehause warehause=byId.get();
                warehause.setName(dto.getName());
                warehause.setStatus(dto.getStatus());
                warehauseRepository.save(warehause);
                return new Result("Successfuly updated!",true);
            }
        }
    }

    public Result deleteWarehause(Integer id){
        Optional<Warehause> byId = warehauseRepository.findById(id);
        if (byId.isEmpty()) return new Result("Warehause not found!",false);
        else {
            if (userRepository.existsUsersByWarehauses(id)){
              return new Result("In this Warehause exists users!",false);
            }else {
                warehauseRepository.deleteById(id);
                return new Result("Successfuly deleted!", true);
            }
        }
    }

}
