package uz.data.warehause.service;

import org.springframework.stereotype.Service;
import uz.data.warehause.entity.Currency;
import uz.data.warehause.repository.CurrencyRepository;

import java.util.List;
import java.util.Optional;
@Service
public class CurrencyService {
    final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public List<Currency> getAllCurrency(){
        return currencyRepository.findAll();
    }

    public Currency getCurrencyById(Integer id){
        Optional<Currency> byId = currencyRepository.findById(id);
        return byId.orElse(null);
    }

    public Result createCurrency(Currency dto){
        if (currencyRepository.existsCurrencyByName(dto.getName())){
            return new Result("This Currency already exists!",false);
        } else {
            currencyRepository.save(dto);
            return new Result("Successfule added!",true);
        }
    }

    public Result updateCurrency(Currency dto, Integer id){
        Optional<Currency> byId = currencyRepository.findById(id);
        if (byId.isEmpty()) return new Result("Currencu not found!",false);
        else {
            if (currencyRepository.existsCurrencyByName(dto.getName())){
                return new Result("This Currency already exists!",false);
            } else {
                Currency currency=byId.get();
                currency.setName(dto.getName());
                currency.setStatus(dto.getStatus());
                currencyRepository.save(currency);
                return new Result("Successsfully updated!",true);
            }
        }
    }

    public Result deleteCurrency(Integer id){
        Optional<Currency> byId = currencyRepository.findById(id);
        if (byId.isEmpty()) return new Result("Currencu not found!",false);
        else {
            currencyRepository.deleteById(id);
            return new Result("Successfuly deleted!",true);
        }
    }
}
