package uz.data.warehause.controller;

import org.springframework.web.bind.annotation.*;
import uz.data.warehause.DTO.UsersDto;
import uz.data.warehause.entity.Users;
import uz.data.warehause.service.Result;
import uz.data.warehause.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController {
    final UserService service;

    public UsersController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Users> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/getByWarehauseId/{warehause_id}")
    public List<Users> getUsersBy(@PathVariable Integer warehause_id){
        return service.getUsersByWarehauseId(warehause_id);
    }

    @GetMapping("/getById/{id}")
    public Users getUsersByID(@PathVariable Integer id){
        return service.getUsersById(id);
    }

    @PostMapping
    public Result createUsers(@RequestBody UsersDto dto){
        return service.createUseres(dto);
    }

    @PutMapping("/{id}")
    public Result updateUsers(@PathVariable Integer id,@RequestBody UsersDto dto){
        return service.updateUsers(dto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteUsers(@PathVariable Integer id){
        return service.deleteUsers(id);
    }
}
