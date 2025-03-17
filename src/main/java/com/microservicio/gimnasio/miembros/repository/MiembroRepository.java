package com.microservicio.gimnasio.miembros.repository;

import com.microservicio.gimnasio.miembros.model.Miembro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MiembroRepository extends JpaRepository<Miembro,Long> {
}
