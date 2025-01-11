package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PessoaTest {

    @Test
    void assercaoPessoa() {
        Pessoa pessoa = new Pessoa("Rafael", "Sousa");

        Assertions.assertAll("Asserção de Pessoa",
                () -> Assertions.assertEquals("Rafael", pessoa.getNome()),
                () -> Assertions.assertEquals("Sousa", pessoa.getSobrenome())
        );
    }

}