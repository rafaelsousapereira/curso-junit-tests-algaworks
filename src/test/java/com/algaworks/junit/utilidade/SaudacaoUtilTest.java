package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes do utilitário de saudação")
class SaudacaoUtilTest {


    @Test
    @DisplayName("Deve retornar bom dia quando hora estiver válida de manhã")
    public void deveRetornarBoaTardeQuandoHoraEstiverManhaValida() {
        int horaValida = 9;
        String saudarBomDia = SaudacaoUtil.saudar(horaValida);
        assertEquals("Bom dia", saudarBomDia, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deve retornar boa tarde quando hora estiver válida de manhã")
    public void deveRetornarBoaTardeQuandoHoraEstiverManhaValidaAPartirDas5h() {
        int horaValida = 5;
        String saudarBomDia = SaudacaoUtil.saudar(horaValida);
        assertEquals("Bom dia", saudarBomDia, "Saudação incorreta!");
    }

    //shouldReturnBoaTardeWhenTimeIsAfternoon
    @Test
    @DisplayName("Deve retornar boa tarde quando hora estiver de tarde")
    void deveRetornarBoaTardeQuandoHoraEstiverDeTardeValida() {
        int horaValida = 14;
        String saudarBoaTarde = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa tarde", saudarBoaTarde, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deve retornar boa tarde quando hora estiver de tarde")
    void deveRetornarBoaNoiteQuandoHoraEstiverDeNoiteValida() {
        int horaValida = 22;
        String saudarBoaNoite = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa noite", saudarBoaNoite, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deve retornar boa tarde quando hora estiver de tarde")
    void deveRetornarBoaNoiteQuandoHoraEstiverDeNoiteValidaAPartirDas4h() {
        int horaValida = 4;
        String saudarBoaNoite = SaudacaoUtil.saudar(horaValida);
        assertEquals("Boa noite", saudarBoaNoite, "Saudação incorreta!");
    }

    @Test
    @DisplayName("Deve lançar excessão quando hora estiver inválida")
    public void deveLancarExceptionQuandoHoraEstiverInvalida() {
        int horaInvalida = -10;
        Executable chamadaInvalidaMetodo = () -> SaudacaoUtil.saudar(horaInvalida);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, chamadaInvalidaMetodo);
        assertEquals("Hora inválida", exception.getMessage());
    }

    @Test
    @DisplayName("Não deve lançar excessão quando hora estiver válida")
    public void naoDeveLancarExceptionQuandoHoraEstiverValida() {
        int horaValida = 10;
        Executable chamadaValidaMetodo = () -> SaudacaoUtil.saudar(horaValida);
        assertDoesNotThrow(chamadaValidaMetodo);
    }
}