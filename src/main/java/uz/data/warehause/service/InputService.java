package uz.data.warehause.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehause.DTO.InputDto;
import uz.data.warehause.entity.Currency;
import uz.data.warehause.entity.Input;
import uz.data.warehause.entity.Supplier;
import uz.data.warehause.entity.Warehause;
import uz.data.warehause.repository.CurrencyRepository;
import uz.data.warehause.repository.InputRepository;
import uz.data.warehause.repository.SupplierRepository;
import uz.data.warehause.repository.WarehauseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InputService {
    InputRepository inputRepository;
    WarehauseRepository warehauseRepository;
    CurrencyRepository currencyRepository;
    SupplierRepository supplierRepository;

    public List<Input> getAll(){
        return inputRepository.findAll();
    }

    public Input getByID(Integer id){
        Optional<Input> byId = inputRepository.findById(id);
        return  byId.orElse(null);
    }

    public Result create(InputDto dto){
        Optional<Warehause> warehauseById = warehauseRepository.findById(dto.getWarehauseId());
        if (warehauseById.isEmpty()) return new Result("Warehause not found!",false);
        Warehause warehause=warehauseById.get();
        Optional<Supplier> supplierById = supplierRepository.findById(dto.getSupplierId());
        if (supplierById.isEmpty())return new Result("Supplier not found!",false);
        Supplier supplier=supplierById.get();
        Optional<Currency> currencyById = currencyRepository.findById(dto.getCurrencyId());
        if (currencyById.isEmpty())return new Result("Currency not found!",false);
        Currency currency=currencyById.get();
        String code= UUID.randomUUID().toString();
        Input input=new Input(null,dto.getTimestamp(),warehause,supplier,currency, dto.getFacture_number(),code);
        inputRepository.save(input);
        return new Result("Successfully added!",true);
    }

    public Result update(InputDto dto,Integer id){
        Optional<Input> inputById = inputRepository.findById(id);
        if (inputById.isEmpty()) return new Result("Input not found!",false);
        Input input=inputById.get();
        Optional<Warehause> warehauseById = warehauseRepository.findById(dto.getWarehauseId());
        if (warehauseById.isEmpty()) return new Result("Warehause not found!",false);
        Warehause warehause=warehauseById.get();
        Optional<Supplier> supplierById = supplierRepository.findById(dto.getSupplierId());
        if (supplierById.isEmpty())return new Result("Supplier not found!",false);
        Supplier supplier=supplierById.get();
        Optional<Currency> currencyById = currencyRepository.findById(dto.getCurrencyId());
        if (currencyById.isEmpty())return new Result("Currency not found!",false);
        Currency currency=currencyById.get();
        input.setTimestamp(dto.getTimestamp());
        input.setWarehause(warehause);
        input.setCurrency(currency);
        input.setSupplier(supplier);
        input.setFacture_number(dto.getFacture_number());
        inputRepository.save(input);
        return new Result("Successfully updated!",true);
    }

    public Result delete(Integer id){
        Optional<Input> inputById = inputRepository.findById(id);
        if (inputById.isEmpty()) return new Result("Input not found!",false);
        inputRepository.deleteById(id);
        return new Result("Successfully deleted!",true);
    }
}
