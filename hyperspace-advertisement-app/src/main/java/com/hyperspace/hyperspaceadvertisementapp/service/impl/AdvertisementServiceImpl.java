package com.hyperspace.hyperspaceadvertisementapp.service.impl;

import com.hyperspace.hyperspaceadvertisementapp.dto.AdvertisementDTO;
import com.hyperspace.hyperspaceadvertisementapp.service.AdvertisementService;
import com.hyperspace.hyperspaceadvertisementapp.util.service.ResponseWrapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Dhanushka Paranavithana
 * @since 8/6/2021  1:29 AM
 **/
@Service
public class AdvertisementServiceImpl implements AdvertisementService {



    @Override
    public ResponseEntity<ResponseWrapper<Page<AdvertisementDTO>>> getAllAdvertisementsByUserId(Pageable pageable, Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWrapper<AdvertisementDTO>> createAdvertisement(AdvertisementDTO advertisementDTO) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWrapper<AdvertisementDTO>> updateAdvertisement(Long advertisementId, AdvertisementDTO advertisementDTO) {
        return null;
    }

    @Override
    public Map<String, Boolean> deleteAdvertisement(Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseWrapper<AdvertisementDTO>> searchAdvertisement(Long advertisementId) {
        return null;
    }
}
