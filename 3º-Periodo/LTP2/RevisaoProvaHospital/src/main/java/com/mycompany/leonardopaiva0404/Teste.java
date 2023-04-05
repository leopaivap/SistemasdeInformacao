package com.mycompany.leonardopaiva0404;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Teste {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Internacao> listaInternacao = new ArrayList<>();
        
        Paciente p1 = new Paciente();
        System.out.println("*** Cadastro Paciente *** ");
        System.out.println("Informe o nome do paciente: ");
        p1.setNome(scan.nextLine());
        System.out.println("CPF: ");
        p1.setCpf(scan.nextLine());
        System.out.println("Enfermidade:");
        p1.setEnfermidade(scan.nextLine());
        
        Paciente p2 = new Paciente();
        p2.setNome("Jorge");
        p2.setCpf("250.250.250-52");
        p2.setEnfermidade("Dor de cabeça");
        
        Medico med1 = new Medico();
        System.out.println("\n*** Cadastro Medico ***");
        System.out.println("Informe o nome do médico: ");
        med1.setNome(scan.nextLine());
        System.out.println("CPF: ");
        med1.setCpf(scan.nextLine());
        System.out.println("Especialização:");
        med1.setEspecializacao(scan.nextLine());
        
        Medico med2 = new Medico("Carlos", "123.132.132-50", "Cardiologista");
        
        Enfermeiro enf1 = new Enfermeiro();
         System.out.println("\n*** Cadastro Enfermeiro *** ");
        System.out.println("Informe o nome do enfermeiro: ");
        enf1.setNome(scan.nextLine());
        System.out.println("CPF: ");
        enf1.setCpf(scan.nextLine());
        
        Enfermeiro enf2 = new Enfermeiro();
        enf2.setNome("Mateus");
        enf2.setCpf("152.512.154-53");
        
        
        Internacao internacao1 = new Internacao(p1, enf1, med1, 250, 3);
        Internacao internacao2 = new Internacao(p1, enf2, med1, 350, 4);
        Internacao internacao3 = new Internacao(p1, enf1, med2, 500, 1);
        Internacao internacao4 = new Internacao(p2, enf2, med2, 120, 2);
        
        listaInternacao.add(internacao1);
        listaInternacao.add(internacao2);
        listaInternacao.add(internacao3);
        listaInternacao.add(internacao4);
        
        internacao1.mostraInternacoesPaciente(listaInternacao, p1);
        
    }
}
