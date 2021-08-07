package com.hyperspace.hyperspaceadvertisementapp.controller;

import com.hyperspace.hyperspaceadvertisementapp.dto.AdvertisementDTO;
import com.hyperspace.hyperspaceadvertisementapp.entity.User;
import com.hyperspace.hyperspaceadvertisementapp.service.AdvertisementService;
import com.hyperspace.hyperspaceadvertisementapp.service.UserService;
import com.hyperspace.hyperspaceadvertisementapp.util.service.ResponseWrapper;
import com.hyperspace.hyperspaceadvertisementapp.util.service.UrlProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dhanushka Paranavithana
 * @since 8/6/2021  1:26 AM
 **/

@CrossOrigin(origins = "*")
@RestController
@RequestMapping( UrlProvider.ADVERTISEMENT_SERVICE )
@RequiredArgsConstructor
public class AdvertisementController {

    private final AdvertisementService advertisementService;

    /**
     * Get All Advertisements in Page wise for user
     *
     * @param pageable The Pageable
     * @return Page of AdvertisementDTO
     */
    @GetMapping("/advertisements")
    public ResponseEntity<ResponseWrapper<Page<AdvertisementDTO>>> getAllAdvertisements(Pageable pageable ,Long userId)
    {
        return advertisementService.getAllAdvertisementsByUserId(pageable ,userId);
    }
}
