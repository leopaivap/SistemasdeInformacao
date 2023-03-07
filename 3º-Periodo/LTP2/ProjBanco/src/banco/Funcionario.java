/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Scanner;

/**
 *
 * @author 02210412650
 */
public class Funcionario {
    private double salario;
    private String nome, departamento, dataAdmissao, rg;
    private boolean ativo = true;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    void bonifica(double aumento){
        setSalario(getSalario() + aumento);
    }
    
    void demite(){
        setAtivo(false);
    }
    
    void trocaDepartamento(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o novo departamento: ");
        String novoDep = scan.next();
        setDepartamento(novoDep);
        System.out.println("O novo departamento do funcionario " + getNome() + ": " + getDepartamento());
    }
    
    void mostra(){
        System.out.println("\n *** Dados Funcionario ***");
        System.out.println("Nome: " + getNome());
        System.out.println("Rg: " + getRg());
        System.out.println("Data Admissao: " + getDataAdmissao());
        System.out.println("Salario: R$" + getSalario());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("Status: " + isAtivo());
    }
}
