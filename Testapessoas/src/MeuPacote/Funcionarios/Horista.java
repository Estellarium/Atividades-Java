package MeuPacote.Funcionarios;

public class Horista extends Empregado {
	private int iHorasTrabalhadas;
	private float fSalarioHora;

	public Horista(String sNome, int iAnoNasc, String sNomeDept, int iHorasTrabalhadas, float fSalarioHora) {
		super(sNome, iAnoNasc, sNomeDept);
		this.iHorasTrabalhadas = iHorasTrabalhadas;
		this.fSalarioHora = fSalarioHora;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public int getHorasTrabalhadas() {return iHorasTrabalhadas;}
		public void setHorasTrabalhadas(int iHorasTrabalhadas) {this.iHorasTrabalhadas = iHorasTrabalhadas;}
	
		public float getSalarioHora() {return fSalarioHora;}
		public void setSalarioHora(float fSalarioHora) {this.fSalarioHora = fSalarioHora;}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@Override
	public String toString() {
		return "Horista" + super.toString() + "\nHoras Trabalhadas = " + iHorasTrabalhadas + ", Salario Hora = " + fSalarioHora 
					     + String.format("\nSalario = R$%.2f", calculaSalario());
	}

	@Override
	protected double calculaSalario() {
		return (iHorasTrabalhadas*fSalarioHora);
	}
	
	public double getPagamento() {
		return calculaSalario();
	}

}
