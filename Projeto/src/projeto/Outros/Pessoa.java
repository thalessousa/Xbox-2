package projeto.Outros;

import projeto.Externos.Jogo;
import java.util.ArrayList;
import java.util.Collections;
import projeto.Device.Console;
import java.util.Scanner;
import projeto.Device.NintendoWii;
import projeto.Device.Xbox360;
import projeto.Device.Playstation3;

/*
 * @author Gio
 */
public class Pessoa {
    private double dinheiro;
    private ArrayList<Console> consoles; // consoles comprados
    private ArrayList<Jogo> jogos; // jogos comprados
    private static int num_consoles = 0;
    private static int num_jogos = 0;
    
    // construtor vazio
    public Pessoa(){
        this.consoles = new ArrayList<>();
        this.jogos = new ArrayList<>();
        this.dinheiro = 0;
    }
    
    // construtor
    public Pessoa( double dinheiro ){
        this.consoles = new ArrayList<>();
        this.jogos = new ArrayList<>();
        this.dinheiro = dinheiro;
    }
    
    // get
    public double getDinheiro(){
        return this.dinheiro;
    }
    
    // set
    public void setDinheiro( double dinheiro ){
        if ( dinheiro < 0 ){
            System.out.println("\nErro. Dinheiro deve ser pelo menos R$0.");
            System.out.println("Inserindo valor default...");
            this.dinheiro = 0;
        }
        else this.dinheiro = dinheiro; 
    }
    
    // outras funções
    public void sacarDinheiro(){
        Scanner scan = new Scanner(System.in);
        double op;
        // como meu programa não é caixa eletrônico, não vou me preocupar com
        // saldo, etc
        System.out.println("\nQuanto irá sacar?");
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
        if ( op < 0 ) System.out.println("\nErro. Dinheiro deve ser pelo menos"
                + " R$0.\nSaindo...");
        else this.dinheiro += op;
        
    }
    
    public void comprarConsole(){
        Scanner scan = new Scanner(System.in);
        Console [] lista;
        lista = new Console[3];
        int op;
        Data data = new Data(14,11,2014);
        
        lista[0] = new NintendoWii(data);
        lista[1] = new Xbox360(data);
        lista[2] = new Playstation3(data);
        
        System.out.println("\nQual dos consoles você gostaria de comprar?"
                + " [ 1 - 3 ]");
        
        for ( int i = 0 ; i < 3 ; i++ ){
            System.out.println( ( i + 1 ) + ")" + lista[i]);
        }
        
        System.out.print(" > ");
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
        
        if ( op < 0 || op > 2 ) System.out.println("\nNúmero inválido.\n"
                + "Saindo...");
        else{
            if ( this.dinheiro < lista[op].getPreco() ) System.out.println("\n"
                    + "Seu dinheiro é insuficiente.\nSaindo...");
            else{
                boolean existe = false;
                
                for ( Console x: this.consoles ){
                    if ( x.equals(lista[op]) ){
                        existe = true;
                        break;
                    }
                }
                if ( existe ){
                    String resp;
                    System.out.print("Você já possue este console. Deseja"
                            + " comprar mesmo assim? [ s / n ]\n\n > ");
                    resp = scan.next();
                    if ( !resp.equals("s") && !resp.equals("n") ){
                        System.out.println("\nResposta inválida.");
                    }
                    else{
                        if ( resp.equals("s") ){
                            this.dinheiro -= lista[op].getPreco();
                            this.consoles.add( lista[op] );
                            Pessoa.num_consoles++;
                            System.out.println("\nAgradecemos a sua compra! "
                                    + "Volte sempre!");
                        }
                        else System.out.println("\nOk. Saindo...");
                    }
                }
                else{
                    this.dinheiro -= lista[op].getPreco();
                    this.consoles.add( lista[op] );
                    Pessoa.num_consoles++;
                    System.out.println("\nAgradecemos a sua compra! "
                            + "Volte sempre!");
                }
                
            }
        }
    }
    
    public void comprarMemoria(){
        if ( Pessoa.num_consoles == 0 ) System.out.println("Você não tem "
                + "nenhum console!");
        else{
            Scanner scan = new Scanner(System.in);
            int op;
            System.out.println("\nEscolha um dos consoles abaixo. [ 1 - "
            + Pessoa.num_consoles + " ]");
            for ( int i = 0 ; i < Pessoa.num_consoles ; i++ ){
                System.out.println( ( i + 1 ) + ")" + this.consoles.get(i));
            }
            System.out.print(" > ");
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

            if ( op < 0 || op > Pessoa.num_consoles - 1 ) System.out.println(
                    "\nNúmero inválido.\nSaindo...");
            else{
                double [] lista;
                double [] preco;
                lista = new double[4];
                preco = new double[4];
                int op2;

                lista[0] = 2.0;
                lista[0] = 4.0;
                lista[1] = 8.0;
                lista[2] = 16.0;

                preco[0] = 133.00;
                preco[1] = 184.00;
                preco[2] = 329.00;
                preco[3] = 748.00;       

                System.out.println("\nQuais adicionais de memória você gostaria"
                        + " ter?"
                        + " [ 1 - 4 ]");

                for ( int i = 0 ; i < 3 ; i++ ){
                    System.out.println( ( i + 1 ) + ")\n" + lista[i] + "GB.\n"
                            + "Preço: R$" + preco[i] + "\n");
                }

                System.out.print(" > ");
                while(true){
                    if (scan.hasNextInt())
                        op2 = scan.nextInt();
                    else{
                        System.out.print("Erro. Insira um número.\n\n > ");
                        scan.next();
                        continue;
                    }
                    break;
                }

                op2 -= 1;

                if ( op2 < 0 || op2 > 2 ) System.out.println("\nNúmero "
                        + "inválido.\nSaindo...");
                else{
                    if ( this.dinheiro < preco[op2] ) System.out.println("\n"
                            + "Seu dinheiro é insuficiente.\nSaindo...");
                    else{
                        this.dinheiro -= preco[op2];
                        this.consoles.get(op).adicionarMemoria(lista[op2]);
                        System.out.println("\nAgradecemos a sua compra! Volte "
                                + "sempre!");
                    }
                }
            }
        }
        
    }
    
    public void comprarJogo(){
        Scanner scan = new Scanner(System.in);
        Jogo [] lista;
        lista = new Jogo[6];
        int op;
        Data data = new Data(14,11,2014);
        
        lista[0] = new Jogo("PES 2015", data, "Konami","Xbox 360", 5.0, 141.40);
        lista[1] = new Jogo("Deus Ex", data, "Square Enix", "Xbox 360", 
                4.0, 56.91);
        lista[2] = new Jogo("Dark Souls", data, "Bandai", "Playstation 3", 
                9.0, 94.91);
        lista[3] = new Jogo("Watch Dogs", data, "Ubisoft", "Playstation 3", 
                8.0, 94.91);
        lista[4] = new Jogo("Call of Duty MW3", data, "Activision", 
                "Nintendo Wii", 15.0, 56.91);
        lista[5] = new Jogo("The Legend of Zelda: Twilight Princess", data, 
                "Nintendo", "Nintendo Wii", 
                0.505, 129.00);
        
        System.out.println("\nQual dos jogos você gostaria de comprar?"
                + " [ 1 - 6 ]");
        
        for ( int i = 0 ; i < 6 ; i++ ){
            System.out.println( ( i + 1 ) + ")" + lista[i]);
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
        
        op -= 1;
        
        if ( op < 0 || op > 5 ) System.out.println("\nNúmero inválido.\n"
                + "Saindo...");
        else{
            if ( this.dinheiro < lista[op].getPreco() ) System.out.println("\n"
                    + "Seu dinheiro é insuficiente.\nSaindo...");
            else{
                boolean existe = false;
                
                for ( Jogo x: this.jogos ){
                    if ( x.equals(lista[op]) ){
                        existe = true;
                        break;
                    }
                }
                if ( existe ){
                    String resp;
                    System.out.print("Você já possue este jogo. Deseja"
                            + " comprar mesmo assim? [ s / n ]\n\n > ");
                    resp = scan.next();
                    if ( !resp.equals("s") && !resp.equals("n") ){
                        System.out.println("\nResposta inválida.");
                    }
                    else{
                        if ( resp.equals("s") ){
                            this.dinheiro -= lista[op].getPreco();
                            this.jogos.add( lista[op] );
                            Pessoa.num_jogos++;
                            System.out.println("\nAgradecemos a sua compra! "
                                    + "Volte sempre!");
                        }
                        else System.out.println("\nOk. Saindo...");
                    }
                }
                else{
                    this.dinheiro -= lista[op].getPreco();
                    this.jogos.add( lista[op] );
                    Pessoa.num_jogos++;
                    System.out.println("\nAgradecemos a sua compra! "
                            + "Volte sempre!");
                }
            }
        }
    }
    
    public void ligarDesligarConsole(){
        if ( Pessoa.num_consoles == 0 ) System.out.println("\nErro, você não "
                + "possui nenhum console ainda.\nSaindo...");
        else{
            Scanner scan = new Scanner(System.in);
            int op;
            System.out.println("\nEscolha um dos consoles abaixo. [ 1 - "
            + Pessoa.num_consoles + " ]");
            for ( int i = 0 ; i < Pessoa.num_consoles ; i++ ){
                System.out.println( ( i + 1 ) + ")" + this.consoles.get(i));
            }
            System.out.print(" > ");
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

            if ( op < 0 || op > Pessoa.num_consoles - 1 ) System.out.println("\n"
                    + "Número inválido.\nSaindo...");
            else{
                if ( this.consoles.get(op).getLigado() ){
                    this.consoles.get(op).setLigado("d");
                    System.out.println("Console desligado.");
                }
                else{
                    this.consoles.get(op).setLigado("l");
                    System.out.println("Console ligado.");
                }
            }
        }
    }
    
    public void usarConsole(){
        if ( Pessoa.num_consoles == 0 ) System.out.println("\nErro, você não "
                + "possui nenhum console ainda.\nSaindo...");
        else{
            Scanner scan = new Scanner(System.in);
            int op;
            System.out.println("\nEscolha um dos consoles abaixo. [ 1 - "
            + Pessoa.num_consoles + " ]");
            for ( int i = 0 ; i < Pessoa.num_consoles ; i++ ){
                System.out.println( ( i + 1 ) + ")" + this.consoles.get(i));
            }
            System.out.print(" > ");
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

            if ( op < 0 || op > Pessoa.num_consoles - 1 ) System.out.println("\n"
                    + "Número inválido.\nSaindo...");
            else{
                if ( !this.consoles.get(op).getLigado() ) System.out.println(
                "\nErro. Console desligado.\nSaindo...");
                else{
                    System.out.println("\nEntrando no menu do "
                    + this.consoles.get(op).getNome() + "...");
                    this.jogos = this.consoles.get(op).menu( this.jogos );
                    Pessoa.num_jogos = this.jogos.size();
                }
            }
        }
    }
    
    public void menu(){
        Scanner scan = new Scanner(System.in);
        int op = 1;
        do{
            Collections.sort(this.consoles);
            Collections.sort(this.jogos);
            
            System.out.println("\n->Menu da pessoa<-");
            // mostra status
            System.out.print(this);
            System.out.println("\nEscolha a sua opção:");
            System.out.println("0 - Sair.");
            System.out.println("1 - Comprar console.");
            System.out.println("2 - Comprar jogos.");
            System.out.println("3 - Comprar mais memória.");
            System.out.println("4 - Conseguir mais dinheiro.");
            System.out.println("5 - Ligar/desligar console.");
            System.out.println("6 - Usar console.");
            System.out.println("7 - Mostrar jogos adquiridos. "
                    + "( não inseridos em um console )");
            System.out.println("8 - Mostrar consoles.");
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
                    comprarConsole();
                    break;
                }
                case 2:{
                    comprarJogo();
                    break;
                }
                case 3:{
                    comprarMemoria();
                    break;
                }
                case 4:{
                    sacarDinheiro();
                    break;
                }
                case 5:{
                    ligarDesligarConsole();
                    break;
                }
                case 6:{
                    usarConsole();
                    break;
                }
                case 7:{
                    if ( Pessoa.num_jogos == 0) System.out.println("Não tem "
                            + "nenhum jogo.");
                    else{
                        int i = 1;
                        for ( Jogo x : this.jogos ){
                            System.out.println( i + ")" +  x);
                            i++;
                        }
                    }
                    break;
                }
                case 8:{
                    if ( Pessoa.num_consoles == 0 ) System.out.println("Não tem "
                            + "nenhum console.");
                    else{
                        int i = 1;
                        for ( Console x : this.consoles ){
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
    }
    
    @Override
    public String toString(){
        String s = String.format("%.2f", this.dinheiro);
        
        return "\nDinheiro: R$" + s + ".\n"
                + "Consoles: " + Pessoa.num_consoles + ".\n"
                
                + "Jogos: " + Pessoa.num_jogos + ".\n";
    }
}
