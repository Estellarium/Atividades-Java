package MeuPacote;

import java.util.Calendar;

public class Pessoas {  
	String sNome;
	int iAnoNasc;
	
	public Pessoas(String sNome, int iAnoNasc) {
		this.sNome = sNome;
		this.iAnoNasc = iAnoNasc;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	    public int getAnoNasc() {return iAnoNasc;}
		public void setAnoNasc(int iAnoNasc) {this.iAnoNasc = iAnoNasc;}
		
	    public String getNome() {return sNome;}
		public void setNome(String sNome) {this.sNome = sNome;}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@Override
	public String toString() {
		return " [Nome = " + sNome + ", Ano Nasc = " + iAnoNasc + 
                    ", Idade = " + calculaIdade();
	}
	
	public String dizerNome() {
		return sNome;
	}
	
	int calculaIdade() {
		int iIdade;
		int iAnoAtual = Calendar.getInstance().get(Calendar.YEAR);
		iIdade = iAnoAtual - getAnoNasc();
		return iIdade;
	}
	
	
}


