package uz.data.warehause.controller;

import org.springframework.web.bind.annotation.*;
import uz.data.warehause.DTO.OutputProductDto;
import uz.data.warehause.entity.OutputProduc;
import uz.data.warehause.service.OutputProductService;
import uz.data.warehause.service.Result;

import java.util.List;

@RestController
@RequestMapping("/outputProduct")
public class OutputProductController {

    OutputProductService service;

    @GetMapping
    public List<OutputProduc> getAll(){
        return service.getAll();
    }

    @GetMapping("/getByOutputId/{id}")
    public List<OutputProduc> getByOutputId(@PathVariable Integer id){
        return service.getByOutputId(id);
    }

    @GetMapping("/getById/{id}")
    public OutputProduc getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping
    public Result create(@RequestBody OutputProductDto dto){
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody OutputProductDto dto,@PathVariable Integer id){
        return service.update(dto,id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return service.delete(id);
    }
}
