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
@Table(name = "clientes")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Integer id;

    @Column(nullable = false, length = 50)
    @Required
    private String nombre;

    @Column(nullable = false, length = 50)
    @Required
    private String apellido;

    @Column(length = 50)
    private String pais;

    @Stereotype("EMAIL")
    private String correo;

    @Stereotype("PHOTO")
    private String photoUrl;

    private Integer edad;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @ListProperties("fecha, cantidad, precio")
    private List<Venta> ventas;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    @ListProperties("juego.titulo, calificacion, comentario")
    private List<Resena> resenas;
}

