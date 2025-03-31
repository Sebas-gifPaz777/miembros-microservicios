package com.microservicio.gimnasio.miembros;

import com.microservicio.gimnasio.miembros.model.Contacto;
import com.microservicio.gimnasio.miembros.model.Miembro;
import com.microservicio.gimnasio.miembros.repository.MiembroRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
public class DataInitializer implements CommandLineRunner {


    private final MiembroRepository repository;

    public DataInitializer(MiembroRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        Contacto contacto = new Contacto();
        contacto.setEmail("hola@gmail.com");
        contacto.setTelefono(1234L);

        repository.save(new Miembro(123L,"Juan","Perez", new Date(), contacto));
        repository.save(new Miembro(456L,"Carlos", "Perez",new Date(), contacto));
        System.out.println("Miembros iniciales guardados en la base de datos.");
    }
}