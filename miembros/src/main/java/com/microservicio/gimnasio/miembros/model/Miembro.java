package com.microservicio.gimnasio.miembros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Miembro {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaDeRegistro;

    @OneToOne(cascade = CascadeType.ALL)  // Relación 1 a 1
    private Contacto contacto;

}
