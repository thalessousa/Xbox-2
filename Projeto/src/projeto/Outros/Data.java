package projeto.Outros;

/*
 * @author Gio
 */

public class Data {
    private int dia;
    private int mes;
    private int ano;
    
    // construtor vazio
    public Data(){
        this.dia = 1;
        this.mes = 1;
        this.ano = 1990;
    }
    
    // construtor
    public Data( int dia, int mes, int ano ){
        this.setAno( ano );
        this.setMes( mes );
        this.setDia( dia );
    }
    
    // construtor de cópia
    public Data( Data outro ){
        this.dia = outro.dia;
        this.mes = outro.mes;
        this.ano = outro.ano;
    }
    
    // gets
    public int getDia(){
        return this.dia;
    }
    
    public int getMes(){
        return this.mes;
    }
    
    public int getAno(){
        return this.ano;
    }
    
    // sets
    public final void setAno( int ano ){
        if ( ano < 0 ){
            System.out.println( "\nErro no ano.\nInserindo valor default..." );
            this.ano = 1990;
        }
        else this.ano = ano;
    }
    
    public final void setMes( int mes ){
        if ( mes < 1 || mes > 12 ){
            System.out.println( "\nErro no mes.\nInserindo valor default..." );
            this.mes = 1;
        }
        else this.mes = mes;
    }
    
     public final void setDia( int dia ){
        if ( dia > 0  && checkMes( dia ) ) this.dia = dia;
	else{
            System.out.println("\nErro no dia.\nInserindo valor default...");
            this.dia = 1;
	}
    }
    
     // outras funções
    public boolean checkMes( int dia ){
	int [] meses;
        meses = new int[]{ 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31,30, 31 };
	
	if ( dia <= meses[ this.mes ] ){
		if ( anoBissexto( dia ) ) return true;
		else if ( this.mes != 2 ) return true;
	}
	return false;
    }
    
    public boolean anoBissexto( int dia ){
        return ( this.mes == 2 && dia == 29 && ( this.ano % 400 == 0 ||
                ( this.ano % 4 == 0 && this.ano % 100 != 0 ) ) );
    }
    
    public String toString(){
        return this.dia + "/" + this.mes + "/" + this.ano;
    }
}
