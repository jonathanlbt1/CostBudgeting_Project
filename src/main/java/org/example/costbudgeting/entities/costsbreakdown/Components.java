package org.example.costbudgeting.entities.costsbreakdown;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.costbudgeting.entities.Budget;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Components {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String componentName;

    @OneToOne
    private RawMaterial rawMaterial;

    @OneToOne
    private LaborCost laborCost;

    @ManyToOne
    @JoinColumn(name = "budget_id", nullable = false)
    private Budget budget;
}
