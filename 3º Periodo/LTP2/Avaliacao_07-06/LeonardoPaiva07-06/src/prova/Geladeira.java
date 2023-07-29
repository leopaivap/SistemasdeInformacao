package prova;

public class Geladeira extends Aparelho{
    
    public Geladeira(String marca, String modelo, String cor, double peso, Data dataGarantia){
        super(marca, modelo, cor, peso, dataGarantia);
    }
    
    @Override
    public void ligar(){
        System.out.println("O geladeira esta ligada!");
    }
    
    @Override
    public void desligar(){
        System.out.println("O geladeira esta desligada!");
    }
    
    @Override
    public void dadosAparelho(){
        System.out.println("Marca Geladeira: " + this.getMarca());
        System.out.println("Modelo Geladeira: " + this.getModelo());
        System.out.println("Cor Geladeira: " + this.getCor());
        System.out.println("Peso Geladeira: " + this.getPeso());
        System.out.println("Data Garantia Geladeira: " + this.getDataGarantia());
    }
    
       
}
