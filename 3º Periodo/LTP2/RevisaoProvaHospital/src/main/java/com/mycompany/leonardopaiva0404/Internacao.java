package com.mycompany.leonardopaiva0404;

import java.util.ArrayList;

public class Internacao {
    private int codInternacao, qtdDiasInternado;
    private static int qtdInternacoes;
    private float valorDia, valorTotalInternacao;
    
    
    Paciente paciente;
    Enfermeiro enfermeiro;
    Medico medico;
    
    Internacao(Paciente paciente, Enfermeiro enfermeiro, Medico medico, float valorDia, int qtdDias){
        Internacao.qtdInternacoes = Internacao.qtdInternacoes + 1;
        this.codInternacao = qtdInternacoes;
        
        this.enfermeiro = enfermeiro;
        this.medico = medico;
        this.paciente = paciente;
        this.valorDia = valorDia;
        this.qtdDiasInternado = qtdDias;
        calculaValorTotalInternacao();
    }


    public float getValorTotalInternacao() {
        return valorTotalInternacao;
    }

    public void setValorTotalInternacao(float valorTotalInternacao) {
        this.valorTotalInternacao = valorTotalInternacao;
    }

    public int getQtdDiasInternado() {
        return qtdDiasInternado;
    }

    public void setQtdDiasInternado(int qtdDiasInternado) {
        this.qtdDiasInternado = qtdDiasInternado;
    }

    public float getValorDia() {
        return valorDia;
    }

    public void setValorDia(float valorDia) {
        this.valorDia = valorDia;
    }

    public int getCodInternacao() {
        return codInternacao;
    }

    public static int getQtdInternacoes() {
        return qtdInternacoes;
    }
    
    void calculaValorTotalInternacao(){
        this.valorTotalInternacao = this.qtdDiasInternado * this.valorDia;
    }
    
    
    public void mostraInternacoesPaciente(ArrayList<Internacao> listaInternacao, Paciente paciente){
        int i = 0;
        float valor = 0;
        for(Internacao internacao :listaInternacao){
            if(paciente.getNome().equals(internacao.paciente.getNome())){
                i = 1;
                System.out.println("Internação " + internacao.getCodInternacao());
                System.out.println("Paciente: " + internacao.paciente.getNome());
                System.out.println("Médico: " + internacao.medico.getNome());
                System.out.println("Enfermeiro: " + internacao.enfermeiro.getNome());
                System.out.println("Enfermidade: " + internacao.paciente.getEnfermidade());
                System.out.println("Dias Internados: " + internacao.getQtdDiasInternado());
                System.out.println("Valor Diário: R$" + internacao.getValorDia());
                System.out.println("Valor Internação: R$" + internacao.getValorTotalInternacao());
                System.out.println("-------------------------------");
                valor = valor + internacao.valorTotalInternacao;
            }
        }
        if(i != 0)
            System.out.println("\nValor Total: R$" + valor);
    }
    
}
