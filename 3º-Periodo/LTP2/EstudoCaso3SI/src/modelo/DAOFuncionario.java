package modelo;

import java.util.List;

public class DAOFuncionario {
    
     public List<Funcionario> getLista(){
        return Dados.listaFuncionario;
    }
    
    public boolean salvar(Funcionario obj){
        if(obj.getCodigoFuncionario() == null){
            Integer codigo = Dados.listaFuncionario.size() + 1;
            obj.setCodigoFuncionario(codigo);
            Dados.listaFuncionario.add(obj);
        }
        return true;
    }
    
    public boolean remover(Funcionario obj){
        Dados.listaFuncionario.remove(obj);
        return true;
    }
}
