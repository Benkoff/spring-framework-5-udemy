package io.github.benkoff.recipe.repositories;

import io.github.benkoff.recipe.domain.Category;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Long> {

    Optional<Category> findByDescription(String description);
}
