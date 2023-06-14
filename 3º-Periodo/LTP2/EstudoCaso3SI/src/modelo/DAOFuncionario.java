package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOFuncionario {

    DAOCidade objDAOCidade = new DAOCidade();

    public List<Funcionario> getLista() {
        String sql = "select * from funcionario";
        List<Funcionario> listaFuncionario = new ArrayList<>();
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Funcionario objFuncionario = new Funcionario();
                objFuncionario.setCodigoFuncionario(rs.getInt("codigo"));
                objFuncionario.setSalarioFuncionario(rs.getDouble("salario"));
                objFuncionario.setNomeFuncionario(rs.getString("nome"));

                //passar data para o banco
                java.sql.Date dt = rs.getDate("nascimento");
                Calendar c = Calendar.getInstance();
                c.setTime(dt);
                objFuncionario.setNascimentoFuncionario(c);

                //mostrar foreign key
                objFuncionario.setObjCidade(objDAOCidade.localizar(rs.getInt("cidade")));

                listaFuncionario.add(objFuncionario);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no getLista() do DAOFuncionario: " + ex.getMessage());
        }
        return listaFuncionario;
    }

    public boolean incluir(Funcionario obj) {
        String sql = "insert into funcionario (nome, salario, nascimento, cidade) values(?, ?, ?, ?)";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNomeFuncionario());
            pst.setDouble(2, obj.getSalarioFuncionario());
            pst.setDate(3, new java.sql.Date(obj.getNascimentoFuncionario().getTimeInMillis()));
            pst.setInt(4, obj.getObjCidade().getCodigoCidade());

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario incluido");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Funcionario não incluido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no incluir do DAOFuncionario " + e.getMessage());
        }
        return false;
    }

    public boolean alterar(Funcionario obj) {
        String sql = "update funcionario set nome = ?, salario = ?, nascimento = ?, cidade = ? where codigo = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setString(1, obj.getNomeFuncionario());
            pst.setDouble(2, obj.getSalarioFuncionario());
            pst.setDate(3, new java.sql.Date(obj.getNascimentoFuncionario().getTimeInMillis()));
            pst.setInt(4, obj.getObjCidade().getCodigoCidade());
            pst.setInt(5, obj.getCodigoFuncionario());

            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario alterado");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Funcionario não alterado");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no alterar do DAOFuncionario " + e.getMessage());
        }
        return false;
    }

    public boolean remover(Funcionario obj) {
        String sql = "delete from funcionario where codigo = ?";
        try {
            PreparedStatement pst = Conexao.getPreparedStatement(sql);
            pst.setInt(1, obj.getCodigoFuncionario());
            if (pst.executeUpdate() > 0) {
                JOptionPane.showMessageDialog(null, "Funcionario removido");
                return true;
            } else {

                JOptionPane.showMessageDialog(null, "Funcionario não removido");
                return false;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro de SQL no remover do DAOFuncionario " + e.getMessage());
        }
        return false;
    }

    public boolean salvar(Funcionario obj) {
        if (obj.getCodigoFuncionario() == null) {
            return incluir(obj);
        } else {
            return alterar(obj);
        }

    }
}
