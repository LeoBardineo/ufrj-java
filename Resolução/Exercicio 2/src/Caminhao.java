public class Caminhao extends Veiculo{
    public int qnt_eixos;
    private double capacid_carga;

    public Caminhao(String marca,
                    String modelo,
                    String dono,
                    double tanque_capacidad,
                    double autonomia_km_l,
                    double capacidade_carga,
                    int qnt_eixos) {
        super(marca,modelo,dono,tanque_capacidad,autonomia_km_l);
        this.capacid_carga = capacidade_carga;
        this.qnt_eixos = qnt_eixos;
    }

    public Caminhao(String marca,
                    String modelo,
                    String dono,
                    double tanque_capacidad,
                    double autonomia_km_l,
                    double km_rodados,
                    double capacidade_carga,
                    int qnt_eixos) {
        this(marca,modelo,dono,tanque_capacidad,autonomia_km_l,capacidade_carga,qnt_eixos);
        this.alterarKMRodados(km_rodados);
    }

    public double lerCapacidCarga() {
        return this.capacid_carga;
    }

    public boolean fazerViagem(double km, double carga) {
        if (this.capacid_carga < carga) {
            return false;
        } else {
            return this.fazerViagem(km);
        }
    }
}
