package io.github.benkoff.spring5webapp.repositories;

import io.github.benkoff.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ben on 2017-10-19.
 */
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
