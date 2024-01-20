package org.example.costbudgeting.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.costbudgeting.enums.BrazilianState;
import org.example.costbudgeting.enums.Manufacturer;
import org.example.costbudgeting.enums.ProductType;

import java.io.Serializable;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class Budget implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client client;

    @Column(nullable = false)
    private String editalNumber;

    @Column(nullable = false)
    private BrazilianState brazilianState;

    @Column(nullable = false)
    private Manufacturer manufacturerer;

    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false)
    private ProductType productType;

    @Column(nullable = false)
    private Integer batchSize;

    @Column(nullable = false)
    private String responsibleEmployee;

    private Integer unitNetPercentage;
    private Integer unitNetOrder;
    private Integer unitGrossPercentage;
    private Integer unitGrossOrder;

}
