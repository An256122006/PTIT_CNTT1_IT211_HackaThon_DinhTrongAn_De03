package org.example.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.common.ApiResponse;
import org.example.dto.WatchRequestDto;
import org.example.dto.WatchResponseDto;
import org.example.entity.Watch;
import org.example.service.WatchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/watches")
public class WatchController {
    private final WatchService watchService;
    @GetMapping
    public ResponseEntity<?> findAll(@RequestParam(value = "search",defaultValue = "") String search, @PageableDefault(page = 0,size = 5)Pageable pageable) {
        Page<WatchResponseDto> result=watchService.findByModelNameContainingIgnoreCase(search,pageable).map(WatchResponseDto::new);
        ApiResponse<List<WatchResponseDto>> apiResponse = new ApiResponse<>(
                result.getContent(),
                "Lay du lieu thanh cong",
                true
        );
        return ResponseEntity.ok(apiResponse);
    }
    @PostMapping
    public ResponseEntity<?> create(@Valid @RequestBody WatchRequestDto watchRequestDto) {
        WatchResponseDto watchResponseDto=new WatchResponseDto(watchService.save(watchRequestDto));
        ApiResponse<WatchResponseDto> apiResponse = new ApiResponse<>(
                watchResponseDto,
                "Tao thanh cong",
                true
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody WatchRequestDto watchRequestDto) {
        WatchResponseDto watchResponseDto=new WatchResponseDto(watchService.Update(id,watchRequestDto));
        ApiResponse<WatchResponseDto> apiResponse = new ApiResponse<>(
                watchResponseDto,
                "Cap nhat thanh cong",
                true
        );
        return ResponseEntity.ok(apiResponse);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateById(@PathVariable Long id,@RequestBody Map<String,Object> map) {
        WatchResponseDto watchResponseDto=new WatchResponseDto(watchService.PatchUpdate(id,map));
        ApiResponse<WatchResponseDto> apiResponse = new ApiResponse<>(
                watchResponseDto,
                "Cap nhat thanh cong",
                true
        );
        return ResponseEntity.ok(apiResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        watchService.delete(id);
        ApiResponse<WatchResponseDto> apiResponse = new ApiResponse<>(
                null,
                "delete thanh cong",
                true
        );
        return ResponseEntity.ok(apiResponse);
    }
}
