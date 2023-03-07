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
public class TestaPessoa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.setNome("Leo");
        p1.setIdade(20);
        
        p1.fazAniversario();
        p1.fazAniversario();
        p1.fazAniversario();
    }
}
