package prova;

public class Teste {
    public static void main(String[] args) {
        Data data1 = new Data("10", "02", "2026"); 
        Data data2 = new Data("12", "10", "2031"); 
        
        Geladeira geladeira1 = new Geladeira("Eletrolux", "Modelo 01", "Aço Inox", 70, data1);
        
        Movel telefoneMovel = new Movel("Apple", "iPhone X", "Preto", 0.175, data1);
        Fixo telefoneFixo = new Fixo("Anatel", "Telefone 01", "Cinza", 0.350, data2);
        
        Portatil computadorPortatil = new Portatil("Acer", "Aspire 3", "Preto", 2.8, data2);
        Mesa computadorMesa = new Mesa("Positivo", "Positivo 01", "Preto", 6.2, data1);
        
        geladeira1.dadosAparelho();
        
        telefoneFixo.dadosAparelho();
        telefoneFixo.ligar();
        
        telefoneMovel.dadosAparelho();
        telefoneMovel.autenticaRede();
        
        computadorPortatil.desligar();
        computadorPortatil.dadosAparelho();
        
        computadorMesa.dadosAparelho();
        computadorMesa.autenticaRede();
        
        
        
    }
}
