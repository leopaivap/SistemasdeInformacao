/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa;

/**
 *
 * @author 02210412650
 */
public class TestaPorta {
    public static void main(String[] args) {
        Porta p1 = new Porta();
        p1.setCor("marrom claro");
        p1.setDimensaoX(1.0);
        p1.setDimensaoY(1.8);
        p1.setDimensaoZ(0.15);
        
        p1.estaAberta();
        System.out.println("Cor da porta: " + p1.getCor());
        System.out.println("Dimensoes(X/Y/Z): " + p1.getDimensaoX() + " x " + p1.getDimensaoY() + " x " + p1.getDimensaoZ());
        
        p1.setDimensaoX(1.1);
        p1.setDimensaoY(1.95);
        
        p1.pinta("Marrom Escuro");
        p1.abre();
        
        System.out.println("");
        p1.estaAberta();
        System.out.println("Cor da porta: " + p1.getCor());
        System.out.println("Dimensoes(X/Y/Z): " + p1.getDimensaoX() + " x " + p1.getDimensaoY() + " x " + p1.getDimensaoZ());
        
        
    }
}
