package org.example.costbudgeting.enums;

import lombok.Getter;

@Getter
public enum EditalState {

    MG("Minas Gerais"),
    SP("São Paulo"),
    RJ("Rio de Janeiro"),
    ES("Espírito Santo"),
    PR("Paraná"),
    SC("Santa Catarina"),
    RS("Rio Grande do Sul"),
    MS("Mato Grosso do Sul"),
    MT("Mato Grosso"),
    GO("Goiás"),
    DF("Distrito Federal"),
    TO("Tocantins"),
    BA("Bahia"),
    SE("Sergipe"),
    AL("Alagoas"),
    PE("Pernambuco"),
    PB("Paraíba"),
    RN("Rio Grande do Norte"),
    CE("Ceará"),
    PI("Piauí"),
    MA("Maranhão"),
    PA("Pará"),
    AP("Amapá"),
    AM("Amazonas"),
    RR("Roraima"),
    AC("Acre");

    private final String name;

    EditalState(String name) {
        this.name = name;
    }
}
