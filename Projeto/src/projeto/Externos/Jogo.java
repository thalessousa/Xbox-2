package projeto.Externos;
import projeto.Outros.Data;
/*
 * @author Gio
 */
public class Jogo {
    private String nome; // nome do jogo (hurr)
    private Data lancamento; // lançamento do jogo (durr)
    private String distribuidora; // capcom, konami, gamefreak, etc
    private String plataforma; // xbox one, nintendo wiiu, playstation 4, etc 
    private double tamanho; // tamanho do jogo
    private double preco;
    
    // construtor vazio
    public Jogo(){
        this.nome = "<nome>";
        this.lancamento.setAno( 2014 );
        this.lancamento.setMes( 1 );
        this.lancamento.setDia( 1 );
        this.distribuidora = "<distribuidora>";
        this.plataforma = "<plataforma>";
        this.tamanho = 0.100; // 100mb
        this.preco = 0;
    }
    
    // construtor
    public Jogo( String nome, Data lancamento, String distribuidora,
            String plataforma, double tamanho, double preco ){
        this.setNome( nome );
        this.lancamento = lancamento;
        this.setDistribuidora( distribuidora );
        this.setPlataforma( plataforma );
        this.setTamanho( tamanho );
        this.setPreco( preco );
    }
    
    // construtor de cópia
    public Jogo( Jogo outro ){
        this.nome = outro.nome;
        this.lancamento = outro.lancamento;
        this.distribuidora = outro.distribuidora;
        this.plataforma = outro.plataforma;
        this.tamanho = outro.tamanho;
        this.preco = outro.preco;
    }
    
    // gets
    public String getNome(){
        return this.nome;
    }
    
    public Data getLancamento(){
        return this.lancamento;
    }
    
    public String getDistribuidora(){
        return this.distribuidora;
    }
    
    public String getPlataforma(){
        return this.plataforma;
    }
    
    public double getTamanho(){
        return this.tamanho;
    }
    
    public double getPreco(){
        return this.preco;
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
    
    public final void setDistribuidora( String distribuidora ){
        if ( "\0".equals(distribuidora) ){
            System.out.println("\nErro. Precisa ter pelo menos um caracter.");
            System.out.println("Inserindo valor default...");
            this.distribuidora = "<distribuidora>";
        }
        else this.distribuidora = distribuidora;
    }
    
    public final void setPlataforma( String plataforma ){
        if ( "\0".equals(plataforma) ){
            System.out.println("\nErro. Precisa ter pelo menos um caracter.");
            System.out.println("Inserindo valor default...");
            this.plataforma = "<plataforma>";
        }
        else this.plataforma = plataforma;
    }
    
    public final void setTamanho( double tamanho ){
        if ( tamanho < 0.100 ){
            System.out.println("\nErro. Tamanho do jogo deve ser pelo menos "
                    + "igual a 100MB.");
            System.out.println("Inserindo valor default...");
            this.tamanho = 0.100;
        }
        else this.tamanho = tamanho; 
    }
    
    public final void setPreco( double preco ){
        if ( preco < 0 ){
            System.out.println("\nErro. Preço do jogo deve ser pelo menos "
                    + "igual a 0 (free).");
            System.out.println("Inserindo valor default...");
            this.preco = 0;
        }
        else this.preco = preco; 
    }
    
    // outras funções
    @Override
    public String toString(){
        StringBuilder resultado = new StringBuilder();
        
        resultado.append("\nNome: " + this.nome + ".\n");
        resultado.append("Data de lançamento: " + this.lancamento + ".\n" );
        resultado.append("Distribuidora: " + this.distribuidora + ".\n");
        resultado.append("Plataforma: " + this.plataforma + ".\n");
        resultado.append("Tamanho: " + this.tamanho + "GB.\n");
        
        String s = String.format("%.2f", this.preco);
        
        resultado.append("Preço: R$" + s + ".\n");
        
        return resultado.toString();
    }
}
