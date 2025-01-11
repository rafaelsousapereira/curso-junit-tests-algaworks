package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {


    @Test
    public void deveRetornarBoaTardeQuandoHoraEstiverManhaValida() {
        String saudacaoBomDia = SaudacaoUtil.saudar(9);
        assertEquals("Bom dia", saudacaoBomDia, "Saudação incorreta!");
    }

    //shouldReturnBoaTardeWhenTimeIsAfternoon
    @Test
    void deveRetornarBoaTardeQuandoHoraEstiverDeTardeValida() {
        String saudacaoBoaTarde = SaudacaoUtil.saudar(14);
        assertEquals("Boa tarde", saudacaoBoaTarde, "Saudação incorreta!");
    }

    @Test
    void deveRetornarBoaNoiteQuandoHoraEstiverDeNoiteValida() {
        String saudacaoBoaNoite = SaudacaoUtil.saudar(20);
        assertEquals("Boa noite", saudacaoBoaNoite, "Saudação incorreta!");
    }

    @Test
    public void deveLancarException() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
                () -> SaudacaoUtil.saudar(-10));
        assertEquals("Hora inválida", illegalArgumentException.getMessage());
    }

    @Test
    public void naoDeveLancarException() {
        assertDoesNotThrow(() -> SaudacaoUtil.saudar(10));
    }
}