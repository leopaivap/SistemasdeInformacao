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
public class DAOCidade {

    public List<Cidade> getLita() {
        String sql = "select * from cidade";
        List<Cidade> lista = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cidade obj = new Cidade();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setUf(rs.getString("uf"));
                lista.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista()" + e.getMessage());
        }
        return lista;
    }

    public boolean salvar(Cidade obj) {
        if (obj.getCodigo() == null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }

    }

    public boolean incluir(Cidade obj) {
        String sql = "insert into cidade (nome,uf) values(?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getUf());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cidade incluida");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cidade não incluida");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no incluir do DAOCidade" + e.getMessage());

        }
        return false;
    }

    public boolean alterar(Cidade obj) {
        String sql = "update cidade set nome=?, uf=? where codigo=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setString(2, obj.getUf());
            pst.setInt(3, obj.getCodigo());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cidade alterada");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cidade não alterada");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no alterar do DAOCidade" + e.getMessage());

        }
        return false;
    }
    public boolean remover(Cidade obj) {
        String sql = "delete from cidade where codigo=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigo());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cidade excluída");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cidade não excluída");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no excluir do DAOCidade" + e.getMessage());

        }
        return false;
    }
    
    public Cidade localizar(Integer id){
        String sql = "select * from cidade where codigo=?";
        Cidade obj = new Cidade();
        try{
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setUf(rs.getString("uf"));
                return obj;
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog
        (null,"Erro de SQL Localizar"+e.getMessage());
    }
        return null;
    }
   

}
