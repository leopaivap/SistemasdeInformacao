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
public class TestaCasa {
    public static void main(String[] args) {
        Casa casa1 = new Casa();
        
        casa1.pinta("Amarela");
        casa1.porta1.abre();
        casa1.porta3.abre();
        
        System.out.println("Casa " + casa1.getCor() + ":");
        int qtdPortas = casa1.quantasPortasEstaoAbertas();
        System.out.println("Portas Abertas: " + qtdPortas);
    }
}
