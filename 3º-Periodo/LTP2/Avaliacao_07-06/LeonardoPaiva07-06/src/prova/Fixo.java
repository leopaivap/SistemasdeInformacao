package prova;

public class Fixo extends Telefone implements Comunicacao{
    public Fixo(String marca, String modelo, String cor, double peso, Data dataGarantia){
        super(marca, modelo, cor, peso, dataGarantia);
    }
    
    @Override
    public void ligar(){
        System.out.println("O telefone fixo esta ligado!");
    }
    
    @Override
    public void desligar(){
        System.out.println("O telefone fixo esta desligado!");
    }
    
    @Override
    public void dadosAparelho(){
        System.out.println("Marca Telefone Fixo: " + this.getMarca());
        System.out.println("Modelo Telefone Fixo: " + this.getModelo());
        System.out.println("Cor Telefone Fixo: " + this.getCor());
        System.out.println("Peso Telefone Fixo: " + this.getPeso());
        System.out.println("Data Garantia Telefone Fixo: " + this.getDataGarantia());
    }
    
    @Override
    public void autenticaRede() {
        System.out.println("O telefone fixo " + this.getModelo() + " esta autenticado na rede!");
    }
}
