package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public  class ContaBancariaTest {

    @Test
    void deveLancarExceptionQuandoSaldoForNulo() {
        String mensagem = "Saldo não pode ser nulo";
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> new ContaBancaria(null));
        Assertions.assertEquals(mensagem, illegalArgumentException.getMessage());
    }

    @Test
    void deveRetornarSaldoQuandoForZeroOuSaldoNegativo() {
        Assertions.assertDoesNotThrow(() -> new ContaBancaria(BigDecimal.ZERO));
        Assertions.assertDoesNotThrow(() -> new ContaBancaria(BigDecimal.valueOf(-10)));
    }

    @Test
    void deveLancarExceptionQuandoValorSaqueSejaNulo() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> contaBancaria.saque(null));

        Assertions.assertEquals("O valor não pode ser nulo, zero ou menor que zero",
                illegalArgumentException.getMessage());
    }

    @Test
    void deveLancarExceptionQuandoValorSaqueForMenorOuIgualAZero() {
        BigDecimal valorSaque = BigDecimal.valueOf(-10);
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> contaBancaria.saque(valorSaque));

        Assertions.assertEquals(valorSaque, BigDecimal.valueOf(-10));
        Assertions.assertEquals("O valor não pode ser nulo, zero ou menor que zero",
                illegalArgumentException.getMessage());
    }

    @Test
    void deveSubtrairValorSaldoDaConta() {
        BigDecimal valorSaque = BigDecimal.valueOf(100);
        ContaBancaria contaBancaria = new ContaBancaria(valorSaque);
        contaBancaria.saque(BigDecimal.valueOf(50));

        Assertions.assertEquals(BigDecimal.valueOf(50), contaBancaria.saldo());
    }

    @Test
    void deveLancarExceptionQuandoSaldoDaContaInsuficiente() {
        BigDecimal valorSaque = BigDecimal.valueOf(30);
        ContaBancaria contaBancaria = new ContaBancaria(valorSaque);

        RuntimeException runtimeException = Assertions.assertThrows(RuntimeException.class,
                () -> contaBancaria.saque(BigDecimal.valueOf(100)));
        Assertions.assertEquals("Saldo insuficiente", runtimeException.getMessage());
    }

    @Test
    void deveLancarExceptionQuandoValorDepositoSejaNulo() {
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> contaBancaria.deposito(null));

        Assertions.assertEquals("O valor não pode ser nulo, zero ou menor que zero",
                illegalArgumentException.getMessage());
    }

    @Test
    void deveLancarExceptionQuandoValorDepositoForMenorOuIgualAZero() {
        BigDecimal valorSaque = BigDecimal.valueOf(-10);
        ContaBancaria contaBancaria = new ContaBancaria(BigDecimal.ZERO);

        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class,
                () -> contaBancaria.deposito(valorSaque));

        Assertions.assertEquals(valorSaque, BigDecimal.valueOf(-10));
        Assertions.assertEquals("O valor não pode ser nulo, zero ou menor que zero",
                illegalArgumentException.getMessage());
    }

    @Test
    void deveAdicionarValorSaldoDaConta() {
        BigDecimal valorSaque = BigDecimal.valueOf(100);
        ContaBancaria contaBancaria = new ContaBancaria(valorSaque);
        contaBancaria.deposito(BigDecimal.valueOf(50));

        Assertions.assertEquals(BigDecimal.valueOf(150), contaBancaria.saldo());
    }

    @Test
    void deveRetornarSaldoContaBancaria() {
        BigDecimal valorSaldo = BigDecimal.valueOf(100);
        ContaBancaria contaBancaria = new ContaBancaria(valorSaldo);

        Assertions.assertEquals(valorSaldo, contaBancaria.saldo());
    }

}