package prova;

public class Mesa extends Computador implements Comunicacao{
    public Mesa(String marca, String modelo, String cor, double peso, Data dataGarantia){
        super(marca, modelo, cor, peso, dataGarantia);
    }

     @Override
    public void ligar(){
        System.out.println("O computador de mesa esta ligado!");
    }
    
    @Override
    public void desligar(){
        System.out.println("O computador de mesa esta desligado!");
    }
    
    @Override
    public void dadosAparelho(){
        System.out.println("Marca Computador de Mesa: " + this.getMarca());
        System.out.println("Modelo Computador  de Mesa: " + this.getModelo());
        System.out.println("Cor Computador de Mesa: " + this.getCor());
        System.out.println("Peso Computador de Mesa: " + this.getPeso());
        System.out.println("Data Garantia Computador de Mesa: " + this.getDataGarantia());
    }
    
    @Override
    public void autenticaRede() {
        System.out.println("O computador de mesa " + this.getModelo() + " esta autenticado na rede!");
    }
}
