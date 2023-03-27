/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRASPORTO;

/**
 *
 * @author 02210412650
 */
public class Teste {
    public static void main(String[] args) {
        Carreta carreta1 = new Carreta("Carreta ct-7000");
        Caminhoneiro c1 = new Caminhoneiro("José", " XX. XXX. XXX/0001-XX", "123.123.123-12", 2500);
        Viagem viagem1 = new Viagem("Salvador", 2.5, 1750);
        Cliente cliente1 = new Cliente("Leo", c1, viagem1, carreta1);
        
        //metodo calcularViagem instanciado no construtor da viagem
        
        cliente1.visualizarViagem();
    }
}
