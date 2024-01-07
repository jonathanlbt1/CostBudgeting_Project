package org.example.costbudgeting.entities.taxes.enums;

import lombok.Getter;

@Getter
public enum ICMS {

    ICMS_ISENTO(0),
    ICMS_12(12),
    ICMS_18(18),
    ICMS_25(25);

    private final int value;

    ICMS(int value) {
        this.value = value;
    }
}
