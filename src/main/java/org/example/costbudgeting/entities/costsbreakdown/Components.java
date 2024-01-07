package org.example.costbudgeting.entities.costsbreakdown;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Components {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private RawMaterial rawMaterial;

    @ManyToOne
    private LaborCost laborCost;
}
