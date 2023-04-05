
package com.mycompany.leonardopaiva0404;

public class Medico {
    private String nome, cpf, especializacao;
    private int codMedico;
    private static int qtdMedicos;

    Medico(){
        Medico.qtdMedicos = Medico.qtdMedicos + 1;
        this.codMedico = qtdMedicos;
    }
    
    Medico(String nome, String cpf, String especializacao){
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.especializacao = especializacao;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public int getCodMedico() {
        return codMedico;
    }

    public static int getQtdMedicos() {
        return qtdMedicos;
    }

}
