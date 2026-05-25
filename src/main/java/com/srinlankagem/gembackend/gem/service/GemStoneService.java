package com.srinlankagem.gembackend.gem.service;

import com.srinlankagem.gembackend.common_exception.ResourceNotFoundException;
import com.srinlankagem.gembackend.gem.dto.GemStoneRequest;
import com.srinlankagem.gembackend.gem.dto.GemStoneResponse;
import com.srinlankagem.gembackend.gem.models.GemStone;
import com.srinlankagem.gembackend.gem.repository.GemStoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.srinlankagem.gembackend.gem.models.GemStone.*;


@Service
@RequiredArgsConstructor
public class GemStoneService {

    private final GemStoneRepository gemStoneRepository;
    public Page<GemStoneResponse> getAllGemStone(Pageable pageable){
        return gemStoneRepository.findByActiveTrue(pageable).map(item -> toResponse(item));

    }

    public GemStoneResponse createGemstone(GemStoneRequest request){
        GemStone gemStone = builder()
                .gemCode(request.getGemCode())
                .type(request.getType())
                .color(request.getColor())
                .caratWeight(request.getCaratWeight())
                .treatment(request.getTreatment())
                .origin(request.getOrigin())
                .pricePerCarat(request.getPricePreCarat())
                .certified(request.isCertified())
                .stockQuantity(request.getStockQuantity())
                .description(request.getDescription())
                .active(true)
                .build();
        return toResponse(gemStoneRepository.save(gemStone));
    }

    public GemStoneResponse getGemStoneById(Long id){
        return toResponse(gemStoneRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException()));
    }

    private GemStoneResponse toResponse(GemStone gemStone){

        return GemStoneResponse.builder()
                .id(gemStone.getId())
                .gemCode(gemStone.getGemCode())
                .type(gemStone.getType())
                .color(gemStone.getColor())
                .caratWeight(gemStone.getCaratWeight())
                .treatment(gemStone.getTreatment())
                .origin(gemStone.getOrigin())
                .pricePerCarat(gemStone.getPricePerCarat())
                .stockQuantity(gemStone.getStockQuantity())
                .certified(gemStone.isCertified())
                .description(gemStone.getDescription())
                .createdAt(gemStone.getCreatedAt())
                .updatedAt(gemStone.getCreatedAt())
                .build();
    }
}
