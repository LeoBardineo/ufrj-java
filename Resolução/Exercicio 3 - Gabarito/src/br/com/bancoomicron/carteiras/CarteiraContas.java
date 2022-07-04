package br.com.bancoomicron.carteiras;

import br.com.bancoomicron.contas.Conta;
import java.util.ArrayList;

public class CarteiraContas implements IAuditoria {

    private ArrayList<Conta> contas;

    public CarteiraContas() {
        this.contas = new ArrayList<>();
    }

    public int tamanho() {
        return this.contas.size();
    }

    public int quantidadeContas() {
        return this.tamanho();
    }

    public double somaSaldo() {
        double soma = 0;
        for (Conta c : this.contas) {
            soma += c.getSaldo();
        }
        return soma;
    }

    public void adicionarConta(Conta c) {
        this.contas.add(c);
    }

    public boolean removerConta(int numero) {
        for (int i=0;i<this.contas.size();++i) {
            Conta c = this.contas.get(i);
            if (c.getNumero() == numero) {
                this.contas.remove(i);
                return true;
            }
        }
        return false;
    }

}
