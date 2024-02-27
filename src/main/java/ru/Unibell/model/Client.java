package ru.Unibell.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client")
    private Long idClient;
    @Column(name = "name_client")
    private String nameClient;
    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Contact> contacts;
}
