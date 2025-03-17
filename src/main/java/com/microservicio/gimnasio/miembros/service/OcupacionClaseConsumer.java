package com.microservicio.gimnasio.miembros.service;


import com.microservicio.gimnasio.miembros.dto.OcupacionClase;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OcupacionClaseConsumer {

    @KafkaListener(topics = "ocupacion-clases", groupId = "miembro-grupo")
    public void consumirActualizacionOcupacion(String ocupacion) {

        System.out.println(ocupacion);
    }
}
