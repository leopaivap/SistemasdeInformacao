package Interfaces;

public class Teste {
    public static void main(String[] args) {
        AreaCalculavel a = new Retangulo(3, 2);
        System.out.println(a.calculaArea());
        
        AreaCalculavel c1 = new Circulo(2);
        System.out.println(c1.calculaArea());
    }
}
