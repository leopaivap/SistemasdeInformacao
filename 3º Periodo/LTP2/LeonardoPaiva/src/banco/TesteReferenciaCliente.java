/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 *
 * @author tulio
 */
public class TesteReferenciaCliente {
    public static void main(String[] args) {
        Conta c1 = new ContaCorrente();
                 
        c1.objCliente1.setNome("Paola Dias");
        System.out.println("Nome: "+c1.objCliente1.getNome());
   
        try{
            c1.deposita(50000);
    }   catch(ValorInvalidoException e){
            System.out.println(e.getMessage());
    }
        }
    
}
