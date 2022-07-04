package br.com.bancoomicron.contas;

public class ContaCorrente extends Conta {
    public ContaCorrente(int numero, int matricula_cliente) {
        super(numero, matricula_cliente);
    }

    @Override
    public boolean sacar(double valor){
        if(this.getSaldo() >= valor){
            this.saldo -= valor;
            return true;
        }
        return false;
    }
}
