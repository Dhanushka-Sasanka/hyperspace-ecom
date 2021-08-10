package com.b127.exams.repos;

import com.b127.exams.dao.auth.Role;
import com.b127.exams.dao.types.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer > {

    Optional<Role> findByRole(RoleType role);
}
