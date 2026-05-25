package com.srinlankagem.gembackend.gem.controller;

import com.srinlankagem.gembackend.common_exception.ResourceNotFoundException;
import com.srinlankagem.gembackend.gem.dto.GemStoneRequest;
import com.srinlankagem.gembackend.gem.dto.GemStoneResponse;
import com.srinlankagem.gembackend.gem.service.GemStoneService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/gems")
@RequiredArgsConstructor
public class GemStoneController {

    private final GemStoneService gemStoneService;

    @GetMapping
    public ResponseEntity<Page<GemStoneResponse>> getAllGemStones(@PageableDefault(size = 20, sort = "color") Pageable pageable){
        return ResponseEntity.ok(gemStoneService.getAllGemStone(pageable));
    }

    @PostMapping
    public ResponseEntity<GemStoneResponse> createGemstone(@RequestBody GemStoneRequest request){
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("custom-head","Sending Custom header")
                .body(gemStoneService.createGemstone(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GemStoneResponse> getGemStoneById(@PathVariable Long id)throws ResourceNotFoundException {
        return ResponseEntity.ok(gemStoneService.getGemStoneById(id));
    }


}
