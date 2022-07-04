package br.com.bancoomicron.contas;

import java.io.FileNotFoundException;

public class ContaCorrente extends Conta {

    public ContaCorrente(int numero, int matricula_cliente) {
        super(numero,matricula_cliente);
    }

    @Override
    public boolean sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
}
