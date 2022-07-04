package br.com.bancoomicron.carteiras;
import br.com.bancoomicron.pessoas.Cliente;
import java.util.ArrayList;

public class CarteiraClientes implements IAuditoria{
    private ArrayList<Cliente> clientes;

    public CarteiraClientes(){
        this.clientes = new ArrayList<>();
    }

    public int quantidadeContas(){
        int quantidade = 0;
        for (Cliente cliente : this.clientes) {
            quantidade += cliente.numContas();
        }
        return quantidade;
    }

    public double somaSaldo(){
        double soma = 0;
        for (Cliente cliente : this.clientes) {
            soma += cliente.somaSaldos();
        }
        return soma;
    }

    public void adicionaCliente(Cliente c){
        this.clientes.add(c);
    }

    public boolean removerCliente(String cpf) {
        int i = this.getIndicePorCPF(cpf);
        if (i >= 0) {
            this.clientes.remove(i);
            return true;
        }
        return false;
    }

    public int removerCliente(String[] cpfs) {
        int quantidade = 0;
        for (int i = 0; i < cpfs.length; i++) {
            int indice = this.getIndicePorCPF(cpfs[i]);
            if(indice >= 0){
                this.clientes.remove(indice);
                quantidade++;
            }
        }
        return quantidade;
    }

    public Cliente buscaCPF(String cpf) {
        int i = this.getIndicePorCPF(cpf);
        if (i >= 0) {
            return this.clientes.get(i);
        }
        return null;
    }

    private int getIndicePorCPF(String cpf){
        for (int i = 0; i < this.clientes.size(); i++) {
            Cliente cliente = this.clientes.get(i);
            if (cliente.getCpf().equals(cpf)) {
                return i;
            }
        }
        return -1;
    }

}
