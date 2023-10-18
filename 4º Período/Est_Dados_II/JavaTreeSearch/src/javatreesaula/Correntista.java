package javatreesaula;

public class Correntista implements Comparable<Correntista> {

    private int contaBancaria;
    private String nome;

    public Correntista(int contaBancaria, String nome) {
        this.contaBancaria = contaBancaria;
        this.nome = nome;
    }

    public Correntista() {

    }

    public int getContaBancaria() {
        return contaBancaria;
    }

    public void setContaBancaria(int contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int compareTo(Correntista outro) {
        return Integer.compare(this.contaBancaria, outro.contaBancaria);
    }

    @Override
    public String toString() {
        return " Conta Bancaria: " + this.contaBancaria
                + " - Nome: " + this.nome;
    }

}
