package com.microservicio.gimnasio.miembros.service;

import com.microservicio.gimnasio.miembros.dto.MiembroDTO;
import com.microservicio.gimnasio.miembros.model.Contacto;
import com.microservicio.gimnasio.miembros.model.Miembro;
import com.microservicio.gimnasio.miembros.repository.ContactoRepository;
import com.microservicio.gimnasio.miembros.repository.MiembroRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MiembroService {

    @Autowired
    ContactoRepository contactoRepository;

    @Autowired
    MiembroRepository miembroRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public Miembro crearMiembro(MiembroDTO miembroDTO) {
        Contacto contacto = new Contacto();
        contacto.setEmail(miembroDTO.getEmail());
        contacto.setTelefono(miembroDTO.getTelefono());

        Miembro miembro = new Miembro(
                miembroDTO.getId(), miembroDTO.getNombre(),
                miembroDTO.getApellido(), miembroDTO.getFechaDeRegistro(), contacto
        );

        contactoRepository.save(contacto);
        Miembro nuevoMiembro = miembroRepository.save(miembro);

        // Enviar notificación a RabbitMQ
        String mensaje = "Nuevo miembro registrado: " + miembro.getNombre() + " " + miembro.getApellido();
        rabbitTemplate.convertAndSend("notificaciones.intercambio", "notificaciones.ruta", mensaje);

        return nuevoMiembro;
    }

    public MiembroDTO miembroPorId(Long id) {
        Optional<Miembro> miembro = miembroRepository.findById(id);
        return miembro.map(MiembroDTO::new).orElse(null);
    }

    public List<Miembro> obtenerTodosLosMiembros() {
        return miembroRepository.findAll();
    }
}
