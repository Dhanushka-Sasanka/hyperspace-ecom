package com.hyperspace.hyperspaceadvertisementapp.repository;

import com.hyperspace.hyperspaceadvertisementapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dhanushka Paranavithana
 * @since 8/7/2021  2:28 PM
 **/

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer > {
}
