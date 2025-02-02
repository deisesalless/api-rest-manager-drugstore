package br.com.drugstore.newlife.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum Laboratory {
    EMS("EMS", 1),
    ACHE("Aché", 2),
    EUROFARMA("Eurofarma", 3),
    NEOQUIMICA("Neo Quimica", 4),
    CRISTALIA("Cristalia", 5),
    PFIZER("Pfizer", 6);

    private final String name;
    private final int code;

    public static String getNameByCode(int code) {
        return Arrays.stream(Laboratory.values())
                .filter(lab -> lab.getCode() == code)
                .findFirst()
                .map(Laboratory::getName)
                .orElseThrow(() -> new IllegalArgumentException("Código inválido: " + code));
    }

    public static Laboratory fromCode(int code) {
        return Arrays.stream(Laboratory.values())
                .filter(lab -> lab.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código inválido: " + code));
    }
}
