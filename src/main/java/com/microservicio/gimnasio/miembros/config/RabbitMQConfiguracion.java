package com.microservicio.gimnasio.miembros.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguracion {

    @Bean
    public Queue colaNotificaciones() {
        return new Queue("notificaciones.cola", true);
    }

    @Bean
    public TopicExchange intercambioNotificaciones() {
        return new TopicExchange("notificaciones.intercambio");
    }

    @Bean
    public Binding enlace(Queue colaNotificaciones, TopicExchange intercambioNotificaciones) {
        return BindingBuilder.bind(colaNotificaciones).to(intercambioNotificaciones).with("notificaciones.ruta");
    }

    @Bean
    public Jackson2JsonMessageConverter conversorMensajes() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate plantillaRabbitMQ(ConnectionFactory conexion) {
        RabbitTemplate plantilla = new RabbitTemplate(conexion);
        plantilla.setMessageConverter(conversorMensajes());
        return plantilla;
    }
}
