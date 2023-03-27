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
public class TesteCasa {
    public static void main(String[] args) {
        Casa objCasa = new Casa();
        //Porta p1 = new Porta();
        //Porta p2 = new Porta();
        //Porta p3 = new Porta();
        //objCasa.porta1 = p1;
        //objCasa.porta2 = p2;
        //objCasa.porta3 = p3;
        objCasa.porta1.abre();
        objCasa.pinta("Vermelho");
        System.out.println("Portas abertas:"+objCasa.quantasPortasEstaoAbertas());
    }
    
}
