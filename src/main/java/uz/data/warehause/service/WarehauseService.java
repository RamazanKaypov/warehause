package uz.data.warehause.service;

import uz.data.warehause.entity.Warehause;
import uz.data.warehause.repository.WarehauseRepository;

import java.util.List;
import java.util.Optional;

public class WarehauseService {
    final WarehauseRepository warehauseRepository;

    public WarehauseService(WarehauseRepository warehauseRepository) {
        this.warehauseRepository = warehauseRepository;
    }

    public List<Warehause> getAllWarehause() {
        return warehauseRepository.findAll();
    }

    public Warehause getWarehauseById(Integer id) {
        Optional<Warehause> byId = warehauseRepository.findById(id);
        return byId.orElse(null);
    }

    public String createWarehause(Warehause warehause) {
        if (warehauseRepository.existsWarehauseByName(warehause.getName())) {
            return "This Warehause already exists!";
        } else {
            warehauseRepository.save(warehause);
            return "Successfuly added!";
        }
    }

    public String updateWarehause(Integer id, Warehause dto) {
        Optional<Warehause> byId = warehauseRepository.findById(id);
        if (byId.isEmpty()) return "Warehause not found!";
        else {
            if (warehauseRepository.existsWarehauseByName(dto.getName())) {
                return "This Warehause already exists!";
            } else {
                Warehause warehause=byId.get();
                warehause.setName(dto.getName());
                warehause.setStatus(dto.getStatus());
                warehauseRepository.save(warehause);
                return "Successfuly updated!";
            }
        }
    }

    public String deleteWarehause(Integer id){
        Optional<Warehause> byId = warehauseRepository.findById(id);
        if (byId.isEmpty()) return "Warehause not found!";
        else {
            warehauseRepository.deleteById(id);
            return "Successfuly deleted!";
        }
    }

}
