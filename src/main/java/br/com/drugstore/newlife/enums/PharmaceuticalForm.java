package br.com.drugstore.newlife.enums;

import lombok.Getter;

@Getter
public enum PharmaceuticalForm {
    ORAL("Oral", 1),
    NASAL("Nasal", 2),
    VENOSO("Venoso", 3),
    INTRAMUSCULAR("Intramuscular", 4),
    RETAL("Retal", 5);

    private final String name;
    private final int type;

    PharmaceuticalForm(String name, int type) {
        this.name = name;
        this.type = type;
    }
}
