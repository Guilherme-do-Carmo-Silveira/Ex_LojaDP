package view;

import javax.swing.JOptionPane;

import controller.LojaDepartamentosController;

public class main {

	public static void main(String[] args) {
		
	LojaDepartamentosController c = new LojaDepartamentosController();
		
		int opc = 0;
		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Departamento \n2 - Consultar Departamentos de um andar \n3 - Excluir Departamento \n9 - Finaliza"));
			c.run(opc);
		}while(opc != 9);
	}
}
