package org.example.costbudgeting.entities.taxes.enums;

import lombok.Getter;

@Getter
public enum IPI {

    IPI_ISENTO(0),
    IPI_5(5),
    IPI_10(10),
    IPI_15(15);

    private final int value;

    IPI(int value) {
        this.value = value;
    }
}
