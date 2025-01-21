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
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Hidden
    private Long id;

    @Column(nullable = false, unique = true, length = 50)
    @Required
    private String username;

    @Column(nullable = false, unique = true)
    @Stereotype("EMAIL")
    @Required
    private String email;

    @Column(nullable = false)
    @Stereotype("PASSWORD")
    @Required
    private String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
        name = "users_roles",
        joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
        inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    @ListProperties("name")
    private List<Role> roles = new ArrayList<>();
}

