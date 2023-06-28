package prova;

public class Data {
    private String dia, mes, ano;
    
    Data(String dia, String mes, String ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    @Override
    public String toString(){
        String dataCompleta = this.dia + "/" + this.mes + "/" + this.ano;
        return dataCompleta;
    }
    
}
