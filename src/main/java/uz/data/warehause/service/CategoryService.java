package uz.data.warehause.service;

import org.springframework.stereotype.Service;
import uz.data.warehause.DTO.CategoryDto;
import uz.data.warehause.entity.Category;
import uz.data.warehause.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> getAll(){
        return categoryRepository.findAll();
    }

    public Category getById(Integer id){
        Optional<Category> byId = categoryRepository.findById(id);
        return byId.orElse(null);
    }

    public Result create(CategoryDto dto){
        List<Category> list=new ArrayList<>();
        list.addAll(categoryRepository.findAllById(dto.getParentCategoryIDs()));
        Category category=new Category((Integer) null,dto.getName(), (Category) list,dto.getStatus());
        categoryRepository.save(category);
        return new Result("Sucessfuly added!",true);
    }

    public Result update(CategoryDto dto,Integer id){
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) return new Result("Category not found!",false);
        else {
            List<Category> list=new ArrayList<>();
            list.addAll(categoryRepository.findAllById(dto.getParentCategoryIDs()));
            Category category=byId.get();
            category.setName(dto.getName());
            category.setParenCategory((Category) list);
            category.setStatus(dto.getStatus());
            categoryRepository.save(category);
            return new Result("Successfuly updated!",true);
        }
    }

    public Result delete(Integer id){
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isEmpty()) return new Result("Category not found!",false);
        else {
            categoryRepository.deleteById(id);
            return new Result("Successfuly deleted!",true);
        }
    }

}
