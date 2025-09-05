package prjlabbd;

import beans.Pessoa;
import conexao.Conexao;
import dao.PessoaDAO;

/**
 *
 * @author mhebe
 */
public class PrjLabBd {

    public static void main(String[] args) {
        Conexao c = new Conexao();
        c.getConexao();
        
        Pessoa p = new Pessoa();
        p.setNome("Ricardo");
        p.setSexo("M");
        p.setIdioma("PORTUGUÊS");
        
        PessoaDAO pDAO = new PessoaDAO();
        pDAO.inserir(p);
    }

}
