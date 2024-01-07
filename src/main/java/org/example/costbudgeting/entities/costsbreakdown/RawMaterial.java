package org.example.costbudgeting.entities.costsbreakdown;

import jakarta.persistence.*;
import lombok.*;
import org.example.costbudgeting.entities.taxes.Taxes;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RawMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sourceChecked;
    private Long price;

    @OneToOne
    private Taxes taxes;
    private Integer quantity;

    public Double getUnitCostOfRawMaterial(){
        var totalTaxesPerUnit = this.taxes.getIcms().getValue() *
                this.taxes.getPis_cofins().getValue() * this.taxes.getIpi().getValue();
        return totalTaxesPerUnit / 100 * price;
    }

    public Double getTotalCostOfRawMaterials() {
        return getUnitCostOfRawMaterial() * quantity;
    }

    @ManyToOne
    @JoinColumn(name = "components_id", nullable = false)
    private Components components;
}
