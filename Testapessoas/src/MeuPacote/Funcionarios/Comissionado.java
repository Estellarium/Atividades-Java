package MeuPacote.Funcionarios;

public class Comissionado extends Empregado {
	private float fBrutoVendas;
	private float fTaxaComissao;
	private float fBonus;

	public Comissionado(String sNome, int iAnoNasc, String sNomeDept, float fBrutoVendas, float fTaxaComissao,
			float fBonus) {
		super(sNome, iAnoNasc, sNomeDept);
		this.fBrutoVendas = fBrutoVendas;
		this.fTaxaComissao = fTaxaComissao;
		this.fBonus = fBonus;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public float getBrutoVendas() {return fBrutoVendas;}
		public void setBrutoVendas(float fBrutoVendas) {this.fBrutoVendas = fBrutoVendas;}
	
		public float getTaxaComissao() {return (fTaxaComissao*100);}
		public void setTaxaComissao(float fTaxaComissao) {this.fTaxaComissao = fTaxaComissao;}
	
		public float getBonus() {return fBonus;}
		public void setBonus(float fBonus) {this.fBonus = fBonus;}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@Override
	public String toString() {
		return "Comissionado" + super.toString() + "\nBruto Vendas = " + fBrutoVendas + 
				String.format(", Taxa Comissao = %.2f", getTaxaComissao()) + "%, Bonus = " + fBonus 
			  + String.format("\nSalario = R$%.2f", calculaSalario());
	}

	@Override
	protected double calculaSalario() {
		return ((fBrutoVendas*fTaxaComissao)+fBonus);
	}
	
	public double getPagamento() {
		return calculaSalario();
	}

}
