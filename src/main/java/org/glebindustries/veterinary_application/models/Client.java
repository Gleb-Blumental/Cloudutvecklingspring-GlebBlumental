package org.glebindustries.veterinary_application.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    private String phoneNumber;

    @OneToOne
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clinic_id", referencedColumnName = "id")
    private Clinic clinic;
}
