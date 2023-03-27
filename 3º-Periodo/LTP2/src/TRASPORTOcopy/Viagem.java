/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRASPORTOcopy;



/**
 *
 * @author 02210412650
 */
public class Viagem {
    private String destino;
    private double valorKM, valorViagem, distancia;

    Viagem(String destino, double valorKM, double distancia){
        this.destino = destino;
        this.valorKM = valorKM;
        this.distancia = distancia;
        calcularViagem();
    }
    
    public void calcularViagem(){
        this.valorViagem = this.valorKM * this.distancia;
    }
    
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getValorKM() {
        return valorKM;
    }

    public void setValorKM(double valorKM) {
        this.valorKM = valorKM;
    }

    public double getValorViagem() {
        return valorViagem;
    }

    public void setValorViagem(double valorViagem) {
        this.valorViagem = valorViagem;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
    
    
}
