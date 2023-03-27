/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRASPORTO;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 02210412650
 */
public class Cliente {
    private String nome, cpf, rg;
    Caminhoneiro c1;
    Viagem viagem1;
    Carreta carreta1;

    Cliente(String nome, Caminhoneiro c1, Viagem viagem1, Carreta carreta1){
        this.nome = nome;
        this.c1 = c1;
        this.viagem1 = viagem1;
        this.carreta1 = carreta1;
    }
    
    public void visualizarViagem(){
        System.out.println("Cliente: " + this.getNome());
        System.out.println("Caminhoneiro: " + this.c1.getNome());
        System.out.println("Veiculo: " + this.carreta1.getModeloCarreta());
        System.out.println("Destino: " + this.viagem1.getDestino());
        System.out.println("Valor KM/Distancia: " + this.viagem1.getValorKM() + " | " + this.viagem1.getDistancia());
        System.out.println("Valor Total da Viagem: R$" + this.viagem1.getValorViagem());
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
    
}
