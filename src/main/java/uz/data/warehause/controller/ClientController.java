package uz.data.warehause.controller;

import org.springframework.web.bind.annotation.*;
import uz.data.warehause.entity.Client;
import uz.data.warehause.service.ClientService;
import uz.data.warehause.service.Result;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public List<Client> getAll(){
        return service.getAllClient();
    }

    @GetMapping("/{id}")
    public Client getById(@PathVariable Integer id){
        return service.getClientById(id);
    }

    @PostMapping("/{id}")
    public Result create(@RequestBody Client dto){
        return service.createClient(dto);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody Client dto,@PathVariable Integer id){
        return service.updateClient(dto,id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return service.deleteClient(id);
    }
}
