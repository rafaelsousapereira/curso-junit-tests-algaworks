package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class SaudacaoUtilTest {


    @Test
    public void deveRetornarBoaTardeQuandoHoraEstiverManhaValida() {
        int horaValida = 9;
        String saudarBomDia = SaudacaoUtil.saudar(horaValida);
        assertEquals("Bom dia", saudarBomDia, "Saudação incorreta!");
    }

    @Test
    public void deveRetornarBoaTardeQuandoHoraEstiverManhaValidaAPartirDas5h() {
        int horaValida = 5;
        String saudarBomDia = SaudacaoUtil.saudar(horaValida);
        assertEquals("Bom dia", saudarBomDia, "Saudação incorreta!");
    }

    //shouldReturnBoaTardeWhenTimeIsAfternoon
    @Test
    void deveRetornarBoaTardeQuandoHoraEstiverDeTardeValida() {
        int horaValida = 14;
        String saudarBoaTarde = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa tarde", saudarBoaTarde, "Saudação incorreta!");
    }

    @Test
    void deveRetornarBoaNoiteQuandoHoraEstiverDeNoiteValida() {
        int horaValida = 22;
        String saudarBoaNoite = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa noite", saudarBoaNoite, "Saudação incorreta!");
    }

    @Test
    void deveRetornarBoaNoiteQuandoHoraEstiverDeNoiteValidaAPartirDas4h() {
        int horaValida = 4;
        String saudarBoaNoite = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa noite", saudarBoaNoite, "Saudação incorreta!");
    }

    @Test
    public void deveLancarException() {
        int horaInvalida = -10;
        Executable chamadaInvalidaMetodo = () -> SaudacaoUtil.saudar(horaInvalida);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, chamadaInvalidaMetodo);
        assertEquals("Hora inválida", exception.getMessage());
    }

    @Test
    public void naoDeveLancarException() {
        int horaValida = 10;
        Executable chamadaValidaMetodo = () -> SaudacaoUtil.saudar(horaValida);
        assertDoesNotThrow(chamadaValidaMetodo);
    }
}