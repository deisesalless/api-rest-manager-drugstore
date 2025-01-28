package br.com.drugstore.newlife.enums;

import lombok.Getter;

@Getter
public enum Laboratory {
    EMS("EMS", 1),
    ACHE("Aché", 2),
    EUROFARMA("Eurofarma", 3),
    NEOQUIMICA("Neo Quimica", 4),
    CRISTALIA("Cristalia", 5),
    PFIZER("Pfizer", 6);

    private String name;
    private final int type;

    Laboratory(String name, int type) {
        this.name = name;
        this.type = type;
    }
}
