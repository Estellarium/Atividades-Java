package MeuPacote.Funcionarios;

import MeuPacote.Pessoas;
import MeuPacote.Pagamentos.Pagamento;

public abstract class Empregado extends Pessoas implements Pagamento{
	private String sNomeDept;

	public Empregado(String sNome, int iAnoNasc, String sNomeDept) {
		super(sNome, iAnoNasc);
		this.sNomeDept = sNomeDept;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public String getNomeDept() {return sNomeDept;}
		public void setNomeDept(String sNomeDept) {this.sNomeDept = sNomeDept;}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@Override
	public String toString() {
		return super.toString() + "\nNome Dept = " + sNomeDept;
	}

	protected abstract double calculaSalario();
	
	
	
	
}
