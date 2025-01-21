package com.tuempresa.videogamesonline.modelo;


import java.util.*;

import javax.persistence.*;

import org.openxava.annotations.*;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;

    @Column(nullable = false, length = 50)
    @Required
    private String name;

    @ManyToMany(mappedBy = "roles")
    @ListProperties("username, email") // Muestra detalles de los usuarios asociados
    private List<UserEntity> users = new ArrayList<>();
}


