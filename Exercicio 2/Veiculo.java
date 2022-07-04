// Leonardo de Melo Soares, 120134414
public class Veiculo {
    public String marca;
    public String modelo;
    public String dono;
    private double tanque_capacid;
    private double tanque_atual = 0;
    private double autonomia_km_l;
    private double km_rodados = 0;

    public Veiculo(String marca, String modelo, String dono, double tanque_capacid, double autonomia_km_l) {
        this.marca = marca;
        this.modelo = modelo;
        this.dono = dono;

        if(validarProp(autonomia_km_l)){
            this.autonomia_km_l = autonomia_km_l;
        }else{
            this.autonomia_km_l = 10;
            System.out.println("Parâmetro inválido!");
        }

        if(validarProp(tanque_capacid)){
            this.tanque_capacid = tanque_capacid;
        }else{
            this.tanque_capacid = 10;
            System.out.println("Parâmetro inválido!");
        }
    }

    public double lerTanqueAtual(){
        return this.tanque_atual;
    }

    public double lerTanqueCapacidad(){
        return this.tanque_capacid;
    }

    public double lerAutonomia(){
        return this.autonomia_km_l;
    }

    public double lerRodagem(){
        return this.km_rodados;
    }

    public boolean alterarAutonomia(double autonomia){
        if (!validarProp(autonomia)) {
            return false;
        }
        this.autonomia_km_l = autonomia;
        return true;
    }

    public boolean abastecerTanque(double litros){
        if (!validarProp(litros) || this.tanque_atual + litros > this.tanque_capacid) {
            return false;
        }
        this.tanque_atual += litros;
        return true;
    }

    public boolean fazerViagem(double km){
        if (km / this.autonomia_km_l > tanque_atual) {
            return false;
        }
        this.tanque_atual -= km / this.autonomia_km_l;
        this.km_rodados += km;
        return true;
    }

    private boolean validarProp(double prop){
        if (prop > 0) {
            return true;
        }
        return false;
    }
}