
package br.edu.ifpb.pessoa.core.persistencia;

import br.edu.ifpb.pessoa.core.entidades.Pessoa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Aluísio
 */


public class Pessoas implements IFPessoa{
  
    private Connection conn;
    private PreparedStatement std;

    /**
     *
     * @param pessoa
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    @Override
    public  boolean salvar(Pessoa pessoa)  {
        boolean result = false;
        String sql = "INSERT INTO pessoa(nome)VALUES(?)";
        try {
           
            conectar();
            std = conn.prepareStatement(sql);
            std.setString(1, pessoa.getNome());
            if (std.executeUpdate() > 0) {
                result = true;
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                std.close();
            } catch (SQLException ex) {
                Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
            }
        } if(result)
        return true;
        return false;
    }
/**
 * metodo para listar todas as pesssoas
 * @return 
 */
    @Override
    public List<Pessoa> listarTodos() {
        String sql = "SELECT * from pessoa";
        try {
            return bucarNoBD(sql);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
        } 
       return Collections.EMPTY_LIST;
    }

    private void conectar() throws ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/dac";
        String user = "postgres";
        String passuord = "123456";
        Class.forName("org.postgresql.Driver");
        try {
            this.conn = DriverManager.getConnection(url, user, passuord);
        } catch (SQLException ex) {
            Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
/**
 * metodo para relaizar busca no banco de dados
 * @param sql
 * @return
 * @throws SQLException
 * @throws ClassNotFoundException 
 */
    private List<Pessoa> bucarNoBD(String sql) throws SQLException, ClassNotFoundException {

        try {
            conectar();
            std = conn.prepareStatement(sql);
            ResultSet rs = std.executeQuery();
            List<Pessoa> pessoas = new ArrayList<>();
            //   if(usuarios.isEmpty())
            // return null
            while (rs.next()) {
                pessoas.add(montarPessoa(rs));
            }
            if(pessoas.isEmpty())
            return Collections.EMPTY_LIST;
            return pessoas;

        } finally {
            try {
                conn.close();
                std.close();
            } catch (SQLException ex) {
                Logger.getLogger(Pessoas.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
/**
 * metodo usado para mantar uma pessoa no formato a ser impresso
 * @param rs
 * @return
 * @throws SQLException 
 */
    private Pessoa montarPessoa(ResultSet rs) throws SQLException {
        Pessoa p = new Pessoa();
        p.setId(rs.getInt("id"));
        p.setNome(rs.getString("nome"));

      return p;
    }


}
