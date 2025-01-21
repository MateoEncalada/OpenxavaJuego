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
@Table(name = "juegos")
public class Juego {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer id;

    @Column(nullable = false, length = 100)
    @Required
    private String titulo;

    @Stereotype("TEXT_AREA")
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @DefaultValueCalculator(CurrentDateCalculator.class)
    private Date fechaLanzamiento;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer inventario;

    @ManyToOne
    @JoinColumn(name = "genero_id", nullable = false)
    @DescriptionsList(descriptionProperties = "nombre")
    private GeneroTest genero;

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    @ListProperties("cliente.nombre, calificacion, comentario")
    private List<Resena> resenas;

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    @ListProperties("cliente.nombre, cantidad, precio")
    private List<Venta> ventas;
}



