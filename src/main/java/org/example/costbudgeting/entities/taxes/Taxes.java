package org.example.costbudgeting.entities.taxes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.costbudgeting.entities.taxes.enums.ICMS;
import org.example.costbudgeting.entities.taxes.enums.IPI;
import org.example.costbudgeting.entities.taxes.enums.PIS_COFINS;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Taxes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ICMS icms;
    private IPI ipi;
    private PIS_COFINS pis_cofins;

}
