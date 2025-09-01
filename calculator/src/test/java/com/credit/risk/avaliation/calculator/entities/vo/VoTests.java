package com.credit.risk.avaliation.calculator.entities.vo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VoTests {
    @Test
    void deveCriarNomeValido() {
        assertDoesNotThrow(() -> new Nome("Maria"));
    }
    @Test
    void deveRejeitarNomeCurto() {
        assertThrows(IllegalArgumentException.class, () -> new Nome("A"));
    }
    @Test
    void deveValidarEmail() {
        assertThrows(IllegalArgumentException.class, () -> new Email("invalido"));
    }
}