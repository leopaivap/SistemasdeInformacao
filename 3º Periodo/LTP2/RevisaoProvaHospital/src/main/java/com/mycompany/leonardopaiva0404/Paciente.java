package com.mycompany.leonardopaiva0404;

public class Paciente {
    private String nome, cpf, enfermidade;
    private int codPaciente;
    private static int qtdPacientes;

    Paciente(){
        Paciente.qtdPacientes = Paciente.qtdPacientes + 1;
        this.codPaciente = qtdPacientes;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEnfermidade(String enfermidade) {
        this.enfermidade = enfermidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEnfermidade() {
        return enfermidade;
    }

    public int getCodaciente() {
        return codPaciente;
    }

    public static int getQtdPacientes() {
        return qtdPacientes;
    } 
}
