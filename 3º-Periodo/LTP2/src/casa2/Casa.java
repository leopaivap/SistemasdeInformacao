/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tulio
 */
public class Casa {

    private String cor;
    List<Porta> listaPorta = new ArrayList<>();

    public void pinta(String cor) {
        this.cor = cor;
    }

    public int quantasPortasEstaoAbertas() {
        int nPorta = 0;
        for (Porta porta : listaPorta) {
            if (porta.estaAberta() == true) {
                nPorta++;
            }
        }
        return nPorta;
    }
    
      public void relPortas() {
        
        for (Porta porta : listaPorta) {
            System.out.println("Porta["+porta.getIdPorta()+"]="+((porta.estaAberta()==true)?"aberta":"fechada")+" Cor="+porta.getCor()+" x= "+porta.getDimensaoX()+" y= "+porta.getDimensaoY()+" z= "+porta.getDimensaoZ());
        }
        System.out.println("Portas abertas:"+quantasPortasEstaoAbertas());
 
       
    }

}
