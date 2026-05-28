package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.Enum.Status;
import org.example.dto.WatchRequestDto;
import org.example.entity.Watch;
import org.example.repository.WatchRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class WatchService {
    private final WatchRepository watchRepository;
    public Page<Watch> findByModelNameContainingIgnoreCase(String search, Pageable pageable) {
        return watchRepository.findBySearch(search, pageable);
    }
    public Watch save(WatchRequestDto watchRequestDto) {
        Watch watch = new Watch();
        watch.setModel_name(watchRequestDto.getModel_name());
        watch.setBrand(watchRequestDto.getBrand());
        watch.setPrice(watchRequestDto.getPrice());
        watch.setMovement_type(watchRequestDto.getMovement_type());
        watch.setStatus(Status.IN_STOCK);
        return watchRepository.save(watch);
    }
    public Watch Update(Long id,WatchRequestDto watchRequestDto) {
        Watch watch = watchRepository.findById(id).orElseThrow(()->new RuntimeException("Watch not found"));
        watch.setModel_name(watchRequestDto.getModel_name());
        watch.setBrand(watchRequestDto.getBrand());
        watch.setPrice(watchRequestDto.getPrice());
        watch.setMovement_type(watchRequestDto.getMovement_type());
        return watchRepository.save(watch);
    }
    public Watch PatchUpdate(Long id, Map<String,Object> map) {
        Watch watch = watchRepository.findById(id).orElseThrow(()->new RuntimeException("Watch not found"));
        if (map.containsKey("model_name")) {
            if (map.get("model_name") != null) {
                watch.setModel_name((String) map.get("model_name"));
            }
        }
        if (map.containsKey("brand")) {
            if (map.get("brand") != null) {
                watch.setBrand((String) map.get("brand"));
            }
        }
        if (map.containsKey("price")) {
            if (map.get("price") != null) {
                watch.setPrice((Double) map.get("price"));
            }
        }
        if (map.containsKey("movement_type")) {
            if (map.get("movement_type") != null) {
                watch.setMovement_type(watch.getMovement_type());
            }
        }
        if (map.containsKey("status")) {
            if (map.get("status") != null) {
                if(map.get("status") == Status.IN_STOCK) {
                    watch.setStatus(Status.IN_STOCK);
                }
                if (map.get("status")==Status.SOLD){
                    watch.setStatus(Status.SOLD);
                }
                if(map.get("status")==Status.REPAIRING){
                    watch.setStatus(Status.REPAIRING);
                }
            }
        }
        return watchRepository.save(watch);
    }
    public void delete(Long id) {
        Watch watch = watchRepository.findById(id).orElseThrow(()->new RuntimeException("Watch not found"));
        watchRepository.delete(watch);
    }
}
