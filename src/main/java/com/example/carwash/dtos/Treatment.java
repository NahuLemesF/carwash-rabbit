package com.example.carwash.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Treatment {
    private String type;
    private Double price;
    private Integer duration;
}
