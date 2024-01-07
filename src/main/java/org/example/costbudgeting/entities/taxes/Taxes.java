package org.example.costbudgeting.entities.taxes;

import jakarta.persistence.*;
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

    @Enumerated
    private ICMS icms;

    @Enumerated
    private IPI ipi;

    @Enumerated
    private PIS_COFINS pis_cofins;

}
