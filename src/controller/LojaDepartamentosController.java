package controller;

import java.util.List;

import javax.swing.JOptionPane;

import docarmo.ListaObject.ListaEncadeadaObj;
import model.Produto;

public class LojaDepartamentosController {

	ListaEncadeadaObj[] tabela;

	public LojaDepartamentosController() {
		tabela = new ListaEncadeadaObj[4];
		for (int i = 0; i < 4; i++) {
			tabela[i] = new ListaEncadeadaObj();
		}
	}
	

	public void run(int opc) {
		switch (opc) {
		case 1:
			Inserir();
			System.out.println("\nO Departamento foi Cadastrado\n");
			System.out.println("=====================================================================");
			break;
		case 2:
			Consultar();
			break;
		case 3: 
			Excluir();
			break;
		case 9:
			JOptionPane.showMessageDialog(null, "Programa finalizado");
			break;
		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida");
		} // FECHA SWITCH
	}
	

	private void Inserir() {

		Produto p = new Produto();
		int andar;
		do {
			andar = Integer.parseInt(JOptionPane.showInputDialog("Insira o andar (0 - 3)"));
		} while (andar < 0 || andar > 3);

		p.setAndar(andar);
		p.setNomeDp(JOptionPane.showInputDialog("Insira o Nome do Departamento"));
		p.setDescricao(JOptionPane.showInputDialog("Insira a descriçao"));

		int pos = HashMode(andar);

		if (tabela[pos].isEmpty()) {
			tabela[pos].addFirst(p);
		} else {
			try {
				tabela[pos].addLast(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private int HashMode(int andar) {
		int pos = andar % 4;
		return pos;
	}

	private int Consultar() {

		int andar;

		do {
			andar = Integer.parseInt(JOptionPane.showInputDialog("Insira o andar (0 - 3)"));
		} while (andar < 0 || andar > 3);

		int tam = tabela[andar].size();
		System.out.println("departamentos do andar " + andar + "\n");
		for (int i = 0; i < tam; i++) {
			Produto p = new Produto();
			try {
				p = (Produto) tabela[andar].get(i);
				System.out.println(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return andar;
	}

	private void Excluir() {

		int andar = Consultar();
		String nome = JOptionPane.showInputDialog("Digite o nome do Departamento");

		int tam = tabela[andar].size();
		boolean status = false;
		for (int i = 0; i < tam;) {
			Produto p = new Produto();
			try {
				p = (Produto) tabela[andar].get(i);
				if(p.getNomeDp().equals(nome)) {
					tabela[andar].remove(i);
					System.out.println("\n=====================================================================\n");
					System.out.println("O departamento " + nome + " foi excluido");
					break;
				}else if(i == (tam - 1)) {
					status = true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(status == true) {
			JOptionPane.showMessageDialog(null, "O departamento não foi encontrado");
		}
		System.out.println("=====================================================================");
	}
}
