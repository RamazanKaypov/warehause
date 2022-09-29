package uz.data.warehause.controller;

import org.springframework.web.bind.annotation.*;
import uz.data.warehause.DTO.CategoryDto;
import uz.data.warehause.entity.Category;
import uz.data.warehause.service.CategoryService;
import uz.data.warehause.service.Result;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public List<Category> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Category getById(@PathVariable Integer id){
        return service.getById(id);
    }

    @PostMapping
    public Result create(@RequestBody CategoryDto dto){
        return service.create(dto);
    }

    @PutMapping("/{id}")
    public Result delete(@PathVariable Integer id,@RequestBody CategoryDto dto){
        return service.delete(id);
    }
}
