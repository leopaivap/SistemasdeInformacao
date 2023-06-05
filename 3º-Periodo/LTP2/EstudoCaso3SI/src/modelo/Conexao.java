package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Conexao {
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String banco = "jdbc:mysql://localhost:3306/estudocaso3si";
    private static final String usuario = "root";
    private static final String senha = "";
    
    
    private static Connection con = null;
    
    public Conexao() {
        
    }
    
    public static Connection getConexao(){
        if(con == null){
            try{
                Class.forName(driver);
                con = DriverManager.getConnection(banco, usuario, senha);
            }catch(ClassNotFoundException ex){
                System.out.println("Não encontrou o driver: " + ex.getMessage());
            }catch(SQLException ex){
                System.out.println("Erro de conexão: " + ex.getMessage());
            }
        }
        return null;
    }
    
    public static PreparedStatement getPreparedStatement(String sql) {
        if(con == null)
            con = getConexao();
            
        
        try{
            return con.prepareStatement(sql);
        }catch(SQLException ex){
            System.out.println("Erro de SQL: " + ex.getMessage());
        }
        return null;
    }
    
}
