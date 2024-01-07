package org.example.costbudgeting.entities.costsbreakdown;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private HourTax hourTax;
    private Long budgetTime;

    public Long getTotalLaborCost(HourTax hourTax, Long budgetTime){
        return hourTax.getValue() * budgetTime;
    }
}