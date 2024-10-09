package org.glebindustries.veterinary_application.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "clinic")
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    private String address;

    @OneToMany (mappedBy = "clinic")
    private Set<Client> clients = new HashSet<>();

    @OneToMany (mappedBy = "clinic")
    private Set<Animal> animals = new HashSet<>();

}
