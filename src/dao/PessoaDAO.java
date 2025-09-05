

package dao;
 
import beans.Pessoa;

import conexao.Conexao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
 
/**

*

* @author Artur

*/

public class PessoaDAO {

    private Conexao conexao;

    private Connection conn;

public PessoaDAO(){

    this.conexao = new Conexao();

    this.conn = this.conexao.getConexao();

}
 
public void inserir (Pessoa pessoa){

    String sql = "INSERT INTO pessoa (nome, sexo, idioma) VALUES (?,?,?)";

    try{

        PreparedStatement stat = this.conn.prepareStatement(sql);

        stat.setString(1, pessoa.getNome());

        stat.setString(2, pessoa.getSexo());

        stat.setString(3, pessoa.getIdioma());

        stat.execute();

        System.out.println("Inserção feita com sucesso");

    }

    catch (SQLException ex){

        System.out.println("Erro ao inserir pessoa: " + ex.getMessage());

    }

}

public Pessoa getPessoa(int id) 
    {
        String sql = "SELECT * FROM pessoa WHERE id = ?";
        try 
        {
            PreparedStatement stmt = conn.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE
            );
            // 1º parâmetro é o SQL
            // 2º parâmetro é o tipo do ResultSet -
            // ResultSet scroll, ou seja, o cursor se move para frente ou para trás.
            // Este tipo de ResultSet é sensível às alterações feitas no banco de dados, ou seja, as modificações feitas no banco de dados são refletidas no ResultSet.
            // 3º parâmetro é sobre os parâmetros de concorrência – pode ser "read only" ou atualizável
 
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery(); // obtenho o retorno da consulta e armazeno no ResultSet
            Pessoa p = new Pessoa();
            // Primeiramente, vamos posicionar o retorno da consulta (ResultSet) na primeira posição da consulta
            // Em alguns casos, a consulta terá mais de um resultado de retorno
            rs.first();
            p.setId(id);
            p.setNome(rs.getString("nome"));
            p.setSexo(rs.getString("sexo"));
            p.setIdioma(rs.getString("idioma"));
            return p;
        } 
        catch (SQLException ex) 
        {
            System.out.println("Erro ao consultar pessoa: " + ex.getMessage());
            return null;
        }
    }

}

 