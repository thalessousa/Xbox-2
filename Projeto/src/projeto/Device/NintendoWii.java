package projeto.Device;

import java.util.ArrayList;
import java.util.Scanner;
import projeto.Externos.Controle;
import projeto.Outros.Data;
import projeto.Externos.Jogo;

/*
 * @author Gio
 */
public class NintendoWii extends Console {
    private boolean sensor_bar;
    private int [] posicao;
    private static final double ULTIMA_VERSAO = 4.3;
    
    // construtor vazio
    public NintendoWii(){
        super();
        this.sensor_bar = false;
        this.posicao = new int [3];
        this.posicao[0] = 0;
        this.posicao[1] = 0;
        this.posicao[2] = 0;
        
    }
    
    // construtor
    public NintendoWii( String nome, String ligado, Data lancamento,
            String modelo, double memoria, double versao, double preco,
            int x, int y, int z, String sensor_bar ){
        super( nome, ligado, lancamento, modelo, memoria, versao, preco );
        this.setSensorBar( sensor_bar );
        this.posicao = new int [3];
        this.setX( x );
        this.setY( y );
        this.setZ( z );
    }
    
    // construtor de cópia
    public NintendoWii( NintendoWii outro ){
        super( outro );
        this.sensor_bar = outro.sensor_bar;
        this.posicao = new int [3];
        this.posicao[0] = outro.posicao[0];
        this.posicao[1] = outro.posicao[1];
        this.posicao[2] = outro.posicao[2];
    }
    
    // construtor de wii
    public NintendoWii( Data data ){
        super( "Nintendo Wii", "d", data, "RVL-001", 2.0, 1.0, 769.90 );
        this.sensor_bar = false;
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
    
    public boolean getSensorBar(){
        return this.sensor_bar;
    }
    
    // sets
    public final void setSensorBar( String sensor_bar ){
        if ( !"l".equals(sensor_bar) && !"d".equals(sensor_bar) ){
            System.out.println("\nErro. Deve-se usar apenas 'l' ou 'd'.");
            System.out.println("Inserindo valor default...");
            this.sensor_bar = false;
        }
        else this.sensor_bar = "l".equals(sensor_bar);
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
    
    @Override
    public void inserirControle(){
        if ( this.num_controles == this.MAX_CONTROLES ){
            System.out.println("\nErro. Número máximo de controles atingido.");
        }
        else{
            Controle novo = new Controle();
            System.out.print("\nVocê vai inserir um controle sem fio ou com "
                    + "fio? [ s / c ]\n\n > ");
            Scanner entrada = new Scanner(System.in);
            String resposta = entrada.nextLine();
            novo.setSemFio( resposta );
            
            String [] botoes;
            
            if ( novo.getSemFio() ){
                System.out.println("\nControle wii com nunchuck identificado.");
                botoes = new String []{"Home", "Direcional", "A", "B", "\uff0d",
                    "\uff0b", "1", "2", "Analógico", "C", "Z"};
            }
            else{
                System.out.println("\nControle gamecube identificado.");
                botoes = new String []{"Start/Pause", "A", "B", "X", "Y", "L",
                    "R", "Z", "Analógico esquerda", "Analógico C",
                    "Direcional"};
            }
            
            novo.setBotoes( botoes );
            
            this.controles.add( novo );
            
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
        resultado.append("Sensor bar ");
        if ( this.sensor_bar ){
            resultado.append("ligada.\n");
            resultado.append("Posição: ( " + this.posicao[0] + ", " 
                    + this.posicao[1] + ", " + this.posicao[2] + " )\n");
        }
        else resultado.append("desligada.\n");
        
        return resultado.toString();
    }
    
    @Override
    public ArrayList<Jogo> menu( ArrayList<Jogo> jogos ){
        this.sensor_bar = true; // precisa ligar o sensor bar para usar o wii
        int op = 1;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.println("\n->Menu do Nintendo Wii<-\n");
            System.out.println("Escolha a sua opção:");
            System.out.println("0 - Sair.");
            System.out.println("1 - Inserir jogo.");
            System.out.println("2 - Inserir controle.");
            System.out.println("3 - Jogar jogo.");
            System.out.println("4 - Atualizar o Nintendo Wii.");
            System.out.println("5 - Inserir posição atual.");
            System.out.println("6 - Remover jogo.");
            System.out.println("7 - Remover controle.");
            System.out.println("8 - Mostrar jogos.");
            System.out.println("9 - Mostrar controles.");
            System.out.println("10 - Mostrar status.");
            
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
                    mudarPosicao();
                    break;
                }
                case 6:{
                    jogos = removerJogo( jogos );
                    break;
                }
                case 7:{
                   removerControle();
                    break;
                }
                case 8:{
                    showJogos();
                    break;
                }
                case 9:{
                    showControles();
                    break;
                }
                case 10:{
                    System.out.println(this);
                    break;
                }
                default:{
                    if ( op != 0 ) System.out.println("\nNúmero inválido.");
                    break;
                }
            }
        } while( op != 0 );
        
        this.sensor_bar = false;
        this.ligado = false;
        return jogos;
    }
    
    @Override
    public void atualizar(){
        Scanner scan = new Scanner(System.in);
        double op;
        System.out.println("\nVersão atual do seu Nintendo Wii: " 
                + this.versao);
        System.out.print("Atualizar para qual versão? [ Última versão: " 
        + NintendoWii.ULTIMA_VERSAO + " ]\n\n > ");
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
        if ( op > NintendoWii.ULTIMA_VERSAO ){
            System.out.println("\nErro: deve ser menor ou igual a versão mais"
                    + " recente.");
        }
        else this.setVersao( op );
    }
    
    public void mudarPosicao(){
        Scanner scan = new Scanner(System.in);
        int x, y, z;
        
        System.out.println("Insira a posição X. [ 0 - 100 ]\n\n > ");
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
        
        System.out.println("Insira a posição Y. [ 0 - 100 ]\n\n > ");
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
        
        System.out.println("Insira a posição Z. [ 0 - 100 ]\n\n > ");
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
