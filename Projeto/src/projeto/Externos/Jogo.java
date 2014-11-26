package projeto.Externos;

import java.util.Objects;
import projeto.Outros.Data;
import projeto.Interfaces.Atualizavel;
import java.util.Scanner;
/*
 * @author Gio
 */
public class Jogo implements Atualizavel, Comparable<Jogo>{
    private String nome; // nome do jogo (hurr)
    private Data lancamento; // lançamento do jogo (durr)
    private String distribuidora; // capcom, konami, gamefreak, etc
    private String plataforma; // xbox one, nintendo wiiu, playstation 4, etc 
    private double tamanho; // tamanho do jogo
    private double preco;
    private double versao; // jogos também atualizam
    private double ULTIMA_VERSAO; // a ser definida
    
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
        this.versao = 1.0;
        this.ULTIMA_VERSAO = 1.0;
    }
    
    // construtor
    public Jogo( String nome, Data lancamento, String distribuidora,
            String plataforma, double tamanho, double preco, 
            double ultima_versao ){
        this.setNome( nome );
        this.lancamento = lancamento;
        this.setDistribuidora( distribuidora );
        this.setPlataforma( plataforma );
        this.setTamanho( tamanho );
        this.setPreco( preco );
        this.versao = 1.0;
        this.setUltimaVersao( ultima_versao );
    }
    
    // construtor de cópia
    public Jogo( Jogo outro ){
        this.nome = outro.nome;
        this.lancamento = outro.lancamento;
        this.distribuidora = outro.distribuidora;
        this.plataforma = outro.plataforma;
        this.tamanho = outro.tamanho;
        this.preco = outro.preco;
        this.versao = outro.versao;
        this.ULTIMA_VERSAO = outro.ULTIMA_VERSAO;
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
    
    public double getVersao(){
        return this.versao;
    }
    
    public double getUltimaVersao(){
        return this.ULTIMA_VERSAO;
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
    
    public void setVersao( double versao ){
        if ( versao < this.versao ){
            System.out.println("\nErro. Versão inserida mais antiga que "
                    + "a atual.");
            System.out.println("Mantendo a versão atual...");
        }
        else this.versao = versao;
    }
    
    public void setUltimaVersao( double ultima_versao ){
        if ( ultima_versao < 1.0 ){
            System.out.println("\nErro. Última versão deve ser pelo menos"
                    + " igual a 1.0.");
            System.out.println("Inserindo valor default...");
            this.ULTIMA_VERSAO = 1.0;
        }
        else this.ULTIMA_VERSAO = ultima_versao;
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
        resultado.append("Versão atual: " + this.versao + ".\n");
        return resultado.toString();
    }
    
    @Override
    public void atualizar(){
        if ( this.versao == this.ULTIMA_VERSAO ) System.out.println("O jogo já "
                + "está na versão mais recente!");
        else{
            Scanner scan = new Scanner(System.in);
            double op;
            System.out.println("\nVersão atual do seu jogo: " 
                    + this.versao);
            System.out.print("Atualizar para qual versão? [ Última versão: " 
            + this.ULTIMA_VERSAO + " ]\n\n > ");
            while(true){
                    if (scan.hasNextDouble())
                        op = scan.nextDouble();
                    else{
                        System.out.print("Erro. Insira um número.\n\n > ");
                        scan.next();
                        continue;
                    }
                    break;
            }
            if ( op > this.ULTIMA_VERSAO ){
                System.out.println("\nErro: deve ser menor ou igual a versão mais"
                        + " recente.");
            }
            else this.setVersao( op );
        } 
    }

    @Override
    public int compareTo( Jogo outro ){
        if ( this.tamanho > outro.tamanho ) return 1;
        else if ( this.tamanho == outro.tamanho ) return 0;
        else return -1;
    }
    
    @Override 
    public boolean equals( Object obj ){
        if ( obj instanceof Jogo ){
            Jogo c =( Jogo ) obj;
            return ( this.nome.equals( c.nome ) );
        }
        else return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.nome);
        hash = 13 * hash + Objects.hashCode(this.lancamento);
        hash = 13 * hash + Objects.hashCode(this.distribuidora);
        hash = 13 * hash + Objects.hashCode(this.plataforma);
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.tamanho) ^ 
                (Double.doubleToLongBits(this.tamanho) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.preco) ^ 
                (Double.doubleToLongBits(this.preco) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.versao) ^ 
                (Double.doubleToLongBits(this.versao) >>> 32));
        return hash;
    }
}
