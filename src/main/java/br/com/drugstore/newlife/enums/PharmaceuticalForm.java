package br.com.drugstore.newlife.enums;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum PharmaceuticalForm {
    ORAL("Oral", 1),
    NASAL("Nasal", 2),
    VENOSO("Venoso", 3),
    INTRAMUSCULAR("Intramuscular", 4),
    RETAL("Retal", 5);

    private final String name;
    private final int code;

    PharmaceuticalForm(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public Integer convertDataToCode(PharmaceuticalForm data) {
        return (data != null) ? data.getCode() : null;
    }

    public String convertIntToString(int code) {
        return Arrays.stream(PharmaceuticalForm.values())
                .filter(form -> form.getCode() == code)
                .findFirst()
                .map(PharmaceuticalForm::getName)
                .orElseThrow(() -> new IllegalArgumentException("Código inválido: " + code));
    }

    public PharmaceuticalForm fromCode(int code) {
        return Arrays.stream(PharmaceuticalForm.values())
                .filter(form -> form.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código inválido: " + code));
    }
}
