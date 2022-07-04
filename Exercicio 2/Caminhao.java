// Leonardo de Melo Soares, 120134414
public class Caminhao extends Veiculo{
    public int qnt_eixos;
    private double capacid_carga;

    public Caminhao(String marca, String modelo, String dono, double tanque_capacid, double autonomia_km_l, int qnt_eixos, double capacid_carga) {
        super(marca, modelo, dono, tanque_capacid, autonomia_km_l);
        this.qnt_eixos = qnt_eixos;
        this.capacid_carga = capacid_carga;
        this.km_rodados = 0;
    }
    
    public Caminhao(String marca, String modelo, String dono, double tanque_capacid, double autonomia_km_l, double km_rodados, double capacid_carga, int qnt_eixos){
        super(marca, modelo, dono, tanque_capacid, autonomia_km_l);
        alterarKMRodados(km_rodados);
        this.qnt_eixos = qnt_eixos;
        this.capacid_carga = capacid_carga;
    }

    public double lerCapacidCarga(){
        return capacid_carga;
    }

    public boolean fazerViagem(double km, double carga){
        if(lerCapacidCarga() < carga) {
            return false
        }
        return fazerViagem(km);
    }
}
