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

    @Column(name = "source_checked")
    private String sourceChecked;

    @Column(name = "raw_material_name")
    private String rawMaterialName;

    @Column(name = "price")
    private Long price;

    @OneToOne
    @JoinColumn(name = "taxes_id", nullable = false)
    private Taxes taxes;

    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "components_id", nullable = false)
    private Components components;

    public Double getUnitCostOfRawMaterial(){
        var totalTaxesPerUnit = this.taxes.getIcms().getValue() *
                this.taxes.getPis_cofins().getValue() * this.taxes.getIpi().getValue();
        return totalTaxesPerUnit / 100 * price;
    }

    public Double getTotalCostOfRawMaterials() {
        return getUnitCostOfRawMaterial() * quantity;
    }

}
