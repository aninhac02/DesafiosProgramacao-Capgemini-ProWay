
/*
esse arquivo é o que faz a conexão com o banco
cada método contém a query referente a ação que ele faz (listar, inserir, atualizar e excluir)

*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class anuncioDAO {
    
     private Connection connection;
    
    public anuncioDAO() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String DATABASE_URL = "jdbc:derby://localhost:1527/registerSys";
            String usuario = "root";
            String senha = "12345";
            this.connection = DriverManager.getConnection(DATABASE_URL, usuario, senha);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(anuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<anuncio> toList() {
        String sql = "SELECT * FROM anuncios";
        List<anuncio> retorno = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet result = stmt.executeQuery();
            while (result.next()) {
                anuncio anuncio = new anuncio();
                
                anuncio.setName(result.getString("name"));
                anuncio.setClient(result.getString("cliente"));
                anuncio.setStartDate(result.getString("startDate"));
                anuncio.setEndDate(result.getString("endDate"));
                anuncio.setInvestmentPerDay(result.getDouble("investmentPerDay"));
                retorno.add(anuncio);
            }
        } catch (SQLException ex) {
            Logger.getLogger(anuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

    public boolean insert(anuncio anuncio) {
        String sql = "INSERT INTO anuncios(name_, client, start_date, end_date, investiment_per_day) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, anuncio.getName());
            stmt.setString(2, anuncio.getClient());
            stmt.setString(3, anuncio.getStartDate());
            stmt.setString(4, anuncio.getEndDate());
            stmt.setDouble(5, anuncio.getInvestmentPerDay());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(anuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean update(anuncio anuncio) {
        String sql = "UPDATE clientes SET name_=?, client=?, start_date=?, end_date=?, investiment_per_day=? WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, anuncio.getName());
            stmt.setString(2, anuncio.getClient());
            stmt.setString(3, anuncio.getStartDate());
            stmt.setString(4, anuncio.getEndDate());
            stmt.setDouble(5, anuncio.getInvestmentPerDay());
            stmt.setInt(6, anuncio.getId());
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(anuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean delete(Integer id) {
        String sql = "DELETE FROM anuncios WHERE id=?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(anuncioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
}
