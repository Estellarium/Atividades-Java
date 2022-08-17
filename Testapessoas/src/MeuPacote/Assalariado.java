package MeuPacote;

public class Assalariado extends Empregado {
	private float fSalarioMensal;
	private float fDesconto;

	public Assalariado(String sNome, int iAnoNasc, String sNomeDept, float fSalarioMensal, float fDesconto) {
		super(sNome, iAnoNasc, sNomeDept);
		this.fSalarioMensal = fSalarioMensal;
		this.fDesconto = fDesconto;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public float getSalarioMensal() {return fSalarioMensal;}
		public void setSalarioMensal(float fSalarioMensal) {this.fSalarioMensal = fSalarioMensal;}
	
		public float getDesconto() {return fDesconto;}
		public void setDesconto(float fDesconto) {this.fDesconto = fDesconto;}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@Override
	public String toString() {
		return "Assalariado" + super.toString() + "\nSalario Mensal = " + fSalarioMensal + ", Desconto = " + fDesconto 
							 + String.format("\nSalario = R$%.2f", calculaSalario());
	}

	@Override
	protected double calculaSalario() {
		return (fSalarioMensal - fDesconto);
	}

	public double getPagamento() {
		return calculaSalario();
	}
	
}
