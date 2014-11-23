package projeto.Device;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import projeto.Externos.Controle;
import projeto.Outros.Data;
import projeto.Externos.Jogo;
import projeto.Interfaces.Jogavel;
import projeto.Interfaces.Atualizavel;
/*
 * @author Gio
 */
public abstract class Console extends Device implements Jogavel, Atualizavel,
        Comparable<Console>{
    protected double [] memoria; // armazenamneto
    protected ArrayList<Jogo> jogos;  // jogos armazenados
    protected int num_jogos = 0; // número de jogos
    protected ArrayList<Controle> controles; // controles plugados
    protected int num_controles = 0; // número de controles
    protected static final int MAX_CONTROLES = 4; // controle de controles (HAH)
    protected double versao; // versão do console
    
    // construtor vazio
    public Console() {
        super();
        this.jogos = new ArrayList<>();
        this.controles = new ArrayList<>();
        this.memoria = new double [2];
        this.memoria[1] = 2.000; // max de armazenamento:  2GB
        this.memoria[0] = 0; // espaço ocupado: 0
        this.versao = 1.0;
    }
    
    // construtor
    public Console( String nome, String ligado, Data lancamento, String modelo,
            double memoria, double versao, double preco ){
        super( nome, ligado, lancamento, modelo, preco );
        this.jogos = new ArrayList<>();
        this.controles = new ArrayList<>(MAX_CONTROLES);
        this.memoria = new double [2];
        this.versao = 1.0;
        this.setMemoria( memoria );
        this.setVersao( versao );
    }
    
    // construtor de cópia
    public Console( Console outro ){
        super( outro );
        this.jogos = new ArrayList<>();
        this.controles = new ArrayList<>(MAX_CONTROLES);
        this.memoria = outro.memoria;
        this.jogos = outro.jogos;
        this.num_jogos = outro.num_jogos;
        this.controles = outro.controles;
        this.num_controles = outro.num_controles;
        this.versao = outro.versao;
    }
    
    // gets
    public double getMemoriaUsada(){
        return this.memoria[0];
    }
    
    public double getMemoriaMax(){
        return this.memoria[1];
    }
    
    public double getVersao(){
        return this.versao;
    }
    
    // sets
    public final void setMemoria( double memoria ){
        if ( memoria < 1.0 ){
            System.out.println("\nErro. Memória deve ser pelo menos igual a "
                    + "1GB");
            System.out.println("Inserindo valor default...");
            this.memoria[1] = 1.0;
        }
        else this.memoria[1] = memoria;
        
        this.memoria[0] = 0;
    }
    
    public final void setVersao( double versao ){
        if ( versao < this.versao ){ // verifica se a versão é mais antiga
            System.out.println("\nErro. Versão inserida mais antiga que "
                    + "a atual.");
            System.out.println("Mantendo a versão atual...");
        }
        else this.versao = versao;
    }
    
    // outras funções
    @Override
    public String toString(){
        StringBuilder resultado = new StringBuilder();
        
        resultado.append(super.toString());
        resultado.append("Versão: " + this.versao + ".\n");
        resultado.append("Memória: [ " + this.memoria[0] + " / "
                + this.memoria[1] + "GB ]\n");
        resultado.append("Quantidade de jogos: " + this.num_jogos + ".\n");
        resultado.append("Controles plugados: " + this.num_controles + ".\n");
        
        return resultado.toString();
    }
    
    public void showJogos(){
        if ( this.num_jogos == 0 ){
            System.out.println("\nSem jogos ainda.");
        }
        else{
            int i = 1;
            for ( Jogo x : jogos ){
                System.out.println( i + ")" + x );
                i++;
            }
        }
    }
    
    public void showControles(){
        if ( this.num_controles == 0 ){
            System.out.println("\nSem controles ainda.");
        }
        else{
            int i = 1;
            for ( Controle x : controles ) {
                System.out.println( i + ")" + x );
                i++;
            }
        }
    }
    
    public ArrayList<Jogo> removerJogo( ArrayList <Jogo> games ){
        if ( num_jogos == 0 ){
            System.out.println("\nNão existe nenhum jogo ainda.");
        }
        else{
            System.out.println("\nQual jogo você gostaria de remover? [ 1 - "
                    + this.num_jogos + " ]");
            int i = 1;
            for ( Jogo x : jogos ){
                System.out.println( i + ")" + x );
                i++;
            }
            System.out.print("\n > ");
            Scanner entrada = new Scanner(System.in);
            int op;
            while(true){
                if (entrada.hasNextInt())
                    op = entrada.nextInt();
                else{
                    System.out.print("Erro. Insira um número.\n\n > ");
                    entrada.next();
                    continue;
                }
                break;
             }
            op -= 1;
            if ( op < 0 || op > this.jogos.size() - 1  )
                System.out.println("\nNúmero inválido.");
            else{
                System.out.println( this.jogos.get( op ) );
                System.out.print("\nRemover este jogo? [ s / n ]\n\n > ");
                Scanner scan = new Scanner(System.in);
                String resposta = scan.nextLine();
                if ( !"s".equals(resposta) && !"n".equals(resposta) ){
                    System.out.println("\nResposta inválida.");
                }
                else if ( "s".equals(resposta) ){
                    games.add( this.jogos.get(op) );
                    this.num_jogos--;
                    this.jogos.remove(op);
                    System.out.println("\nJogo removido com sucesso.");
                }
                else System.out.println("\nOk. Saindo...");
                
            }
        }
        return games;
    }
    
    public void removerControle(){
        if ( this.num_controles == 0 ){
            System.out.println("\nNão existe nenhum controle ainda.");
        }
        else{
           System.out.println("\nQual dos consoles você gostaria de remover? "
                   + "[ 1 - " + this.num_controles + " ]");
           int i = 1;
           for ( Controle x : this.controles ){
               System.out.println( i + ")" + x);
               i++;
           }
           Scanner inteiro = new Scanner(System.in);
            int op;
            while(true){
                if (inteiro.hasNextInt())
                    op = inteiro.nextInt();
                else{
                    System.out.print("Erro. Insira um número.\n\n > ");
                    inteiro.next();
                    continue;
                }
                break;
             }
            op -= 1;
            if ( op < 0 || op > this.num_controles - 1 ){
                System.out.println("\nNúmero inválido.");
            }
            else{
                System.out.println( controles.get( op ) );
                System.out.print("\nRemover este controle? [ s / n ]\n\n > ");
                Scanner entrada = new Scanner(System.in);
                String resposta = entrada.nextLine();
                if ( !"s".equals(resposta) && !"n".equals(resposta) ){
                    System.out.println("\nResposta inválida.");
                }
                else if ( "s".equals(resposta) ){
                    controles.remove(op);
                    this.num_controles--;
                    System.out.println("\nControle removido com sucesso.");
                }
                else System.out.println("\nOk. Saindo...");
            }
        }
    }
    
    @Override
    public void jogar(){
        if ( this.num_controles == 0 ) System.out.println("\nErro, precisa de "
                + "pelo menos um controle.");
        else{
            if ( num_jogos == 0 ){
                System.out.println("\nNão existe nenhum jogo ainda.");
            }
            else{
                System.out.println("\nQual jogo você gostaria de jogar?");
                System.out.println("Lista de jogos:\n");
                int i = 1;
                for ( Jogo x : jogos ) {
                    System.out.println( i + " - " + x.getNome() );
                    i++;
                }
                System.out.print("\n\n > ");
                Scanner entrada = new Scanner(System.in);
                int resposta;
                
                while(true){
                    if (entrada.hasNextInt())
                        resposta = entrada.nextInt();
                    else{
                        System.out.print("Erro. Insira um número.\n\n > ");
                        entrada.next();
                        continue;
                    }
                    break;
                }
                
                if ( resposta < 1 || resposta > num_jogos ) 
                    System.out.println("\nJogo não encontrado.");
                else{
                    System.out.println("\nJogando " + 
                            jogos.get( resposta - 1 ).getNome() + "!");
                    System.out.println("\nPressione enter para parar de "
                            + "jogar.");
                    Scanner sair = new Scanner(System.in);
                    sair.nextLine();
                    System.out.println("Saindo do jogo...");
                }
            }
        }
    }
    
    public void adicionarMemoria( double memoria ){
        if ( memoria < 0 ) System.out.println("\nErro. Deve se adicionar pelo "
                + "menos 0GB.\nSaindo...");
        else this.memoria[1] += memoria;
    }
    
    public ArrayList <Jogo> inserirJogo( ArrayList <Jogo> games ){
        Scanner scan = new Scanner(System.in);
        int op;
        if ( games.isEmpty() ){
            System.out.println("\nVocê não tem nenhum jogo!");
        }
        else{
            System.out.println("\nQual dos jogos você quer inserir? [ 1 - "
            + games.size() + " ]");
            int i = 1;
            for ( Jogo x : games ){
                System.out.println( i + ")" + x );
                i++;
            }
            System.out.print("\n > ");

            while(true){
                if (scan.hasNextInt())
                    op = scan.nextInt();
                else{
                    System.out.print("Erro. Insira um número.\n\n > ");
                    scan.next();
                    continue;
                }
                break;
            }

            if ( op < 1 || op > games.size() )
                System.out.println("\nNúmero inválido.\nSaindo...");
            else{
                if ( !(this.nome).equals(games.get(op-1).getPlataforma()) ){
                    System.out.println("\nErro. O jogo não é para " + this.nome 
                            + ".");
                }
                else{
                    boolean existe = false;
                    
                    for ( Jogo x: this.jogos ){
                        if ( x.equals(games.get(op-1)) ){
                            System.out.println("\nJogo já existe no console!");
                            existe = true;
                            break;
                        }
                    }
                    if ( !existe ){
                        if ( ( this.memoria[0] + games.get(op-1).getTamanho() )
                                > this.memoria[1] ){
                            System.out.println("\nErro. Memória insuficiente.");
                            System.out.println("Precisa de mais " +
                                    ( ( this.memoria[0] + 
                                    games.get(op-1).getTamanho() )
                                            - this.memoria[1] ) + "GB.");
                        }
                        else{
                            this.jogos.add( games.get(op-1) );
                            this.memoria[0] += games.get(op-1).getTamanho();
                            games.remove(op-1);
                            this.num_jogos++;
                            System.out.println("\nJogo inserido com sucesso.");
                            if ( this.memoria[0] == this.memoria[1] ){
                                System.out.println("\nAtenção. Agora a memória "
                                        + "está cheia.");
                            }
                        }
                    }
                    
                }
            }
        }
        
        return games;
    }
    
    // funções abstratas
    public abstract void inserirControle();
    public abstract ArrayList<Jogo> menu( ArrayList<Jogo> jogos );
    
    @Override
    public abstract void atualizar();

    @Override
    public int compareTo( Console outro ){
        if ( this.num_jogos > outro.num_jogos ) return 1;
        else if ( this.num_jogos == outro.num_jogos ) return 0;
        else return -1;
    }
    
    @Override
    public boolean equals( Object obj ){
        if ( obj instanceof Console ){
            Console c = ( Console )obj;
            return ( this.nome.equals(c.nome) );
        }
        else return false;
    }
}
