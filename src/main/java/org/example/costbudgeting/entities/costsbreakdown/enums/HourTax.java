package org.example.costbudgeting.entities.costsbreakdown.enums;

import lombok.Getter;

@Getter
public enum HourTax {

    HOUR_TAX_ISENTO(0L),
    HOUR_TAX_75(75L),
    HOUR_TAX_100(100L),
    HOUR_TAX_150(150L);

    private final Long value;

    HourTax(Long value) {
        this.value = value;
    }
}
