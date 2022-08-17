package MeuPacote;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Menu {
	
	public void executar(ArrayList<Empregado> empregados) {
		
		ArrayList<Fatura> faturas = new ArrayList<Fatura>();
		
		boolean paga = true;
		String sPagamentos = "", sOpcao;
		String parteNum, parteDesc; double valor; int qtd;
		char cOpte;
		while (paga == true) {
			sOpcao = JOptionPane.showInputDialog(null,
					"\n1 - Inserir uma fatura" +
					"\n2 - Exibir funcionários a pagar" +
					"\n3 - Exibir faturas pendentes" +
					"\n4 - Exibir todas as pendências" + 
					"\n5 - Realizar um pagamento" +
					"\n6 - Retornar");
			cOpte = sOpcao.charAt(0);
			
			switch(cOpte) {
			case '1': 
					  parteNum = JOptionPane.showInputDialog(null, "Num da fatura:");
					  parteDesc = JOptionPane.showInputDialog(null, "Descricao:");
					  qtd = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade:"));
					  valor = Double.parseDouble(JOptionPane.showInputDialog(null, "Valor por item:"));
					  Fatura f = new Fatura(valor, qtd, parteNum, parteDesc);
					  faturas.add(f);
					  JOptionPane.showMessageDialog(null, "Fatura adicionada");
					  break;
					  
			case '2': for (Empregado x : empregados) 
						sPagamentos += "\n" + x.dizerNome() + ": " + x.getPagamento() + "\n";
					  JOptionPane.showMessageDialog(null, sPagamentos);
					  sPagamentos = "";
			  		  break;
			  		  
			case '3': for (Fatura x : faturas) 
						sPagamentos += "\n" + x.getParteDescricao() + " - " + "Quantidade: " + x.getQuantidade() + " Valor total: "+ x.getPagamento() + "\n";
			  		  JOptionPane.showMessageDialog(null, sPagamentos);
			  		  sPagamentos = "";
					  break;
					  
			case '4': for (Empregado x : empregados) 
						sPagamentos += "\n" + x.dizerNome() + ": " + x.getPagamento() + "]\n";
			  		  for (Fatura x : faturas) 
			  			sPagamentos += "\n" + x.getParteDescricao() + ": " + x.getPagamento() + "]\n";
			  		  JOptionPane.showMessageDialog(null, sPagamentos);
			  		  sPagamentos = "";
					  break;
					  
			case '5': JOptionPane.showInputDialog(null, "Qual elemento deseja pagar?");
					  //sPagamentos.lines();
					  break;
					  
			case '6': paga = false;
					  new TestaPessoa().main(null); 
			  		  break;
			  		  
			}
			
		}
		
		
	}
	
	public void pagar() {
		
	}

}
