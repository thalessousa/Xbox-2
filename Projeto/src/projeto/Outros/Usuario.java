package projeto.Outros;

/**
 *
 * @author Gio
 */
public class Usuario {
    private String nome;
    private String username;
    
    // construtor vazio
    public Usuario(){
        this.nome = "<nome>";
        this.username = "username";
    }
    
    // construtor
    public Usuario( String nome, String username ){
        this.setNome( nome );
        this.setUsername( username );
    }
    
    // construtor de cópia
    public Usuario( Usuario outro ){
        this.nome = outro.nome;
        this.username = outro.username;
    }
    
    // gets
    public String getNome(){
        return this.nome;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    // sets
    public final void setNome( String nome ){
        if ( "\0".equals(nome) ){
            System.out.println("\nErro. Precisa ter pelo menos um caracter.");
            System.out.println("Inserindo valor default...");
            this.nome = "<nome>";
        }
        else this.nome = nome;
    }
    
    public final void setUsername( String username ){
        if ( "\0".equals(username) ){
            System.out.println("\nErro. Precisa ter pelo menos um caracter.");
            System.out.println("Inserindo valor default...");
            this.username = "username";
        }
        else this.username = username;
    }
    
    // outras funções
    @Override
    public String toString(){
        StringBuilder resultado = new StringBuilder();
        
        resultado.append("\nNome: " + this.nome + ".\n");
        resultado.append("Username: " + this.username + ".\n");
        
        return resultado.toString();
    }
}