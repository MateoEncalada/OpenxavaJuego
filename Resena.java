package com.tuempresa.videogamesonline.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;
import org.openxava.calculators.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "resenas")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;

    @ManyToOne
    @JoinColumn(name = "juego_id", nullable = false)
    @DescriptionsList(descriptionProperties = "titulo")
    private Juego juego;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @DescriptionsList(descriptionProperties = "nombre")
    private Client cliente;

    @Column(nullable = false)
    private Integer calificacion;

    @Stereotype("TEXT_AREA")
    private String comentario;

    @Temporal(TemporalType.DATE)
    @DefaultValueCalculator(CurrentDateCalculator.class)
    private Date fecha;
}



