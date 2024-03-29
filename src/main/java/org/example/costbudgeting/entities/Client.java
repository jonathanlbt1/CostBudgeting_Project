package org.example.costbudgeting.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@ToString
@RequiredArgsConstructor
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Client implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name ="email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    public Address address;


}
