package br.com.drugstore.newlife.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum PharmaceuticalForm {
    ORAL("Oral", 1),
    NASAL("Nasal", 2),
    VENOSO("Venoso", 3),
    INTRAMUSCULAR("Intramuscular", 4),
    RETAL("Retal", 5);

    private final String name;
    private final int code;

    public static String getNameByCode(int code) {
        return Arrays.stream(PharmaceuticalForm.values())
                .filter(form -> form.getCode() == code)
                .findFirst()
                .map(PharmaceuticalForm::getName)
                .orElseThrow(() -> new IllegalArgumentException("Código inválido: " + code));
    }

    public static PharmaceuticalForm fromCode(int code) {
        return Arrays.stream(PharmaceuticalForm.values())
                .filter(form -> form.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Código inválido: " + code));
    }
}
