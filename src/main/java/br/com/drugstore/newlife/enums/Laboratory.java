package br.com.drugstore.newlife.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Laboratory {
    EMS("EMS", 1),
    ACHE("Aché", 2),
    EUROFARMA("Eurofarma", 3),
    NEOQUIMICA("Neo Quimica", 4),
    CRISTALIA("Cristalia", 5),
    PFIZER("Pfizer", 6);

    private String name;
    private final int code;

    Laboratory(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public Integer convertDataToCode(Laboratory data) {
        return (data != null) ? data.getCode() : null;
    }

    public String convertIntToString(int code) {
        return Arrays.stream(Laboratory.values())
                .filter(lab -> lab.getCode() == code)
                .findFirst()
                .map(Laboratory::getName)
                .orElseThrow(() -> new IllegalArgumentException("Código inválido: " + code));
    }

    public Laboratory fromCode(int code) {
        return Arrays.stream(Laboratory.values())
                .filter(lab -> lab.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código inválido: " + code));
    }
}
