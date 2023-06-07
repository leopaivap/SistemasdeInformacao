package prova;

public class Portatil extends Computador implements Comunicacao{
    public Portatil(String marca, String modelo, String cor, double peso, Data dataGarantia){
        super(marca, modelo, cor, peso, dataGarantia);
    }
    
    @Override
    public void ligar(){
        System.out.println("O computador portatil esta ligado!");
    }
    
    @Override
    public void desligar(){
        System.out.println("O computador portatil esta desligado!");
    }
    
    @Override
    public void dadosAparelho(){
        System.out.println("Marca Computador Portatil: " + this.getMarca());
        System.out.println("Modelo Computador Portatil: " + this.getModelo());
        System.out.println("Cor Computador Portatil: " + this.getCor());
        System.out.println("Peso Computador Portatil: " + this.getPeso());
        System.out.println("Data Garantia Computador Portatil: " + this.getDataGarantia());
    }
    
    @Override
    public void autenticaRede() {
        System.out.println("O computador portatil " + this.getModelo() + " esta autenticado na rede!");
    }
}
