/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casa;

import java.util.Scanner;

/**
 *
 * @author 02210412650
 */
public class Porta {
        private boolean aberta = false;
        private String cor;
        private double dimensaoX, dimensaoY, dimensaoZ;

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getDimensaoX() {
        return dimensaoX;
    }

    public void setDimensaoX(double dimensaoX) {
        this.dimensaoX = dimensaoX;
    }

    public double getDimensaoY() {
        return dimensaoY;
    }

    public void setDimensaoY(double dimensaoY) {
        this.dimensaoY = dimensaoY;
    }

    public double getDimensaoZ() {
        return dimensaoZ;
    }

    public void setDimensaoZ(double dimensaoZ) {
        this.dimensaoZ = dimensaoZ;
    }
        
    public void abre(){
        setAberta(true);
    }
    
    public void fecha(){
        setAberta(false);
    }
    
    void pinta(String s){
        setCor(s);
    }
    
    void estaAberta(){
        if(isAberta())
            System.out.println("Porta Aberta");
        else
            System.out.println("Porta Fechada");
    }
}
