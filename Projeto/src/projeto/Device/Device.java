package projeto.Device;

import projeto.Outros.Data;

/*
 * @author Gio
 */

public abstract class Device {
    protected String nome;
    protected boolean ligado;
    protected Data lancamento;
    protected String modelo;
    protected double preco;
    
    // construtor vazio
    public Device(){ 

        this.nome = "<nome>";
        this.ligado = false;
        this.lancamento = new Data( 1, 1, 2014 );
        this.modelo = "MDL-000";
        this.preco = 0;
    }
    
    // construtor
    public Device( String nome, String ligado, Data lancamento, String modelo
                    , double preco ){
        this.setNome( nome );
        this.setLigado( ligado );
        this.lancamento = lancamento;
        this.setModelo( modelo );
        this.setPreco( preco );
    }
    
    // construtor de cópia
    public Device( Device outro ){
        this.nome = outro.nome;
        this.ligado = outro.ligado;
        this.lancamento = outro.lancamento;
        this.modelo = outro.modelo;
        this.preco = outro.preco;
    }
    
    // gets
    public String getNome(){
        return this.nome;
    }
    
    public boolean getLigado(){
        return this.ligado;
    }
    
    public Data getLancamento(){
        return this.lancamento;
    }
    
    public String getModelo(){
        return this.modelo;
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
    
    public final void setLigado( String ligado ){
        if ( !"l".equals(ligado) && !"d".equals(ligado) ){
            System.out.println("\nErro. Deve-se usar apenas 'l' ou 'd'.");
            System.out.println("Inserindo valor default...");
            this.ligado = false;
        }
        else this.ligado = "l".equals(ligado);
    }
    
    public final void setModelo( String modelo ){
        if ( "\0".equals(modelo) ){
            System.out.println("\nErro. Versão do modelo deve ser maior ou "
                    + "igual a 1000 e menor ou igual a 9999.");
            System.out.println("Inserindo valor default...");
            this.modelo = "MDL-000";
        }
        else this.modelo = modelo; 
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
        if ( this.ligado ) resultado.append("Está ligado.\n");
        else resultado.append("Está desligado.\n");
        resultado.append("Data de lançamento: " + this.lancamento + ".\n" );
        resultado.append("Modelo: " + this.modelo + ".\n");
        
        String s = String.format("%.2f", this.preco);
        
       resultado.append("Preço: R$" + s + ".\n");
       
        return resultado.toString();
    }
}