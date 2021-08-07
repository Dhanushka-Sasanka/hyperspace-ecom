package com.hyperspace.hyperspaceadvertisementapp.repository;

import com.hyperspace.hyperspaceadvertisementapp.entity.Advertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Dhanushka Paranavithana
 * @since 8/6/2021  2:14 AM
 **/

@Repository
public interface AdvertisementRepository extends JpaRepository<Advertisement, Long> {

}
