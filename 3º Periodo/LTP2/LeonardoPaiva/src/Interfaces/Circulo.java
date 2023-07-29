package Interfaces;

public class Circulo implements AreaCalculavel{
    private double raio;
    
    public Circulo(double raio){
        this.raio = raio;
    }
    
    @Override
    public double calculaArea(){
        return Math.PI * this.raio * this.raio;
    }

    public double getRaio() {
        return raio;
    }
    
    
}
