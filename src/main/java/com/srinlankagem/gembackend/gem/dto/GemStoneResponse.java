package com.srinlankagem.gembackend.gem.dto;


import com.srinlankagem.gembackend.gem.models.GemOrigin;
import com.srinlankagem.gembackend.gem.models.GemTreatment;
import com.srinlankagem.gembackend.gem.models.GemType;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GemStoneResponse {

    private Long id;
    private String gemCode;
    private GemType type;
    private String color;
    private Double caratWeight;
    private GemOrigin origin;
    private GemTreatment treatment;
    private Double pricePerCarat;
    private Integer stockQuantity;
    private boolean certified;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
