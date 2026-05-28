package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.Enum.Movement;
import org.example.Enum.Status;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Watch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model_name;
    private String brand;
    private double price;
    @Enumerated(EnumType.STRING)
    private Movement movement_type;
    @Enumerated(EnumType.STRING)
    private Status status;
}
