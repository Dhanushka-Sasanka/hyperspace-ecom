package com.hyperspace.hyperspaceadvertisementapp.service;

import com.hyperspace.hyperspaceadvertisementapp.dto.AdvertisementDTO;
import com.hyperspace.hyperspaceadvertisementapp.util.service.ResponseWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * @author Dhanushka Paranavithana
 * @since 8/6/2021  1:33 AM
 **/

public interface AdvertisementService {

    ResponseEntity<ResponseWrapper<Page<AdvertisementDTO>>> getAllAdvertisementsByUserId(Pageable pageable , Long userId);

    ResponseEntity<ResponseWrapper<AdvertisementDTO>> createAdvertisement(AdvertisementDTO advertisementDTO);

    ResponseEntity<ResponseWrapper<AdvertisementDTO>> updateAdvertisement(Long advertisementId, AdvertisementDTO advertisementDTO);

    Map<String , Boolean> deleteAdvertisement(Long userId);

    ResponseEntity<ResponseWrapper<AdvertisementDTO>> searchAdvertisement(Long advertisementId);
}
