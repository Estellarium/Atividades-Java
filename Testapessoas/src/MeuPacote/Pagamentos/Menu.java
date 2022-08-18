package MeuPacote.Pagamentos;

import java.util.ArrayList;

import javax.swing.*;

import MeuPacote.TestaPessoa;
import MeuPacote.Funcionarios.Empregado;

public class Menu {

	private JPanel Painel(JTextField ParteNum, JTextField Descricao, JTextField Valor, JTextField Quantd) {

		JPanel myPanel = new JPanel();
		myPanel.add(new JLabel("Insira os dados da fatura:"));
		myPanel.add(new JLabel("ID da fatura: "));
		myPanel.add(ParteNum);
		myPanel.add(new JLabel("Descrição: "));
		myPanel.add(Descricao);
		myPanel.add(new JLabel("Valor: "));
		myPanel.add(Valor);
		myPanel.add(new JLabel("Quantidade: "));
		myPanel.add(Quantd);
	
		return myPanel;
	
	}
	
	public void executar(ArrayList<Empregado> empregados) {
		
		ArrayList<Fatura> faturas = new ArrayList<Fatura>();
		JTextField ParteNum = new JTextField(8);
		JTextField Descricao = new JTextField(15);
		JTextField Valor = new JTextField(5);
		JTextField Quantd = new JTextField(3);
		
		JPanel myPanel = Painel(ParteNum, Descricao, Valor, Quantd);//new JPanel();
		
		boolean paga = true;
		String sPagamentos = "", sOpcao;
		String parteNum = "", parteDesc = ""; double valor = 0; int qtd = 0;
		char cOpte = 6;
		while (paga == true) {
			sOpcao = JOptionPane.showInputDialog(null,
					"\n1 - Inserir uma fatura" +
					"\n2 - Exibir funcionários a pagar" +
					"\n3 - Exibir faturas pendentes" +
					"\n4 - Exibir todas as pendências" + 
					"\n5 - Realizar um pagamento" +
					"\n6 - Retornar");

			try {cOpte = sOpcao.charAt(0);} 
			catch (StringIndexOutOfBoundsException e) 
			{JOptionPane.showMessageDialog(null, "Insira um valor!");}
			
			switch(cOpte) {
			case '1': 	try {
						JOptionPane.showMessageDialog(null, myPanel);
						parteNum = ParteNum.getText();
						parteDesc = Descricao.getText();
						qtd = Integer.parseInt(Quantd.getText());
						valor = Double.parseDouble(Valor.getText());} 

						catch(NumberFormatException e) 
						{JOptionPane.showMessageDialog(null, "Valor inválido");}
						
						Fatura f = new Fatura(valor, qtd, parteNum, parteDesc);
						faturas.add(f);
						JOptionPane.showMessageDialog(null, "Fatura adicionada");
						
						break;
					  
			case '2': 	for (Empregado x : empregados) 
							sPagamentos += "\n" + x.dizerNome() + ": " + x.getPagamento() + "\n";
						JOptionPane.showMessageDialog(null, sPagamentos);
						sPagamentos = "";
						break;
			  		  
			case '3': 	for (Fatura x : faturas) 
							sPagamentos += "\n" + x.getNome() + " - " + "Quantidade: " + x.getQuantidade() 
							+ " Valor total: "+ x.getPagamento() + "\n";
						JOptionPane.showMessageDialog(null, sPagamentos);
						sPagamentos = "";
						break;
					  
			case '4': 	for (Empregado x : empregados) 
							sPagamentos += "\n" + x.dizerNome() + ": " + x.getPagamento() + "\n";
						for (Fatura x : faturas) 
							sPagamentos += "\n" + x.getNome() + " - " + "Quantidade: " + x.getQuantidade() 
							+ " Valor total: "+ x.getPagamento() + "\n" 
							+ x.formatDesc(15) + "\n";
						JOptionPane.showMessageDialog(null, sPagamentos);
						sPagamentos = "";
						break;
					  
			case '5': 	String Input = JOptionPane.showInputDialog(null, "Escreva a quem, ou qual, deseja pagar:\n" + sPagamentos);
					  	for (Empregado x : empregados) 
							if (Input == x.dizerNome()) {empregados.remove(x); break;}
					  	for (Fatura x : faturas)
					  		if (Input == x.getNome()) {faturas.remove(x); break;}
					  	JOptionPane.showMessageDialog(null, "Não encontrado!");
					  	break;
					  
			case '6': 	paga = false;
						new TestaPessoa().main(null); 
						break;
			  		  
			}
			
		}
		
		
	}
	
	public void pagar() {
		
	}

}
