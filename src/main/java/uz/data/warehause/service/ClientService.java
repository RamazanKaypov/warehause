package uz.data.warehause.service;

import org.springframework.stereotype.Service;
import uz.data.warehause.entity.Client;
import uz.data.warehause.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
@Service
public class ClientService {
    final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    public Client getClientById(Integer id){
        Optional<Client> byId = clientRepository.findById(id);
        return byId.orElse(null);
    }

    public Result createClient(Client dto){
        if (clientRepository.existsClientByPhoneNumber(dto.getPhoneNumber())){
            return new Result("This Phone Number already exists!",false);
        }else {
            clientRepository.save(dto);
            return new Result("Successfuly added!",true);
        }
    }

    public Result updateClient(Client dto, Integer id){
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isEmpty()) return new Result("Client not found!",false);
        else {
            if (clientRepository.existsClientByPhoneNumber(dto.getPhoneNumber())){
                return new Result("This Phone Number already exists!",false);
            }else {
                Client client=byId.get();
                client.setFirstname(dto.getFirstname());
                client.setLastname(dto.getLastname());
                client.setPhoneNumber(dto.getPhoneNumber());
                clientRepository.save(client);
                return new Result("Succcessfully updated!",true);
            }
        }
    }

    public Result deleteClient(Integer id){
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isEmpty()) return new Result("Client not found!",false);
        else {
            clientRepository.deleteById(id);
            return new Result("Successfuly deleted!",false);
        }
    }

}
