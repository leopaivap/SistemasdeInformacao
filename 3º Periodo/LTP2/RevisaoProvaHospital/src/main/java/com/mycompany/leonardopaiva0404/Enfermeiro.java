package com.mycompany.leonardopaiva0404;


public class Enfermeiro {
    private String nome, cpf;
    private int codEnfermeiro;
    private static int qtdEnfermeiros;
    
    Enfermeiro(){
        Enfermeiro.qtdEnfermeiros = Enfermeiro.qtdEnfermeiros + 1;
        this.codEnfermeiro = qtdEnfermeiros;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getCodEnfermeiro() {
        return codEnfermeiro;
    }

    public static int getQtdEnfermeiros() {
        return qtdEnfermeiros;
    }

}
