package com.hyperspace.hyperspaceadvertisementapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @author Dhanushka Paranavithana
 * @since 8/6/2021  1:46 AM
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryID;

    @Column( name = "categoryName" )
    private String categoryName;

    @Column( name = "categoryDescription" )
    private String categoryDescription;
}
