package com.microservicio.gimnasio.miembros.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OcupacionClase {

    private String id;
    private int ocupacion;
    private LocalDateTime hora;


}

