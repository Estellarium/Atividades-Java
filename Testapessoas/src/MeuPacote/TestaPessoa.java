package MeuPacote;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class TestaPessoa {
	
	public static void main(String[] args) {
		/*Pessoas p = new Pessoas("Maria",1980);
		p.setNome("Mariana");
		p.setAnonasc(1970);
		System.out.printf("nome=%s anonasc=%d\n", p.getNome(), p.getAnonasc());
		System.out.println(p.toString());
		
		Estudante x = new Estudante("Gabriel", 1999, "123456",8,9);
		x.calculeMedia();
		System.out.println(x.toString());*/
		
		String[] saNomes = {"Alberto","Beatriz","Carla","Daniel","Ezequiel","Fábio","Giovanna","Hector","Iris","Joao", "Katherine", "Lucas", "Maria",
							"Nathan", "Oswaldo", "Paula", "Quezia", "Rosana", "Sergio", "Tyrone", "Ulisses", "Valeria", "Wagner", "Xenia", "Yvone", "Zelda"};
		String[] saDepts = {"Dept A", "Dept B", "Dept C"};
		int iNomesL = saNomes.length - 1, iDeptsL = saDepts.length - 1;
		Random rd = new Random();
		
		String sEmpregados = "", sOpcao;
		ArrayList<Empregado> empregados = new ArrayList<Empregado>();
		char cOpte;
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
					"\n8 - Pagar Pendências" +
					"\n9 - Sair");
			cOpte = sOpcao.charAt(0);
			
			switch(cOpte) {
			case '1': Empregado a = new Assalariado	(
					  /*Nome, Ano de Nascimento*/	saNomes[rd.nextInt(0,iNomesL)], rd.nextInt(1960,2003),
					  /*Departamento           */	saDepts[rd.nextInt(0,iDeptsL)], 
					  /*Salário, Desconto      */	rd.nextInt(1100,3000), rd.nextInt(100,200));
					  empregados.add(a);
					  break;
				
			case '2': Empregado h = new Horista		(
					  /*Nome, Ano de Nascimento*/	saNomes[rd.nextInt(0,iNomesL)], rd.nextInt(1960,2003), 
					  /*Departamento           */	saDepts[rd.nextInt(0,iDeptsL)], 
					  /*Horas, Salário         */	rd.nextInt(20,40), rd.nextInt(20,80));
			  		  empregados.add(h);
			  		  break;
				
			case '3': Empregado c = new Comissionado(//Nome, Ano de Nascimento, Departamento, Bruto de Vendas, Taxa de Comissão, Bônus.
					  /*Nome, Ano de Nascimento */	saNomes[rd.nextInt(0,iNomesL)], rd.nextInt(1960,2003), 
					  /*Departamento            */	saDepts[rd.nextInt(0,iDeptsL)], 
					  /*Bruto de Vendas, Taxa de*/  rd.nextInt(10000,50000), rd.nextFloat(0.01f,0.02f), rd.nextInt(500,1000));
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
