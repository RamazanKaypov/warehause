package uz.data.warehause.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehause.DTO.OutputDto;
import uz.data.warehause.entity.Client;
import uz.data.warehause.entity.Currency;
import uz.data.warehause.entity.Output;
import uz.data.warehause.entity.Warehause;
import uz.data.warehause.repository.ClientRepository;
import uz.data.warehause.repository.CurrencyRepository;
import uz.data.warehause.repository.OutputRepository;
import uz.data.warehause.repository.WarehauseRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OutputService {
    OutputRepository outputRepository;
    WarehauseRepository warehauseRepository;
    CurrencyRepository currencyRepository;
    ClientRepository clientRepository;

    public List<Output> getAll(){
        return outputRepository.findAll();
    }

    public Output getById(Integer id){
        Optional<Output> byId = outputRepository.findById(id);
        return byId.orElse(null);
    }

    public Result create(OutputDto dto){
        Optional<Warehause> warehauseById = warehauseRepository.findById(dto.getWarehauseId());
        if (warehauseById.isEmpty()) return new Result("Warehause not found!",false);
        Warehause warehause=warehauseById.get();
        Optional<Currency> currencyById = currencyRepository.findById(dto.getClientId());
        if (currencyById.isEmpty())return new Result("Currency not found!",false);
        Currency currency=currencyById.get();
        Optional<Client> clientById = clientRepository.findById(dto.getClientId());
        if (clientById.isEmpty()) return new Result("Client not found!",false);
        Client client=clientById.get();
        String code= UUID.randomUUID().toString();
        Output output=new Output(null,dto.getTimestamp(),warehause,currency,dto.getFacture_number(),code,client);
        outputRepository.save(output);
        return new Result("Successfully added!",true);
    }

    public Result update(OutputDto dto,Integer id){
        Optional<Output> outputById = outputRepository.findById(id);
        if (outputById.isEmpty()) return new Result("Output not found!",false);
        Output output=outputById.get();
        Optional<Warehause> warehauseById = warehauseRepository.findById(dto.getWarehauseId());
        if (warehauseById.isEmpty()) return new Result("Warehause not found!",false);
        Warehause warehause=warehauseById.get();
        Optional<Currency> currencyById = currencyRepository.findById(dto.getClientId());
        if (currencyById.isEmpty())return new Result("Currency not found!",false);
        Currency currency=currencyById.get();
        Optional<Client> clientById = clientRepository.findById(dto.getClientId());
        if (clientById.isEmpty()) return new Result("Client not found!",false);
        Client client=clientById.get();
        output.setTimestamp(dto.getTimestamp());
        output.setWarehause(warehause);
        output.setCurrency(currency);
        output.setFacture_number(dto.getFacture_number());
        output.setClient(client);
        outputRepository.save(output);
        return new Result("Successfully updated!",true);
    }

    public Result delete(Integer id){
        Optional<Output> outputById = outputRepository.findById(id);
        if (outputById.isEmpty()) return new Result("Output not found!",false);
        outputRepository.deleteById(id);
        return new Result("Successfully deleted!",false);
    }
}
