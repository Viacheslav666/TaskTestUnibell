package ru.Unibell.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Long id;
    @Column(name = "phone_client")
    private String phoneNumbers;
    @Column(name = "email_client")
    private String emailAddresses;
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
}
