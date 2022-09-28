package uz.data.warehause.controller;

import org.springframework.web.bind.annotation.*;
import uz.data.warehause.entity.Measurement;
import uz.data.warehause.service.MeasurementService;
import uz.data.warehause.service.Result;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    final MeasurementService service;

    public MeasurementController(MeasurementService service) {
        this.service = service;
    }

    @GetMapping
    public List<Measurement> getAll(){
        return service.getAllMeasurement();
    }

    @GetMapping("/{id}")
    public Measurement getById(@PathVariable Integer id){
        return service.getMeasurementById(id);
    }

    @PostMapping
    public Result create(@RequestBody Measurement dto){
        return service.createMeasurment(dto);
    }

    @PutMapping("/{id}")
    public Result update(@RequestBody Measurement dto,@PathVariable Integer id){
        return service.updateMeasurement(dto,id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return service.deleteMeasurement(id);
    }
}
