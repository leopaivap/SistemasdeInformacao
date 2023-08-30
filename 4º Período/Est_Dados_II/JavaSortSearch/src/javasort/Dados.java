package javasort;
//import java.lang.Comparable;

public class Dados implements Comparable<Dados> {

    private String data;
    private String cidade;
    private String condicao;
    private String temperaturaTendencia;
    private int temperaturaMinima;
    private int temperaturaMaxima;
    private int ventoVelocidadeMinima;
    private int ventoVelocidadeMaxima;
    private String ventoDirecao;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public String getTemperaturaTendencia() {
        return temperaturaTendencia;
    }

    public void setTemperaturaTendencia(String temperaturaTendencia) {
        this.temperaturaTendencia = temperaturaTendencia;
    }

    public int getTemperaturaMinima() {
        return temperaturaMinima;
    }

    public void setTemperaturaMinima(int temperaturaMinima) {
        this.temperaturaMinima = temperaturaMinima;
    }

    public int getTemperaturaMaxima() {
        return temperaturaMaxima;
    }

    public void setTemperaturaMaxima(int temperaturaMaxima) {
        this.temperaturaMaxima = temperaturaMaxima;
    }

    public int getVentoVelocidadeMinima() {
        return ventoVelocidadeMinima;
    }

    public void setVentoVelocidadeMinima(int ventoVelocidadeMinima) {
        this.ventoVelocidadeMinima = ventoVelocidadeMinima;
    }

    public int getVentoVelocidadeMaxima() {
        return ventoVelocidadeMaxima;
    }

    public void setVentoVelocidadeMaxima(int ventoVelocidadeMaxima) {
        this.ventoVelocidadeMaxima = ventoVelocidadeMaxima;
    }

    public String getVentoDirecao() {
        return ventoDirecao;
    }

    public void setVentoDirecao(String ventoDirecao) {
        this.ventoDirecao = ventoDirecao;
    }

    @Override
    public int compareTo(Dados outroDado) {
        return this.getCidade().
                compareTo(outroDado.getCidade());
    }

    @Override
    public String toString() {
        return getCidade() + " : " + getCondicao();
    }// fim toString

    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        
        if (o == null || getClass() != o.getClass()) 
            return false;
        
        Dados dados = (Dados) o;
        return cidade.equals(dados.cidade);
    }

}
