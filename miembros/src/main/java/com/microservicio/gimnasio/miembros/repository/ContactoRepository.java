package com.microservicio.gimnasio.miembros.repository;
import com.microservicio.gimnasio.miembros.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoRepository extends JpaRepository<Contacto, Long> {


}
