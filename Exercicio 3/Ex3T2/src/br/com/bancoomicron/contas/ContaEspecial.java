package br.com.bancoomicron.contas;

public class ContaEspecial extends ContaCorrente {
    private double cheque_especial;
    private final double taxa_iof = 0.03;

    public ContaEspecial(int numero, int matricula_cliente, double cheque_especial){
        super(numero, matricula_cliente);
    }

    @Override
    public boolean sacar(double valor){
        if(this.saldo >= valor){
            this.saldo -= valor;
            return true;
        }

        double novo_valor;
        if(this.saldo > 0) {
            novo_valor = (valor - this.saldo) * this.taxa_iof;
        }else{
            novo_valor = valor * taxa_iof;
        }

        if(cheque_especial >= this.saldo - novo_valor){
            this.saldo -= novo_valor;
            return true;
        }
        return false;
    }

}
