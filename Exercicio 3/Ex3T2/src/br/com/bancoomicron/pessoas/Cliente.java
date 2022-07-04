package br.com.bancoomicron.pessoas;

import br.com.bancoomicron.carteiras.CarteiraContas;
import br.com.bancoomicron.contas.Conta;

public class Cliente extends Pessoa {
    private CarteiraContas contas;
    private int matricula;
    public static int gerador_matricula = 0;

    public Cliente(String cpf, String nome){
        super(cpf, nome);
        this.matricula = Cliente.geraMatricula();
        this.contas = new CarteiraContas();
    }

    public Cliente(String cpf, String nome, Conta conta){
        super(cpf, nome);
        this.matricula = Cliente.geraMatricula();
        this.contas = new CarteiraContas();
        this.contas.adicionarConta(conta);
    }

    public static int geraMatricula(){
        return gerador_matricula++;
    }

    public double somaSaldos(){
        return this.contas.somaSaldo();
    }

    public int numContas(){
        return this.contas.quantidadeContas();
    }

    public int getMatricula(){
        return this.matricula;
    }

    public void adicionarConta(Conta c){
        this.contas.adicionarConta(c);
    }

    public boolean removerConta(int numero_conta){
        return this.contas.removerConta(numero_conta);
    }
}
