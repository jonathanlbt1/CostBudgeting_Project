package org.example.costbudgeting.entities.taxes.enums;

import lombok.Getter;

@Getter
public enum PIS_COFINS {

    PIS_COFINS_ISENTO(0),
    PIS_COFINS_1_65(1.65),
    PIS_COFINS_7_6(7.6),
    PIS_COFINS_9_25(9.25);

    private final double value;

    PIS_COFINS(double value) {
        this.value = value;
    }
}
