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
public class Casa {
       private String cor;
       
       Porta porta1 = new Porta();
       Porta porta2 = new Porta();
       Porta porta3 = new Porta();
       

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
      
    void pinta(String s){
        setCor(s);
    }
    
    int quantasPortasEstaoAbertas(){
        int qtd = 0;
        if(porta1.isAberta())
            qtd++;
        if(porta2.isAberta())
            qtd++;
        if(porta3.isAberta())
            qtd++;
        
        return qtd;
    }
       
}
