package org.example.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Enum.Movement;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class WatchRequestDto {
    @NotBlank(message = "khong duoc de trong")
    private String model_name;
    @NotBlank(message = "khong duoc de trong")
    private String brand;
    @Min(value = 0 , message = "khong duoc la so am")
    private double price;
    @NotNull
    private Movement movement_type;
}
