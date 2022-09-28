package uz.data.warehause.controller;

import org.springframework.web.bind.annotation.*;
import uz.data.warehause.entity.Warehause;
import uz.data.warehause.service.Result;
import uz.data.warehause.service.WarehauseService;

import java.util.List;

@RestController
@RequestMapping("/warehause")
public class WarehauseController {
    final WarehauseService warehauseService;

    public WarehauseController(WarehauseService warehauseService) {
        this.warehauseService = warehauseService;
    }

    @GetMapping
    public List<Warehause> getAllWarehause(){
        return warehauseService.getAllWarehause();
    }

    @GetMapping("/{id}")
    public Warehause getWarehauseById(@PathVariable Integer id){
        return warehauseService.getWarehauseById(id);
    }

    @PostMapping
    public Result createWarehause(@RequestBody Warehause dto){
        return warehauseService.createWarehause(dto);
    }

    @PutMapping("/{id}")
    public Result updateWarehause(@RequestBody Warehause dto,@PathVariable Integer id){
        return warehauseService.updateWarehause(id,dto);
    }

    @DeleteMapping("/{id}")
    public Result deleteWarehause(@PathVariable Integer id){
        return warehauseService.deleteWarehause(id);
    }

}
