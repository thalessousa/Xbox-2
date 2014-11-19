package projeto.Device;

import java.util.ArrayList;
import java.util.Scanner;
import projeto.Externos.Controle;
import projeto.Outros.Data;
import projeto.Externos.Jogo;
import projeto.Outros.Usuario;
import projeto.Interfaces.Userable;

/*
 * @author Gio
 */
public class Playstation3 extends Console implements Userable {
    private ArrayList<Usuario> usuarios; // usuários registrados
    private int num_usuarios = 0; // número de usuários
    private static final double ULTIMA_VERSAO = 4.65;
    
    // construtor vazio
    public Playstation3(){
        super();
        usuarios = new ArrayList<>();
        this.num_usuarios = 0;      
    }
    
    // construtor
    public Playstation3(String nome, String ligado, Data lancamento,
            String modelo, double memoria, double versao, double preco ){
        super( nome, ligado, lancamento, modelo, memoria, versao, preco );
        usuarios = new ArrayList<>();
        this.num_usuarios = 0;
    }
    
    // construtor de cópia
    public Playstation3( Playstation3 outro ){
        super( outro );
        usuarios = new ArrayList<>();
        this.usuarios = outro.usuarios;
        this.num_usuarios = outro.num_usuarios;
    }
    
    // construtor de ps 3
    public Playstation3( Data data ){
        super( "Playstation 3", "d", data, "CECHC03", 60.0, 1.0, 889.00 );
        usuarios = new ArrayList<>();
        this.num_usuarios = 0;
    }
    
    // outras funções
    @Override
    public void inserirUsuario(){
        System.out.print("\nInsira o seu nome.\n\n > ");
        Scanner entrada = new Scanner(System.in);
        String resposta = entrada.nextLine();
        System.out.print("\nInsira o seu username(caracteres especiais serão "
                + "ignorados).\n\n > ");
        String resposta2 = entrada.nextLine();
        resposta2 = resposta2.replaceAll("[^\\w\\_]", "");
        boolean existe = false;
        for ( Usuario x : usuarios ){
            if ( x.getUsername().equals(resposta2) ){
                System.out.println("\nUsername já existente.");
                existe = true;
                break;
            }
        }
        if ( !existe ){
                this.num_usuarios++;
                Usuario novo = new Usuario( resposta, resposta2 );
                usuarios.add( novo );
                System.out.println("\nUsuário cadastrado com sucesso.");
        }
    }
    
    @Override
    public void removerUsuario(){
        if ( this.num_usuarios == 0 ) System.out.println("\nNão existem "
                + "usuários.");
        else{
            System.out.println("\nQual dos usuários você gostaria de remover? "
                    + "[ 1 - " + this.num_usuarios + " ]" );
            int i = 1;
            for ( Usuario x : this.usuarios ){
                    System.out.println( i +  ")" + x);
                    i++;
            }
            System.out.print(" > ");
            Scanner scan = new Scanner(System.in);
            int op;
            
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
            op -= 1;
            if( op < 0 || op > this.num_usuarios - 1 ){
                System.out.println("Número inválido.");
            }
            else{
                System.out.print("\nRemover o usuário " 
                        + usuarios.get(op).getUsername() + "? [ s / n ]"
                        + "\n\n > " );
                Scanner scan2 = new Scanner(System.in);
                String resposta = scan2.nextLine();
                if ( !"s".equals(resposta) && !"n".equals(resposta) ){
                    System.out.println("Resposta inválida.");
                }
                else{
                    if ( "s".equals(resposta) ){
                        this.usuarios.remove(op);
                        this.num_usuarios--;
                        System.out.println("\nUsuário removido com sucesso.");
                    }
                    else{
                        System.out.println("\nOk. Saindo...");
                    }
                }
            }
        }
    }
    
    @Override
    public void inserirControle(){
        if ( this.num_controles == this.MAX_CONTROLES ){
            System.out.println("\nErro. Número máximo de controles atingido.");
        }
        else{
            Controle novo = new Controle();
            String [] botoes;
            botoes = new String []{"PS", "Start", "Select", "X", "\u25CB",
                "\u25A1", "\u25B3", "R1", "R2", "L1", "L2", "Analógico direita",
                "Analógico esquerda", "Direcional"};
            
            novo.setBotoes( botoes );
            
            System.out.print("\nVocê vai inserir um controle sem fio ou com "
                    + "fio? [ s / c ]\n\n > ");
            Scanner entrada = new Scanner(System.in);
            String resposta = entrada.nextLine();
            novo.setSemFio( resposta );
            
            this.controles.add(novo);
            
            this.num_controles++;
            System.out.println("\nControle inserido com sucesso.");
            if ( this.num_controles == this.MAX_CONTROLES ){
                System.out.println("\nAtenção. Agora o número de controles "
                        + "chegou ao máximo.");
            }      
        }      
    }
    
    @Override
    public String toString(){
        StringBuilder resultado = new StringBuilder();
        
        resultado.append( super.toString() );
        resultado.append("Usuários logados: " + this.num_usuarios + ".\n");
        
        return resultado.toString();
    }
    
    @Override
    public ArrayList<Jogo> menu( ArrayList jogos ){
        int op = 1;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("\n->Menu do Playstation 3<-\n");
            System.out.println("Escolha a sua opção:");
            System.out.println("0 - Sair.");
            System.out.println("1 - Inserir jogo.");
            System.out.println("2 - Inserir controle.");
            System.out.println("3 - Jogar jogo.");
            System.out.println("4 - Atualizar o Playstation 3.");
            System.out.println("5 - Remover jogo.");
            System.out.println("6 - Remover controle.");
            System.out.println("7 - Inserir usuário.");
            System.out.println("8 - Remover usuário.");
            System.out.println("9 - Mostrar jogos.");
            System.out.println("10 - Mostrar controles.");
            System.out.println("11 - Mostrar status.");
            System.out.println("12 - Mostrar usuários.");
            
            System.out.print("\n > ");
            
            // verificação de dados
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
            
            switch(op){
                case 1:{
                    jogos = inserirJogo( jogos );
                    break;
                }
                case 2:{
                    inserirControle();
                    break;
                }
                case 3:{
                    jogar();
                    break;
                }
                case 4:{
                    atualizar();
                    break;
                }
                case 5:{
                    jogos = removerJogo( jogos );
                    break;
                }
                case 6:{
                    removerControle();
                    break;
                }
                
                case 7:{
                    inserirUsuario();
                    break;
                }
                case 8:{
                    removerUsuario();
                    break;
                }
                case 9:{
                    showJogos();
                    break;
                }
                case 10:{
                    showControles();
                    break;
                }
                case 11:{
                    System.out.println(this);
                    break;
                }
                case 12:{
                    if ( this.num_usuarios == 0 ) System.out.println("não "
                            + "existe nenhum usuário.");
                    else{
                        int i = 1;
                        for ( Usuario x : usuarios ){
                            System.out.println( i + ")" + x);
                            i++;
                        }
                    }
                    break;
                }
                default:{
                    if ( op != 0 ) System.out.println("\nNúmero inválido.");
                    break;
                }
            }
        } while( op != 0 );
        this.ligado = false;
        return jogos;
    }
    
    @Override
    public void atualizar(){
        Scanner scan = new Scanner(System.in);
        double op;
        System.out.println("\nVersão atual do seu Playstation 3: " 
                + this.versao);
        System.out.print("Atualizar para qual versão? [ Última versão: " 
        + Playstation3.ULTIMA_VERSAO + " ]\n\n > ");
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
        if ( op > Playstation3.ULTIMA_VERSAO ){
            System.out.println("\nErro: deve ser menor ou igual a versão mais"
                    + " recente.");
        }
        else this.setVersao( op );
    }
    
}
