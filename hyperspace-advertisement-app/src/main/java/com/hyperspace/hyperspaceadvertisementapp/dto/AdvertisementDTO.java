package com.hyperspace.hyperspaceadvertisementapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dhanushka Paranavithana
 * @since 8/5/2021  9:51 PM
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvertisementDTO {

    private Long userID;
    private String title;
    private String description;
    private String addDate;
    private String advertisementImage;

}
