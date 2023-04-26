package modelo;

import java.util.List;

public class DAOCidade { // Data Access Object
    
    public List<Cidade> getLista(){
        return Dados.listaCidade;
    }
    
    public boolean salvar(Cidade obj){
        if(obj.getCodigoCidade() == null){
            Integer codigo = Dados.listaCidade.size() + 1;
            obj.setCodigoCidade(codigo);
            Dados.listaCidade.add(obj);
        }
        return true;
    }
    
    public boolean remover(Cidade obj){
        Dados.listaCidade.remove(obj);
        return true;
    }
    
}
