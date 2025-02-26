package com.example.carwash.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String name;
    private String phone;
    private String email;
    private String vehicle;
    private List<Treatment> treatments;
    private Double total;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime appointmentDate;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm")
    private LocalDateTime estimatedEndTime;
}
