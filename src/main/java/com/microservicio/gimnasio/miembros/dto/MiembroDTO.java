package com.microservicio.gimnasio.miembros.dto;

import com.microservicio.gimnasio.miembros.model.Contacto;
import com.microservicio.gimnasio.miembros.model.Miembro;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MiembroDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaDeRegistro;
    private String email;
    private Long telefono;


    public MiembroDTO(Miembro miembro){
        this.id = miembro.getId();
        this.nombre = miembro.getNombre();
        this.apellido = miembro.getApellido();
        this.fechaDeRegistro  = miembro.getFechaDeRegistro();
        email = miembro.getContacto().getEmail();
        telefono = miembro.getContacto().getTelefono();
    }




}
