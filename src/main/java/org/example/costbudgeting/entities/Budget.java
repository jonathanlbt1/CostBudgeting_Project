package org.example.costbudgeting.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.costbudgeting.entities.costsbreakdown.Components;
import org.example.costbudgeting.enums.BrazilianState;
import org.example.costbudgeting.enums.Manufacturer;
import org.example.costbudgeting.enums.ProductType;

import java.io.Serializable;
import java.util.Map;

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

    @Column(name = "edital_number", nullable = false)
    private String editalNumber;

    @Column(name = "brazilian_state", nullable = false)
    private BrazilianState brazilianState;

    @Column(name = "manufacturer", nullable = false)
    private Manufacturer manufacturerer;

    @Column(name = "car_model", nullable = false)
    private String carModel;

    @Column(name = "product_type", nullable = false)
    private ProductType productType;

    @Column(name = "batch_size", nullable = false)
    private Integer batchSize;

    @Column(name = "responsible_employee", nullable = false)
    private String responsibleEmployee;

    @Column(name = "components", nullable = false)
    @OneToMany(mappedBy = "budget", cascade = CascadeType.ALL)
    private Map<String, Components> components;

    @Column(name = "unit_net_percentage", nullable = false)
    private Integer unitNetPercentage;

    @Column(name = "unit_net_order", nullable = false)
    private Integer unitNetOrder;

    @Column(name = "unit_gross_percentage", nullable = false)
    private Integer unitGrossPercentage;

    @Column(name = "unit_gross_order", nullable = false)
    private Integer unitGrossOrder;

}
