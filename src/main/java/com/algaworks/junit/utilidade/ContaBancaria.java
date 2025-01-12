package com.algaworks.junit.utilidade;

import java.math.BigDecimal;
import java.util.Objects;

public class ContaBancaria {

    private BigDecimal saldo;

    public ContaBancaria(BigDecimal saldo) {
        //TODO 1 - validar saldo: não pode ser nulo, caso seja, deve lançar uma IllegalArgumentException
        if (Objects.isNull(saldo)) {
            throw new IllegalArgumentException("Saldo não pode ser nulo");
        }

        //TODO 2 - pode ser zero ou negativo
        if (BigDecimal.ZERO.compareTo(saldo) >= 0 || saldo.compareTo(BigDecimal.ZERO) < 0) {
            this.setSaldo(saldo);
        }

        this.saldo = saldo;
    }

    public void saque(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        validarSeValorNuloOuMenorQueZeroOuIgualAZero(valor);

        //TODO 2 - Deve subtrair o valor do saldo
        this.saldo = this.saldo.subtract(valor);

        //TODO 3 - Se o saldo for insuficiente deve lançar uma RuntimeException
        if (this.saldo.compareTo(BigDecimal.ZERO) < valor.compareTo(BigDecimal.ZERO)) {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public void deposito(BigDecimal valor) {
        //TODO 1 - validar valor: não pode ser nulo, zero ou menor que zero, caso seja, deve lançar uma IllegalArgumentException
        validarSeValorNuloOuMenorQueZeroOuIgualAZero(valor);

        //TODO 2 - Deve adicionar o valor ao saldo
        this.saldo = this.saldo.add(valor);
    }

    private static void validarSeValorNuloOuMenorQueZeroOuIgualAZero(BigDecimal valor) {
        if (Objects.isNull(valor) || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor não pode ser nulo, zero ou menor que zero");
        }
    }

    public BigDecimal saldo() {
        //TODO 1 - retornar saldo
        return this.saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }
}
