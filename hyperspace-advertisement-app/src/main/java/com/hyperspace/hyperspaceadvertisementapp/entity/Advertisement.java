package com.hyperspace.hyperspaceadvertisementapp.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Dhanushka Paranavithana
 * @since 8/6/2021  1:46 AM
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "advertisement")
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertisementID;

    @Column( name = "addDate" )
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
    private Date addDate;

    @Column( name = "description" )
    private String description;

    @Column( name = "addImagePath" )
    private String advertisementImagePath;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "categoryID")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "userID")
    private User user;


}
