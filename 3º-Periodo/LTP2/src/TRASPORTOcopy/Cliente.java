package TRASPORTOcopy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 02210412650
 */
public class Cliente {
    private String nome, cpf, rg;
    Caminhoneiro c1;
    Carreta carreta1;

    List<Viagem> listViagem = new ArrayList();

    Cliente(String nome, Caminhoneiro c1, Viagem viagem1, Carreta carreta1){
        this.nome = nome;
        this.c1 = c1;
        this.carreta1 = carreta1;
            
        listViagem.add(viagem1);

    }
    
    public void visualizarViagem(){
        System.out.println("Cliente: " + this.getNome());
        System.out.println("Caminhoneiro: " + this.c1.getNome());
        System.out.println("Veiculo: " + this.carreta1.getModeloCarreta());
        for(Viagem viagem:listViagem){
            System.out.println("-----------------------------");
            System.out.println("Destino: " + viagem.getDestino());
            System.out.println("Valor KM/Distancia: " + viagem.getValorKM() + " | " + viagem.getDistancia());
            System.out.println("Valor Total da Viagem: R$" +viagem.getValorViagem());

        }

    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
}
