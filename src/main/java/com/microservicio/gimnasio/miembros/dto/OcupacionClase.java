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

    public OcupacionClase(String id, int ocupacion, LocalDateTime hora) {
        this.id = id;
        this.ocupacion = ocupacion;
        this.hora = hora;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(int ocupacion) {
        this.ocupacion = ocupacion;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }
}

