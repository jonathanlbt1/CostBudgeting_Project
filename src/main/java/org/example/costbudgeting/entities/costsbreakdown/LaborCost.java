package org.example.costbudgeting.entities.costsbreakdown;

import jakarta.persistence.*;
import lombok.*;
import org.example.costbudgeting.entities.costsbreakdown.enums.HourTax;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LaborCost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "labor_cost_name")
    private String laborCostName;

    @Column(name = "hour_tax")
    private HourTax hourTax;

    @Column(name = "budget_time")
    private Long budgetTime;

    public Double getTotalLaborCost(){
        var hourTax = this.hourTax;
        var budgetTime = this.budgetTime;
        return (double) (hourTax.getValue() * budgetTime);
    }

    @ManyToOne
    @JoinColumn(name = "components_id", nullable = false)
    private Components components;
}
