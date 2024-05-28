package com.example.demox12;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id", nullable = false)
    private long id;

    @Column(name = "model_name", nullable = false)
    private String modelName;

    @Column(name = "vehicle_id", nullable = false)
    private String type;
}
