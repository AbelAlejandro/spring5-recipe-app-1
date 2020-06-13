package abel.springframework.services.hibernate;

import abel.springframework.domain.Recipe;
import abel.springframework.repositories.RecipeRepository;
import abel.springframework.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class RecipeHibernateService implements RecipeService {
    private final RecipeRepository recipeRepository;

    public RecipeHibernateService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> findAll() {
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Optional<Recipe> findById(Long aLong) {
        return recipeRepository.findById(aLong);
    }

    @Override
    public Recipe save(Recipe object) {
        return recipeRepository.save(object);
    }

    @Override
    public void delete(Recipe object) {
        recipeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        recipeRepository.delete(findById(aLong).get());
    }
}
