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
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author tulio
 */
public class DAOFuncionario {

    DAOCidade daoCidade = new DAOCidade();

    public List<Funcionario> getLita() {
        String sql = "select * from funcionario";
        List<Funcionario> lista = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Funcionario obj = new Funcionario();
                obj.setCodigo(rs.getInt("codigo"));
                obj.setNome(rs.getString("nome"));
                obj.setSalario(rs.getDouble("salario"));
                java.sql.Date dt = rs.getDate("nascimento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                obj.setNascimento(c);
                obj.setCidade(daoCidade.localizar(rs.getInt("cidade")));
                lista.add(obj);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista()" + e.getMessage());
        }
        return lista;
    }

    public boolean salvar(Funcionario obj) {
        if (obj.getCodigo() == null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }

    }

    public boolean incluir(Funcionario obj) {
        String sql = "insert into funcionario (nome,salario,nascimento,cidade) values(?,?,?,?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getSalario());
            pst.setDate(3, new java.sql.Date(obj.getNascimento().getTimeInMillis()));
            pst.setInt(4, obj.getCidade().getCodigo());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não cadastrado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no incluir do DAOFuncionario" + e.getMessage());

        }
        return false;
    }

    public boolean alterar(Funcionario obj) {
        String sql = "update funcionario set nome=?, salario=?, nascimento=?, cidade=? where codigo=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNome());
            pst.setDouble(2, obj.getSalario());
            pst.setDate(3, new java.sql.Date(obj.getNascimento().getTimeInMillis()));
            pst.setInt(4, obj.getCidade().getCodigo());
            pst.setInt(5, obj.getCodigo());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionário alterado");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no alterar do DAOFuncionario" + e.getMessage());

        }
        return false;
    }

    public boolean remover(Funcionario obj) {
        String sql = "delete from funcionario where codigo=?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigo());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionário excluído");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não excluído");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no excluir do DAOFuncionario" + e.getMessage());

        }
        return false;
    }

    

}
