package MeuPacote;

public class Fatura implements Pagamento{
	private double dValor;
	private int iQuantidade;
	private String sParteNumero, sParteDescricao;
	
	public Fatura(double dValor, int iQuantidade, String sParteNumero, String sParteDescricao) {
		super();
		this.dValor = dValor;
		this.iQuantidade = iQuantidade;
		this.sParteNumero = sParteNumero;
		this.sParteDescricao = sParteDescricao;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public double getValor() {return dValor;}
	public void setValor(double dValor) {this.dValor = dValor;}

	public int getQuantidade() {return iQuantidade;}
	public void setQuantidade(int iQuantidade) {this.iQuantidade = iQuantidade;}

	public String getParteNumero() {return sParteNumero;}
	public void setParteNumero(String sParteNumero) {this.sParteNumero = sParteNumero;}

	public String getParteDescricao() {return sParteDescricao;}
	public void setParteDescricao(String sParteDescricao) {this.sParteDescricao = sParteDescricao;}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String toString() {
		return "Fatura [dValor=" + dValor + ", iQuantidade=" + iQuantidade + ", sParteNumero=" + sParteNumero
				+ ", sParteDescricao=" + sParteDescricao + "]";
	}
	
	public double getPagamento() {
		return iQuantidade*dValor;
		}

}
