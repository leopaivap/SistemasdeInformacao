package prova;

public class Movel extends Telefone implements Comunicacao{
    public Movel(String marca, String modelo, String cor, double peso, Data dataGarantia){
         super(marca, modelo, cor, peso, dataGarantia);
    }
    
    @Override
    public void ligar(){
        System.out.println("O telefone movel esta ligado!");
    }
    
    @Override
    public void desligar(){
        System.out.println("O telefone movel esta desligado!");
    }
    
    @Override
    public void dadosAparelho(){
        System.out.println("Marca Telefone Movel: " + this.getMarca());
        System.out.println("Modelo Telefone Movel: " + this.getModelo());
        System.out.println("Cor Telefone Movel: " + this.getCor());
        System.out.println("Peso Telefone Movel: " + this.getPeso());
        System.out.println("Data Garantia Telefone Movel: " + this.getDataGarantia());
    }

    @Override
    public void autenticaRede() {
        System.out.println("O telefone movel " + this.getModelo() + " esta autenticado na rede!");
    }
    
    
}
