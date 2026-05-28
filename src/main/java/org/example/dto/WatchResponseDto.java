package org.example.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Enum.Movement;
import org.example.Enum.Status;
import org.example.entity.Watch;

@NoArgsConstructor
@Data
public class WatchResponseDto {
    private String model_name;
    private String brand;
    private double price;
    private Movement movement_type;
    private Status status;
    public  WatchResponseDto(Watch watch) {
        this.model_name = watch.getModel_name();
        this.brand = watch.getBrand();
        this.price = watch.getPrice();
        this.movement_type = watch.getMovement_type();
        this.status = watch.getStatus();
    }
}
