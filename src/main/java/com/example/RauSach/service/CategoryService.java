package com.example.RauSach.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.RauSach.model.Category;
import com.example.RauSach.repository.CategoryRepository;

import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryService {
    private final CategoryRepository categoryRepository;
    
    public List<Category> getAllCategories()
    {
        return categoryRepository.findAll();
    }
    public Category addCategory(Category category)
    {
        return categoryRepository.save(category);
    }
    public Optional<Category> findCategoryById(String id)
    {
        return categoryRepository.findById(id);
    }
    public Category updateCategory(@NotNull Category category) {
        Category existingCategory = categoryRepository.findById(category.getId())
                .orElseThrow(() -> new IllegalStateException("Category with ID " +
                        category.getId() + " does not exist."));
        existingCategory.setName(category.getName());
        return categoryRepository.save(existingCategory);
    }
    public void deleteCategoryById(String id) {
        if (!categoryRepository.existsById(id)) {
            throw new IllegalStateException("Category with ID " + id + " does not exist.");
        }
        categoryRepository.deleteById(id);
    }
}
