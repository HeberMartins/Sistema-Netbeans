package beans;

/**
 *
 * @author mhebe
 */
public class Pessoa {

    private int id;
    private String nome;
    private String sexo;
    private String idioma;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSexo() {
        return sexo;
    }

    public String getIdioma() {
        return idioma;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public void setNome(String n){
        this.nome = n;
    }
    
    public void setSexo(String s){
        this.sexo = s;
    }
    
    public void setIdioma(String i){
        this.idioma = i;
    }
}
