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
public class Miembro {
    @Id
    private Long id;
    private String nombre;
    private String apellido;
    private Date fechaDeRegistro;

    @OneToOne(cascade = CascadeType.ALL)  // Relación 1 a 1
    private Contacto contacto;
    private String claseId;

    public Miembro(){}
    public Miembro(Long id, String nombre, String apellido, Date fechaDeRegistro, Contacto contacto) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeRegistro = fechaDeRegistro;
        this.contacto = contacto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Date getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(Date fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public String getClaseId() {
        return claseId;
    }

    public void setClaseId(String claseId) {
        this.claseId = claseId;
    }
}
