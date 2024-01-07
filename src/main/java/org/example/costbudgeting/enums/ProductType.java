package org.example.costbudgeting.enums;

import lombok.Getter;


@Getter
public enum ProductType {

    POLICE_CAR("Police Car"),
    AMBULANCE("Ambulance"),
    POLICE_MOTORCYCLE("Police Motorcycle"),
    CUSTOMIZED_CARS("Customized Cars"),
    CUSTOMIZED_MOTORCYCLE("Customized Motorcycle"),
    OTHER("Other");

    private final String name;

    ProductType(String name) {
        this.name = name;
    }

}
