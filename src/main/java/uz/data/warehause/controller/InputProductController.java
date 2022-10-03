package uz.data.warehause.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehause.DTO.InputProductDto;
import uz.data.warehause.entity.InputProduct;
import uz.data.warehause.service.InputProductService;
import uz.data.warehause.service.Result;

import java.util.List;

@RestController
@RequestMapping("/inputProduct")
@RequiredArgsConstructor
public class InputProductController {
    InputProductService service;

    @GetMapping
    public List<InputProduct> getAll(){
        return service.getAll();
    }

    @GetMapping("/getByInputId/{id}")
    public List<InputProduct> getByInputId(@PathVariable Integer id){
        return service.getByInputId(id);
    }

    @GetMapping("/getById/{id}")
    public InputProduct getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping()
    public Result create(@RequestBody InputProductDto dto){
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody InputProductDto dto,@PathVariable Integer id){
        return service.update(dto,id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return service.delete(id);
    }

}
