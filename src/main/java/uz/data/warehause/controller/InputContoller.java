package uz.data.warehause.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehause.DTO.InputDto;
import uz.data.warehause.entity.Input;
import uz.data.warehause.service.InputService;
import uz.data.warehause.service.Result;

import java.util.List;

@RestController
@RequestMapping("/input")
@RequiredArgsConstructor
public class InputContoller {
    InputService service;

    @GetMapping
    public List<Input> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Input getById(@PathVariable Integer id){
        return service.getByID(id);
    }

    @PostMapping
    public Result create(@RequestBody InputDto dto){
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public  Result update(@RequestBody InputDto dto,@PathVariable Integer id){
        return service.update(dto,id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
