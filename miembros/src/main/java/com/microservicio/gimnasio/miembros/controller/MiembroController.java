package com.microservicio.gimnasio.miembros.controller;
import com.microservicio.gimnasio.miembros.dto.MiembroDTO;
import com.microservicio.gimnasio.miembros.model.Miembro;
import com.microservicio.gimnasio.miembros.service.MiembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/miembro")
public class MiembroController {

    @Autowired
    MiembroService miembroService;

    @GetMapping("/listar")
    public List<Miembro> obtenerLista() {
        return miembroService.obtenerTodosLosMiembros();
    }

    @GetMapping("/porId")
    public Miembro obtenerLista(@RequestParam Long id) {
        return miembroService.miembroPorId(id);
    }

    @PostMapping("/inscribirse")
    public Miembro inscribirseGimnasio(@RequestBody MiembroDTO miembro) {
        return miembroService.crearMiembro(miembro);
    }
}
