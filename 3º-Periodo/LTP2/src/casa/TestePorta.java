/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa;

/**
 *
 * @author tulio
 */
public class TestePorta {
    public static void main(String[] args) {
        Porta p1 = new Porta();
        Porta p2 = new Porta();
        p1.pinta("Azul");
        p1.setDimensaoX(0.8);
        p1.setDimensaoY(1.8);
        p1.setDimensaoZ(0.3);
        p1.fecha();
        p1.abre();
        p1.estaAberta();
    }
    
}
