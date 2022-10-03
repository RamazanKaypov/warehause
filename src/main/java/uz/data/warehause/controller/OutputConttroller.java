package uz.data.warehause.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.data.warehause.DTO.OutputDto;
import uz.data.warehause.entity.Output;
import uz.data.warehause.service.OutputService;
import uz.data.warehause.service.Result;

import java.util.List;

@RestController
@RequestMapping("/output")
@RequiredArgsConstructor
public class OutputConttroller {
    OutputService service;

    @GetMapping
    public List<Output> getAll(){
        return service.getAll();
    }

    public Output getById(@PathVariable Integer id){
        return service.getById(id);
    }

    public Result create(@RequestBody OutputDto dto){
        return service.create(dto);
    }

    public Result update(@RequestBody OutputDto dto,@PathVariable Integer id){
        return service.update(dto,id);
    }

    public Result delete(@PathVariable Integer id){
        return service.delete(id);
    }

}
