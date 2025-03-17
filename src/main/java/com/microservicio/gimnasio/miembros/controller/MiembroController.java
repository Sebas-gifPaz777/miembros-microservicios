package com.microservicio.gimnasio.miembros.controller;
import com.microservicio.gimnasio.miembros.dto.MiembroDTO;
import com.microservicio.gimnasio.miembros.model.Miembro;
import com.microservicio.gimnasio.miembros.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembro")
public class MiembroController {

    @Autowired
    MiembroService miembroService;

    @GetMapping("/listar")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_TRAINER')")
    public ResponseEntity<?> obtenerLista() {
        return ResponseEntity.ok(miembroService.obtenerTodosLosMiembros());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> obtenerMiembro(@PathVariable Long id) {
        return ResponseEntity.ok(miembroService.miembroPorId(id));
    }

    @PostMapping("/inscribirse")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> inscribirseGimnasio(@RequestBody MiembroDTO miembro) {
        return ResponseEntity.ok(miembroService.crearMiembro(miembro));
    }
}
