package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mhebe
 */
public class Conexao {

    public Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bdaula1?useTimezone=true&serverTimezone=UTC",
                    "root", ""
            );
            System.out.println("Conexão realizada com sucesso");
            return conn;
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao BD " + e.getMessage());
            return null;
        }
    }
}
