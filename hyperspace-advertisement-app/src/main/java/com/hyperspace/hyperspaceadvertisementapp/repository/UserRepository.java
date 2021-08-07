package com.hyperspace.hyperspaceadvertisementapp.repository;

import com.hyperspace.hyperspaceadvertisementapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dhanushka Paranavithana
 * @since 8/5/2021  7:53 PM
 **/

@Repository
public interface UserRepository extends JpaRepository<User, Long > {


}
