package io.github.benkoff.spring5webapp.repositories;

import io.github.benkoff.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ben on 2017-10-18.
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
