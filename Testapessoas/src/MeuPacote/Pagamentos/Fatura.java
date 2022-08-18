package MeuPacote.Pagamentos;

public class Fatura implements Pagamento{
	private double dValor;
	private int iQuantidade;
	private String sNome, sDescricao;
	
	public Fatura(double dValor, int iQuantidade, String sNome, String sDescricao) {
		super();
		this.dValor = dValor;
		this.iQuantidade = iQuantidade;
		this.sNome = sNome;
		this.sDescricao = sDescricao;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public double getValor() {return dValor;}
	public void setValor(double dValor) {this.dValor = dValor;}

	public int getQuantidade() {return iQuantidade;}
	public void setQuantidade(int iQuantidade) {this.iQuantidade = iQuantidade;}

	public String getNome() {return sNome;}
	public void setParteNumero(String sNome) {this.sNome = sNome;}

	public String getDescricao() {return sDescricao;}
	public void setDescricao(String sDescricao) {this.sDescricao = sDescricao;}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "Fatura [dValor=" + dValor + ", iQuantidade=" + iQuantidade + ", sNome=" + sNome
				+ ", sDescricao=" + sDescricao + "]";
	}

	public String formatDesc(int limit) {
		String FormatDesc = "'";
		for (int i = 1; i <= sDescricao.length(); i++)
			if (i%limit != 0) FormatDesc += sDescricao.charAt(i-1);
			else FormatDesc += sDescricao.charAt(i-1) + "\n";
		return FormatDesc + "'";
	}
	
	public double getPagamento() {
		return iQuantidade*dValor;
		}

}
