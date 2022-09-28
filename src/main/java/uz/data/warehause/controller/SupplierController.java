package uz.data.warehause.controller;

import org.springframework.web.bind.annotation.*;
import uz.data.warehause.entity.Supplier;
import uz.data.warehause.service.Result;
import uz.data.warehause.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    final SupplierService service;

    public SupplierController(SupplierService service) {
        this.service = service;
    }

    @GetMapping
    public List<Supplier> getAllSupplier(){
        return service.getAllSupplier();
    }

    @GetMapping("/{id}")
    public Supplier getSupplierById(@PathVariable Integer id){
        return service.getSupplierById(id);
    }

    @PostMapping
    public Result createSupplier(@RequestBody Supplier dto){
        return service.createSupplier(dto);
    }

    @PutMapping("/{id}")
    public Result updateSupplier(@PathVariable Integer id,@RequestBody Supplier dto){
        return service.updateSupplier(dto,id);
    }

    @DeleteMapping("/{id}")
    public Result deleteSupplier(@PathVariable Integer id){
        return service.deleteSupplier(id);
    }
}
