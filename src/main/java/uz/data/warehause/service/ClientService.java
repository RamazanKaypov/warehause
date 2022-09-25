package uz.data.warehause.service;

import uz.data.warehause.entity.Client;
import uz.data.warehause.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

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

    public String createClient(Client dto){
        if (clientRepository.existsClientByPhoneNumber(dto.getPhoneNumber())){
            return "This Phone Number already exists!";
        }else {
            clientRepository.save(dto);
            return "Successfuly added!";
        }
    }

    public String updateClient(Client dto, Integer id){
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isEmpty()) return "Client not found!";
        else {
            if (clientRepository.existsClientByPhoneNumber(dto.getPhoneNumber())){
                return "This Phone Number already exists!";
            }else {
                Client client=byId.get();
                client.setFirstname(dto.getFirstname());
                client.setLastname(dto.getLastname());
                client.setPhoneNumber(dto.getPhoneNumber());
                clientRepository.save(client);
                return "Succcessfully updated!";
            }
        }
    }

    public String deleteClient(Integer id){
        Optional<Client> byId = clientRepository.findById(id);
        if (byId.isEmpty()) return "Client not found!";
        else {
            clientRepository.deleteById(id);
            return "Successfuly deleted!";
        }
    }

}
