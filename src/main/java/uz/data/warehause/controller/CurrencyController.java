package uz.data.warehause.controller;

import org.springframework.web.bind.annotation.*;
import uz.data.warehause.entity.Currency;
import uz.data.warehause.service.CurrencyService;
import uz.data.warehause.service.Result;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    final CurrencyService service;

    public CurrencyController(CurrencyService service) {
        this.service = service;
    }

    @GetMapping
    public List<Currency> getAll(){
        return service.getAllCurrency();
    }

    @GetMapping("/{id}")
    public Currency GetById(@PathVariable Integer id){
        return service.getCurrencyById(id);
    }

    @PostMapping
    public Result create(@RequestBody Currency dto){
        return service.createCurrency(dto);
    }

    @PutMapping("/{id}")
    public Result update(@PathVariable Integer id,@RequestBody Currency dto){
        return service.updateCurrency(dto,id);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        return service.deleteCurrency(id);
    }
}
