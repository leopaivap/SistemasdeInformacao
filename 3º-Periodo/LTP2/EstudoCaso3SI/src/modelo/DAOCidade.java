package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOCidade { // Data Access Object 

    public List<Cidade> getLista() {
        String sql = "select * from cidade";
        List<Cidade> listaCidade = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Cidade objCidade = new Cidade();
                objCidade.setCodigoCidade(rs.getInt("codigo"));
                objCidade.setNomeCidade(rs.getString("nome"));
                objCidade.setUfCidade(rs.getString("uf"));
                listaCidade.add(objCidade);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista() do DAOCidade: " + ex.getMessage());
        }
        return listaCidade;
    }

    public boolean incluir(Cidade obj) {
        String sql = "insert into cidade (nome,uf) values(?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNomeCidade());
            pst.setString(2, obj.getUfCidade());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cidade incluida");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cidade não incluida");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no incluir do DAOCidade " + e.getMessage());
        }
        return false;
    }

    public boolean alterar(Cidade obj) {
        String sql = "update cidade set nome = ?, uf = ? where codigo = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNomeCidade());
            pst.setString(2, obj.getUfCidade());
            pst.setInt(3, obj.getCodigoCidade());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cidade alterada");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Cidade não alterada");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no alterar do DAOCidade " + e.getMessage());
        }
        return false;
    }

    public boolean remover(Cidade obj) {
        String sql = "delete from cidade where codigo = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigoCidade());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Cidade removida");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Cidade não removida");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no remover do DAOCidade " + e.getMessage());
        }
        return false;
    }

    public boolean salvar(Cidade obj) {
        if (obj.getCodigoCidade() == null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }
    }

    public Cidade localizar(Integer id) {
        String sql = "select * from cidade where codigo = ?";
        Cidade obj = new Cidade();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                obj.setCodigoCidade(rs.getInt("codigo"));
                obj.setNomeCidade(rs.getString("nome"));
                obj.setUfCidade(rs.getString("uf"));
                return obj;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL Localizar" + e.getMessage());
        }
        return null;
    }
}
