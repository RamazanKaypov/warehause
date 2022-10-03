package uz.data.warehause.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.data.warehause.DTO.OutputProductDto;
import uz.data.warehause.entity.Output;
import uz.data.warehause.entity.OutputProduc;
import uz.data.warehause.entity.Product;
import uz.data.warehause.repository.OutputProductRepository;
import uz.data.warehause.repository.OutputRepository;
import uz.data.warehause.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OutputProductService {
    OutputProductRepository outputProductRepository;

    OutputRepository outputRepository;

    ProductRepository productRepository;

    public List<OutputProduc> getAll(){
        return outputProductRepository.findAll();
    }

    public OutputProduc getById(Integer id){
        Optional<OutputProduc> byId = outputProductRepository.findById(id);
        return byId.orElse(null);
    }

    public List<OutputProduc> getByOutputId(Integer output_id){
        Optional<Output> byId = outputRepository.findById(output_id);
        if (byId.isPresent()){
            return outputProductRepository.getOutputProducsByOutput_Id(output_id);
        } else {
            return null;
        }
    }

    public Result create(OutputProductDto dto){
        Optional<Product> productRepositoryById = productRepository.findById(dto.getProductId());
        if (productRepositoryById.isEmpty()) return new Result("Product not found!",false);
        Product product = productRepositoryById.get();
        Optional<Output> outputRepositoryById = outputRepository.findById(dto.getOutputId());
        if (outputRepositoryById.isEmpty())  return new Result("Output not found!",false);
        Output output = outputRepositoryById.get();
        OutputProduc outputProduc=new OutputProduc(null,product,dto.getAmount(),dto.getPrice(),output);
        outputProductRepository.save(outputProduc);
        return new Result("Succsefully added!",true);
    }

    public Result update(OutputProductDto dto,Integer id){
        Optional<OutputProduc> outputProductRepositoryById = outputProductRepository.findById(id);
        if (outputProductRepositoryById.isEmpty())  return new Result("OutputProduct not found!",false);
        OutputProduc outputProduc = outputProductRepositoryById.get();
        Optional<Product> productRepositoryById = productRepository.findById(dto.getProductId());
        if (productRepositoryById.isEmpty()) return new Result("Product not found!",false);
        Product product = productRepositoryById.get();
        Optional<Output> outputRepositoryById = outputRepository.findById(dto.getOutputId());
        if (outputRepositoryById.isEmpty())  return new Result("Output not found!",false);
        Output output = outputRepositoryById.get();
        outputProduc.setProduct(product);
        outputProduc.setOutput(output);
        outputProduc.setAmount(dto.getAmount());
        outputProduc.setPrice(dto.getPrice());
        outputProductRepository.save(outputProduc);
        return new Result("Succsefully added!",true);
    }

    public Result delete(Integer id){
        Optional<OutputProduc> outputProductRepositoryById = outputProductRepository.findById(id);
        if (outputProductRepositoryById.isEmpty())  return new Result("OutputProduct not found!",false);
        outputProductRepository.deleteById(id);
        return new Result("Succsefully deleted!",true);

    }
}
