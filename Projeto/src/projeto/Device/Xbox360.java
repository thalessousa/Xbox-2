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
public class Xbox360 extends Console implements Userable {
    private ArrayList<Usuario> usuarios; // usuários registrados
    private int num_usuarios = 0; // número de usuários
    private boolean kinect_ligado;
    private int [] posicao; // [0] = x, [1] = y, [2] = z
    private static final double ULTIMA_VERSAO =  2.0167670;
    
    // construtor vazio
    public Xbox360(){
        super();
        usuarios = new ArrayList<>();
        this.num_usuarios = 0;
        this.kinect_ligado = false;
        this.posicao = new int [3];
        this.posicao[0] = 0;
        this.posicao[1] = 0;
        this.posicao[2] = 0;
        
    }
    
    // construtor
    public Xbox360(String nome, String ligado, Data lancamento, String modelo,
            double memoria, double versao, double preco, 
            int x, int y, int z, String kinect_ligado ){
        super( nome, ligado, lancamento, modelo, memoria, versao, preco );
        usuarios = new ArrayList<>();
        this.num_usuarios = 0;
        this.setKinectLigado( kinect_ligado );
        this.posicao = new int [3];
        this.setX( x );
        this.setY( y );
        this.setZ( z );
    }
    
    // construtor de cópia
    public Xbox360( Xbox360 outro ){
        super( outro );
        usuarios = new ArrayList<>();
        this.usuarios = outro.usuarios;
        this.num_usuarios = outro.num_usuarios;
        this.kinect_ligado = outro.kinect_ligado;
        this.posicao = new int [3];
        this.posicao[0] = outro.posicao[0];
        this.posicao[1] = outro.posicao[1];
        this.posicao[2] = outro.posicao[2];
    }
    
    // construtor de xbox 360
    public Xbox360( Data data ){
        super( "Xbox 360", "d", data, "RKH-00001", 2.0, 1.0, 664.90 );
        
        usuarios = new ArrayList<>();
        this.num_usuarios = 0;
        this.kinect_ligado = false;
        this.posicao = new int [3];
        this.posicao[0] = 0;
        this.posicao[1] = 0;
        this.posicao[2] = 0;
    }
    
    // gets
    public int getX(){
        return this.posicao[0];
    }
    
    public int getY(){
        return this.posicao[1];
    }
    
    public int getZ(){
        return this.posicao[2];
    }
    
    public boolean getKinectLigado(){
        return this.kinect_ligado;
    }
    
    // sets
    public final void setKinectLigado( String kinect_ligado ){
        if ( !"l".equals(kinect_ligado) && !"d".equals(kinect_ligado) ){
            System.out.println("\nErro. Deve-se usar apenas 'l' ou 'd'.");
            System.out.println("Inserindo valor default...");
            this.kinect_ligado = false;
        }
        else this.kinect_ligado = "l".equals(kinect_ligado);
    }
    
    public final void setX( int x ){
        if ( x < 0 || x > 100 ){
            System.out.println("\nErro. Coordenada x fora da área de alcance.");
            System.out.println("Inserindo valor default...");
            this.posicao[0] = 0;
        }
        else this.posicao[0] = x;
    }
    
    public final void setY( int y ){
        if ( y < 0 || y > 100 ){
            System.out.println("\nErro. Coordenada y fora da área de alcance.");
            System.out.println("Inserindo valor default...");
            this.posicao[1] = 0;
        }
        else this.posicao[1] = y;
    }
    
    public final void setZ( int z ){
        if ( z < 0 || z > 100 ){
            System.out.println("\nErro. Coordenada z fora da área de alcance.");
            System.out.println("Inserindo valor default...");
            this.posicao[2] = 0;
        }
        else this.posicao[2] = z;
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
    public void inserirControle(){
        if ( this.num_controles == this.MAX_CONTROLES ){
            System.out.println("\nErro. Número máximo de controles atingido.");
        }
        else{
            Controle novo = new Controle();
            String [] botoes;
            botoes = new String []{"Xbox", "Start", "Back", "A", "B", "X", "Y",
                "RB", "RT", "LB", "LT", "Analógico direita",
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
        resultado.append("Kinect ");
        if ( this.kinect_ligado ){
            resultado.append("ligado.\n");
            resultado.append("Posição: ( " + this.posicao[0] + ", " 
                    + this.posicao[1] + ", " + this.posicao[2] + " )\n");
        }
        else resultado.append("desligado.\n");
        
        return resultado.toString();
    }
    
    public void showUsuarios(){
        if ( this.num_usuarios == 0 ) System.out.println("Sem usuários ainda.");
        else{
            int i = 1;
            for ( Usuario x : this.usuarios ){
                System.out.println( i + ")" + x);
            }
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
            System.out.print("\n > ");
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
    public ArrayList<Jogo> menu( ArrayList<Jogo> jogos ){
        int op = 1;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("\n->Menu do Xbox 360<-\n");
            System.out.println("Escolha a sua opção:");
            System.out.println("0 - Sair.");
            System.out.println("1 - Inserir jogo.");
            System.out.println("2 - Inserir controle.");
            System.out.println("3 - Inserir usuário.");
            System.out.println("4 - Jogar jogo.");
            System.out.println("5 - Atualizar o Xbox 360.");
            System.out.println("6 - Ligar Kinect.");
            System.out.println("7 - Inserir posição atual.");
            System.out.println("8 - Remover jogo.");
            System.out.println("9 - Remover controle.");
            System.out.println("10 - Remover usuário.");
            System.out.println("11 - Mostrar jogos.");
            System.out.println("12 - Mostrar controles.");
            System.out.println("13 - Mostrar status.");
            System.out.println("14 - Mostrar usuários.");
            
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
                    inserirUsuario();
                    break;
                }
                case 4:{
                    jogar();
                    break;
                }
                case 5:{
                    atualizar();
                    break;
                }
                case 6:{
                    System.out.print("\nVocê quer o kinect ligado ou"
                            + " desligado? [ l / d ]\n\n > ");
                    Scanner scan2 = new Scanner(System.in);
                    String resp = scan2.nextLine();
                    this.setKinectLigado(resp);
                    break;
                }
                case 7:{
                    mudarPosicao();
                    break;
                }
                case 8:{
                    jogos = removerJogo( jogos );
                    break;
                }
                case 9:{
                    removerControle();
                    break;
                }
                case 10:{
                    removerUsuario();
                    break;
                }
                case 11:{
                    showJogos();
                    break;
                }
                case 12:{
                    showControles();
                    break;
                }
                case 13:{
                    System.out.println(this);
                    break;
                }
                case 14:{
                    if ( this.num_usuarios == 0 ) System.out.println("Não "
                            + "existe nenhum usuário.");
                    else{
                        int i = 1;
                        for ( Usuario x : this.usuarios ){
                            System.out.println(i + ")" + x);
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
        
        this.kinect_ligado = false;
        this.ligado = false;
        return jogos;
    }
    
    @Override
    public void atualizar(){
        Scanner scan = new Scanner(System.in);
        double op;
        System.out.println("\nVersão atual do seu Xbox 360: " 
                + this.versao);
        System.out.print("Atualizar para qual versão? [ Última versão: " 
        + Xbox360.ULTIMA_VERSAO + " ]\n\n > ");
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
        if ( op > Xbox360.ULTIMA_VERSAO ){
            System.out.println("\nErro: deve ser menor ou igual a versão mais"
                    + " recente.");
        }
        else this.setVersao( op );
    }
    
    public void mudarPosicao(){
        if ( !this.kinect_ligado ){
            System.out.println("\nErro. Kinect precisa estar ligado.");
        }
        else{
            Scanner scan = new Scanner(System.in);
            int x, y, z;

            System.out.print("Insira a posição X. [ 0 - 100 ]\n\n > ");
            while(true){
                    if (scan.hasNextInt())
                        x = scan.nextInt();
                    else{
                        System.out.print("Erro. Insira um número.\n\n > ");
                        scan.next();
                        continue;
                    }
                    break;
            }
            this.setX(x);

            System.out.print("Insira a posição Y. [ 0 - 100 ]\n\n > ");
            while(true){
                    if (scan.hasNextInt())
                        y = scan.nextInt();
                    else{
                        System.out.print("Erro. Insira um número.\n\n > ");
                        scan.next();
                        continue;
                    }
                    break;
            }
            this.setY(y);

            System.out.print("Insira a posição Z. [ 0 - 100 ]\n\n > ");
            while(true){
                    if (scan.hasNextInt())
                        z = scan.nextInt();
                    else{
                        System.out.print("Erro. Insira um número.\n\n > ");
                        scan.next();
                        continue;
                    }
                    break;
            }
            this.setZ(z);
        }
    }
    
}
