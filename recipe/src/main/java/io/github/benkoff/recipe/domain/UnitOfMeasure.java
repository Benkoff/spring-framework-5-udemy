package io.github.benkoff.recipe.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Ben on 2017-10-20.
 */

@Data
@Entity
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String description;
}
