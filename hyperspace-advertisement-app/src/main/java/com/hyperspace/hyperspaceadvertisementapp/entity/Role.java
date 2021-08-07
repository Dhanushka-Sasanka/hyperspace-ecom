package com.hyperspace.hyperspaceadvertisementapp.entity;

import com.hyperspace.hyperspaceadvertisementapp.entity.type.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dhanushka Paranavithana
 * @since 8/6/2021  2:01 AM
 **/

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleType role;
}
