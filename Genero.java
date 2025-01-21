package com.tuempresa.videogamesonline.modelo;

import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "generos")
public class Genero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer id;

    @Column(nullable = false, length = 50)
    @Required
    private String nombre;

    @Stereotype("TEXT_AREA")
    private String descripcion;

    @OneToMany(mappedBy = "genero", cascade = CascadeType.ALL, orphanRemoval = true)
    @ListProperties("titulo, precio")
    private List<Juego> juegos;


    /**
     * Método para ajustar el precio de los juegos según el género.
     * Si el género es "Terror", incrementa el precio en un 20%.
     * Para otros géneros, mantiene el precio original.
     */
    @Transient
    public void ajustarPrecios() {
        if (juegos != null && !juegos.isEmpty()) {
            for (Juego juego : juegos) {
                if ("Terror".equalsIgnoreCase(nombre)) {
                    juego.setPrecio(juego.getPrecio() * 1.20); // Incrementa 20%
                }
            }
        }
    }
}


