package MVC.conciertos.Model;

import java.time.LocalDate;
import MVC.conciertos.enums.EventoStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="eventos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class EventoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;
    private String descripcion;
    private LocalDate fechaHora;
    private String lugar;
    private Integer capacidadMax;
    private double precioBase;
    @Enumerated(EnumType.STRING)
    private EventoStatus estado;
}