package prova;


abstract public class Aparelho {
    private String marca, modelo, cor;
    private double peso;
    private Data dataGarantia;
    
    public Aparelho(String marca, String modelo, String cor, double peso, Data dataGarantia){
        this.cor = cor;
        this.dataGarantia = dataGarantia;
        this.marca = marca;
        this.peso = peso;
        this.modelo = modelo; 
    }
    
    abstract public void ligar();
    abstract public void desligar();
    abstract public void dadosAparelho();

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Data getDataGarantia() {
        return dataGarantia;
    }

    public void setDataGarantia(Data dataGarantia) {
        this.dataGarantia = dataGarantia;
    }
  
}
