package uz.data.warehause.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.data.warehause.DTO.InputProductDto;
import uz.data.warehause.entity.Input;
import uz.data.warehause.entity.InputProduct;
import uz.data.warehause.entity.Product;
import uz.data.warehause.repository.InputProductRepository;
import uz.data.warehause.repository.InputRepository;
import uz.data.warehause.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InputProductService {
    InputProductRepository inputProductRepository;
    InputRepository inputRepository;
    ProductRepository productRepository;

    public List<InputProduct> getAll(){
        return inputProductRepository.findAll();
    }

    public InputProduct getById(Integer id){
        Optional<InputProduct> byId = inputProductRepository.findById(id);
        return byId.orElse(null);
    }

    public List<InputProduct> getByInputId(Integer input_id){
        Optional<Input> byId = inputRepository.findById(input_id);
        if (byId.isPresent()) {
            return inputProductRepository.getInputProductsByInput_Id(input_id);
        } else {
            return null;
        }
    }

    public Result create(InputProductDto dto){
        Optional<Product> productRepositoryById = productRepository.findById(dto.getProductId());
        if (productRepositoryById.isEmpty()) return new Result("Product not found!",false);
        Product product = productRepositoryById.get();
        Optional<Input> inputRepositoryById = inputRepository.findById(dto.getInputId());
        if (inputRepositoryById.isEmpty()) return new Result("Input not found!",false);
        Input input = inputRepositoryById.get();
        InputProduct inputProduct=new InputProduct(null,product,dto.getAmount(),dto.getPrice(),dto.getExpire_date(),input);
        inputProductRepository.save(inputProduct);
        return new Result("Successfully added!",true);
    }

    public Result update(InputProductDto dto,Integer id){
        Optional<InputProduct> inputProductRepositoryById = inputProductRepository.findById(id);
        if (inputProductRepositoryById.isEmpty()) return new Result("InputProduct not found!",false);
        InputProduct inputProduct = inputProductRepositoryById.get();
        Optional<Product> productRepositoryById = productRepository.findById(dto.getProductId());
        if (productRepositoryById.isEmpty()) return new Result("Product not found!",false);
        Product product = productRepositoryById.get();
        Optional<Input> inputRepositoryById = inputRepository.findById(dto.getInputId());
        if (inputRepositoryById.isEmpty()) return new Result("Input not found!",false);
        Input input = inputRepositoryById.get();
        inputProduct.setProduct(product);
        inputProduct.setAmount(dto.getAmount());
        inputProduct.setPrice(dto.getPrice());
        inputProduct.setExpire_date(dto.getExpire_date());
        inputProduct.setInput(input);
        inputProductRepository.save(inputProduct);
        return new Result("Successfully updated!",true);
    }

    public Result delete(Integer id){
        Optional<InputProduct> inputProductRepositoryById = inputProductRepository.findById(id);
        if (inputProductRepositoryById.isEmpty()) return new Result("InputProduct not found!",false);
        inputProductRepository.deleteById(id);
        return new Result("Successfully deleted!",true);
    }
}
