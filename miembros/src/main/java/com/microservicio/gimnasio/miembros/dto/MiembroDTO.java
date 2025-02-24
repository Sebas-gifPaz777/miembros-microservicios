package com.microservicio.gimnasio.miembros.dto;

import com.microservicio.gimnasio.miembros.model.Contacto;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MiembroDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaDeRegistro;
    private String email;
    private Long telefono;
}
