package com.hyperspace.hyperspaceadvertisementapp.repository;


import com.hyperspace.hyperspaceadvertisementapp.entity.Role;
import com.hyperspace.hyperspaceadvertisementapp.entity.type.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RoleRepository extends JpaRepository<Role, Integer > {

    Optional<Role> findByRole(RoleType role);
}
