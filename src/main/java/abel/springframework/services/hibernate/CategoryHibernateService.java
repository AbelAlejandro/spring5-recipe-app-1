package abel.springframework.services.hibernate;

import abel.springframework.domain.Category;
import abel.springframework.repositories.CategoryRepository;
import abel.springframework.services.CategoryService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class CategoryHibernateService implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryHibernateService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> findAll() {
        Set<Category> categorySet = new HashSet<>();
        categoryRepository.findAll().iterator().forEachRemaining(categorySet::add);
        return categorySet;
    }

    @Override
    public Optional<Category> findById(Long aLong) {
        return categoryRepository.findById(aLong);
    }

    @Override
    public Category save(Category object) {
        return categoryRepository.save(object);
    }

    @Override
    public void delete(Category object) {
        categoryRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        categoryRepository.delete(findById(aLong).get());
    }
}
