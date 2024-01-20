package org.example.costbudgeting.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.costbudgeting.enums.BrazilianState;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "address")
public class Address implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "number")
    private String number;

    @Column(name = "complement")
    private String complement;

    @Column(name = "neighborhood")
    private String neighborhood;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private BrazilianState state;
}
