package com.microservicio.gimnasio.miembros.service;

import com.microservicio.gimnasio.miembros.dto.MiembroDTO;
import com.microservicio.gimnasio.miembros.model.Contacto;
import com.microservicio.gimnasio.miembros.model.Miembro;
import com.microservicio.gimnasio.miembros.repository.ContactoRepository;
import com.microservicio.gimnasio.miembros.repository.MiembroRepository;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MiembroService {

    @Autowired
    ContactoRepository contactoRepository;

    @Autowired
    MiembroRepository miembroRepository;
    public Miembro crearMiembro(MiembroDTO miembroDTO ) {
        Contacto contacto =
                new Contacto();
        contacto.setEmail(miembroDTO.getEmail());
        contacto.setTelefono(miembroDTO.getTelefono());
        Miembro miembro = new Miembro(miembroDTO.getId(), miembroDTO.getNombre(), miembroDTO.getApellido(),
        miembroDTO.getFechaDeRegistro(), contacto);
        contactoRepository.save(contacto);
       return miembroRepository.save(miembro);
    }
    public MiembroDTO miembroPorId(Long id) {
        Optional<Miembro> miembro = miembroRepository.findById(id);
        MiembroDTO miembroDTO;
        if(miembro.isPresent()){
            miembroDTO = new MiembroDTO(miembro.get());
            return miembroDTO;
        }
        else
            return null;
    }

    public List<Miembro> obtenerTodosLosMiembros() {
        return miembroRepository.findAll();
    }


}
