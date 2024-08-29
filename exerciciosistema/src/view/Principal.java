package view;


import javax.swing.JOptionPane;
import controller.RedesController;

public class Principal {
	public static void main (String [] args) {
		RedesController controle = new RedesController();
		int entrada = 0;
		while (entrada != 9) {
			entrada = Integer.parseInt(JOptionPane.showInputDialog("1 - IP \n"
					+ "2 - Ping\n9 - Sair"));
		
			switch (entrada) {
				
			case 1:
				controle.ip();
				break;
			case 2:
				System.out.println("Testando Conexão...");
				controle.ping();
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Programa Finalizado");
				break;
				
			default:
			JOptionPane.showMessageDialog(null,"Opção Inválida","Erro", JOptionPane.ERROR_MESSAGE);
			break;
			}
		}
	}
}
