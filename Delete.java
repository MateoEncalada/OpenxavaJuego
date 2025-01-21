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
@Table(name = "borrar")
public class Delete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long jue_id;

    @Column(nullable = false, length = 100)
    @Required
    private String jue_Titulo;

    @Stereotype("TEXT_AREA")
    private String jue_Descripcion;

    @Temporal(TemporalType.DATE)
    @DefaultValueCalculator(CurrentDateCalculator.class)
    private Date jue_FechaLanzamiento;

    private Double jue_Precio;
    private Integer jue_Inventario;
}
