package MeuPacote;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

import MeuPacote.Funcionarios.Assalariado;
import MeuPacote.Funcionarios.Comissionado;
import MeuPacote.Funcionarios.Empregado;
import MeuPacote.Funcionarios.Horista;
import MeuPacote.Pagamentos.Menu;

public class TestaPessoa {
	
	public static void main(String[] args) {
		
		String[] saNomes = {"Alberto","Beatriz","Carla","Daniel","Ezequiel","Fábio","Giovanna","Hector","Iris","Joao", "Katherine", "Lucas", "Maria",
							"Nathan", "Oswaldo", "Paula", "Quezia", "Rosana", "Sergio", "Tyrone", "Ulisses", "Valeria", "Wagner", "Xenia", "Yvone", "Zelda"};
		String[] saDepts = {"Dept A", "Dept B", "Dept C"};
		int iNomesL = saNomes.length - 1, iDeptsL = saDepts.length - 1;
		Random rd = new Random();
		
		String sEmpregados = "", sOpcao;
		ArrayList<Empregado> empregados = new ArrayList<Empregado>();
		char cOpte = 9;
		boolean menu = true;
		
		while (menu == true) {
			sOpcao = JOptionPane.showInputDialog(null,
					"\n1 - Insere um Assalariado" +
					"\n2 - Insere um Horista" +
					"\n3 - Insere um Comissionado" +
					"\n4 - Exibe todos os empregados" + 
					"\n5 - Exibe somente os assalariados" +
					"\n6 - Exibe somente os horistas" +
					"\n7 - Exibe somente os comissionados" +
					"\n8 - Faturas e Pagamentos" +
					"\n9 - Sair");
			try {cOpte = sOpcao.charAt(0);} 
			catch (StringIndexOutOfBoundsException e) 
			{JOptionPane.showMessageDialog(null, "Insira um valor!");}
			
			switch(cOpte) {
			case '1': Empregado a = new Assalariado	(
					  /*Nome, Ano de Nascimento*/	saNomes[rd.nextInt(iNomesL)], (rd.nextInt(2003-1960)+1960),
					  /*Departamento           */	saDepts[rd.nextInt(iDeptsL)], 
					  /*Salário, Desconto      */	(rd.nextInt(3000-1100)+1100), (rd.nextInt(200-100)+100));
					  empregados.add(a);
					  break;
				
			case '2': Empregado h = new Horista		(
					  /*Nome, Ano de Nascimento*/	saNomes[rd.nextInt(iNomesL)], (rd.nextInt(2003-1960)+1960), 
					  /*Departamento           */	saDepts[rd.nextInt(iDeptsL)], 
					  /*Horas, Salário         */	(rd.nextInt(40-20)+20), (rd.nextInt(80-20)+20));
			  		  empregados.add(h);
			  		  break;
				
			case '3': Empregado c = new Comissionado(//Nome, Ano de Nascimento, Departamento, Bruto de Vendas, Taxa de Comissão, Bônus.
					  /*Nome, Ano de Nascimento */	saNomes[rd.nextInt(iNomesL)], (rd.nextInt(2003-1960)+1960), 
					  /*Departamento            */	saDepts[rd.nextInt(iDeptsL)], 
					  /*Bruto de Vendas, Taxa de*/  (rd.nextInt(50000-10000)+10000), (rd.nextFloat()/50), (rd.nextInt(1000-500)+500));
					  /*Comissão, Bônus         */			
			  		  empregados.add(c);
			  		  break;
				
			case '4': for (Empregado x : empregados) 
						sEmpregados += "\n" + x.toString() + "]\n";
					  JOptionPane.showMessageDialog(null, sEmpregados);
					  sEmpregados = "";
					  break;
				
			case '5': for (Empregado x : empregados) 
						if (x instanceof Assalariado) 
							sEmpregados += "\n" + x.toString() + "]\n";
			  		  JOptionPane.showMessageDialog(null, sEmpregados);
			  		  sEmpregados = "";
			  		  break;
				
			case '6': for (Empregado x : empregados) 
						if (x instanceof Horista) 
							sEmpregados += "\n" + x.toString() + "]\n";
					  JOptionPane.showMessageDialog(null, sEmpregados);
					  sEmpregados = "";
					  break;
				
			case '7': for (Empregado x : empregados) 
						if (x instanceof Comissionado) 
							sEmpregados += "\n" + x.toString() + "]\n";
	  		  		  JOptionPane.showMessageDialog(null, sEmpregados);
	  		  		  sEmpregados = "";
	  		  		  break;
	  		  		  
			case '8': menu = false; Menu m = new Menu(); m.executar(empregados);
				
			case '9': System.exit(0);
			}
		}
	}

}
