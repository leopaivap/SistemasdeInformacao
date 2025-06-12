
package agjava2025;

public class Produto {
    private String descricao;
    private double peso;
    private double valor;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPeso() {
        return peso;
    }


    public void setPeso(double peso) {
        this.peso = peso;
    }


    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    @Override
    public String toString(){
        return "Produto{Descricao:"+
                this.descricao+
                " Peso:"+this.peso+
                " Valor: "+this.valor+" }";
    }
    
    
}
