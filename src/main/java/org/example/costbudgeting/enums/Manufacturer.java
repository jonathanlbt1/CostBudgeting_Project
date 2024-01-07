package org.example.costbudgeting.enums;

import lombok.Getter;

@Getter
public enum Manufacturer {

    VOLKSWAGEN("Volkswagen"),
    FORD("Ford"),
    FIAT("Fiat"),
    CHEVROLET("Chevrolet"),
    HONDA("Honda"),
    TOYOTA("Toyota"),
    HYUNDAI("Hyundai"),
    RENAULT("Renault"),
    PEUGEOT("Peugeot"),
    CITROEN("Citroen");

    private final String name;

    Manufacturer(String name) {
        this.name = name;
    }
}
