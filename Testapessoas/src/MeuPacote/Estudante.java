package MeuPacote;

public class Estudante extends Pessoas {
	private String sMatricula;
	private float fMedia, fNota1, fNota2;
	
	public Estudante(String sNome, int iAnoNasc, String sMatricula, float fNota1, float fNota2) {
		super(sNome, iAnoNasc);
		this.sMatricula = sMatricula;
		this.fMedia = 0;
		this.fNota1 = fNota1;
		this.fNota2 = fNota2;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		public String getMatricula() {return sMatricula;}
		public void setMatricula(String sMatricula) {this.sMatricula = sMatricula;}
		
		public float getMedia() {return fMedia;}
		public void setMedia(float fMedia) {this.fMedia = fMedia;}
		
		public float getNota1() {return fNota1;}
		public void setNota1(float fNota1) {this.fNota1 = fNota1;}
		
		public float getNota2() {return fNota2;}
		public void setNota2(float fNota2) {this.fNota2 = fNota2;}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@Override
	public String toString() {
		return "Estudante" +super.toString()+"\n[Matricula=" + sMatricula + ", Media=" + fMedia + ", Nota 1=" + fNota1 + ", Nota 2=" + fNota2 + "]";
	}
	
	public void calculeMedia() {
		fMedia = (fNota1+fNota2)/2;
	}
}
