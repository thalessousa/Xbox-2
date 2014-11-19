package projeto.Externos;

import java.util.ArrayList;

/*
 * @author Gio
 */
public class Controle {
    private ArrayList<String> botoes; // botões do controle
    private int num_botoes = 0; // número de botões do controle
    private final static int MAX_BOTOES = 15; // controle de botões
    private boolean sem_fio; // se precisa ser plugado ou não
    
    // construtor vazio
    public Controle(){
        this.botoes = new ArrayList<>(MAX_BOTOES);
        this.sem_fio = false;
        
    }
    
    // construtor
    public Controle( String [] botoes, String sem_fio ){
        this.botoes = new ArrayList<>(MAX_BOTOES);
        this.setBotoes( botoes );
        this.setSemFio( sem_fio );
    }
    
    // construtor de cópia
    public Controle( Controle outro ){
        this.botoes = new ArrayList<>(MAX_BOTOES);
        this.botoes = outro.botoes;
        this.num_botoes = outro.num_botoes;
        this.sem_fio = outro.sem_fio;
    }
    
    // gets
    public String getBotao( int i ){
        return this.botoes.get(i);
    }
    
    public int getNumBotoes(){
        return num_botoes;
    }
    
    public boolean getSemFio(){
        return this.sem_fio;
    }
    
    // sets
    public final void setBotoes( String [] botoes ){
        if ( botoes.length > Controle.MAX_BOTOES ){
            System.out.println("\nErro. Número máximo de botões atingidos.");
        }
        else{
            for ( String x : botoes ){
                if ( "\0".equals(x) ){
                    System.out.println("\nErro. Botão deve ter pelo menos um "
                            + "caracter.");
                }
                else {
                    boolean existe = false;
                    for ( String y : this.botoes ){
                        if ( y.equals(x) ){
                            System.out.println("\nErro. Botão " + y + "já "
                                    + "existente.");
                            existe = true;
                            break;
                        }
                    }
                    if ( !existe ){
                        this.botoes.add(x);
                        this.num_botoes++;
                    }
                }
            }
        }
    }
    
    public final void setSemFio( String sem_fio ){
         if ( !"s".equals(sem_fio) && !"c".equals(sem_fio) ){
            System.out.println("\nErro. Deve-se usar apenas 's' ou 'c'.");
            System.out.println("Inserindo valor default...");
            this.sem_fio = false;
        }
        else this.sem_fio = "s".equals(sem_fio);
    }
    
    // outras funções  
    @Override
    public String toString(){
        StringBuilder resultado = new StringBuilder();
        resultado.append("\nBotões:\n");
        for ( int x = 0 ; x < num_botoes ; x++ ){
            resultado.append( botoes.get(x) + " ");
            if ( x % 4 == 0 ) resultado.append("\n");
        }
        if ( this.sem_fio ) resultado.append("\nSem fio.\n");
        else resultado.append("\nPlugado.\n");
        
        return resultado.toString();
    }
 
}
