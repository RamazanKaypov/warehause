package uz.data.warehause.service;

import org.springframework.stereotype.Service;
import uz.data.warehause.entity.Supplier;
import uz.data.warehause.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SupplierService {
    final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public List<Supplier> getAllSupplier() {
        return supplierRepository.findAll();
    }

    public Supplier getSupplierById(Integer id) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        return byId.orElse(null);
    }

    public Result createSupplier(Supplier dto) {
        if (supplierRepository.existsSupplierByPhoneNumber(dto.getPhoneNumber())) {
            return new Result("This Phone Number already exists!",false);
        } else {
            supplierRepository.save(dto);
            return new Result("Successfuly added!",true);
        }
    }

    public Result updateSupplier(Supplier dto, Integer id) {
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isEmpty()) return new Result("Supplier not found!",false);
        else {
            if (supplierRepository.existsSupplierByPhoneNumber(dto.getPhoneNumber())) {
                return new Result("This Phone Number already exists!",false);
            } else {
                Supplier supplier=byId.get();
                supplier.setName(dto.getName());
                supplier.setStatus(dto.getStatus());
                supplier.setPhoneNumber(dto.getPhoneNumber());
                supplierRepository.save(supplier);
                return new Result("Successfuly updated!",true);
            }
        }
    }

    public Result deleteSupplier(Integer id){
        Optional<Supplier> byId = supplierRepository.findById(id);
        if (byId.isEmpty()) return new Result("Supplier not found!",false);
        else {
            supplierRepository.deleteById(id);
            return new Result("Successfully deleted!",true);
        }
    }
}
