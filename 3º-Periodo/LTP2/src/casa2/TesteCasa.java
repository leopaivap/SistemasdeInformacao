/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa2;



/**
 *
 * @author tulio
 */
public class TesteCasa {
    public static void main(String[] args) {
        Casa objCasa = new Casa();
        Porta p1 = new Porta();
        p1.abre();
        p1.pinta("Azul");
        Porta p2 = new Porta();
        p2.abre();
        Porta p3 = new Porta();
        p3.fecha();
      
        objCasa.listaPorta.add(p1);
        objCasa.listaPorta.add(p2);
        objCasa.listaPorta.add(p3);
        objCasa.pinta("Vermelho");
        objCasa.relPortas();
     }
    
}
