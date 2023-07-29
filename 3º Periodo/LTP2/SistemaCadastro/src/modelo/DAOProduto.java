/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 *
 * @author tulio
 */
public class DAOProduto { // data acess object
    
    
    
    public List<Produto> getListaProduto(){
        String sql = "select * from produto";
        List<Produto> lista = new ArrayList<>();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                Produto obj = new Produto();
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setValor(rs.getDouble("valor"));
                lista.add(obj);
            }
            rs.close();
            pst.close();
        }catch(SQLException e){
         JOptionPane.showMessageDialog(null, "Erro de SQL no getListaProduto" + e.getMessage());

        }
        return lista;
    }
    
     public Produto localizarProduto(Integer id) {
        String sql = "select * from produto where idProduto = ?";
        Produto obj = new Produto();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setIdProduto(rs.getInt("idProduto"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setValor(rs.getDouble("valor"));
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no localizarProduto" + e.getMessage());

        }
        return null;
    }
    
     
    
 

  
    
    
}
