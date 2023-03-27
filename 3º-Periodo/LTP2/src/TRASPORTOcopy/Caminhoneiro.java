/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TRASPORTOcopy;

import TRASPORTO.*;

/**
 *
 * @author 02210412650
 */
public class Caminhoneiro {
    private String nome, cpnj, cpf;
    private double salario;

    
    Caminhoneiro(String nome, String cnpj, String cpf, double salario){
        this.nome = nome;
        this.cpf = cpf;
        this.cpnj = cnpj;
        this.salario = salario;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpnj() {
        return cpnj;
    }

    public void setCpnj(String cpnj) {
        this.cpnj = cpnj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    
}
